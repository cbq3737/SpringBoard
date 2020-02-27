package com.example.Boar.controller;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.example.Boar.Service.userService;
import com.example.Boar.Service.userServiceImpl;
import com.example.Boar.repository.UserRepositoryImpl;
import com.example.Boar.repository.UserVo;

@Controller
@RequestMapping("/User")
public class UserController {
	
	userService userService;
	
	@RequestMapping("/userlist")
	public String select(Model model)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet  rs = null;
		
		List<UserVo> userlist = new ArrayList<UserVo>();
		
		try {
			ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
			DataSource ds=(DataSource)ctx.getBean("dataSource");
			conn = ds.getConnection();
			stmt= conn.createStatement();
			
			String sql ="SELECT no, name, password, content, regdate " +
					"FROM Userbook ORDER BY regdate DESC";
			
			System.out.println("SQL: "+ sql);
			
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				String regdate = rs.getString(5);
			
				UserVo vo =new UserVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setContent(content);
				vo.setRegdate(regdate);
				userlist.add(vo);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			try
			{
				conn.close();
				stmt.close();
				rs.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		model.addAttribute("userlist",userlist);
		return "User/userlist"; 
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute UserVo vo)
	{
		userService = new userServiceImpl();
		System.out.println("삽입 column: "+vo);
		boolean isSuccess = userService.insertMessage(vo);	
		System.out.println("정상적으로 추가되었습니다.");
		
		return "redirect:/User/userlist";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam String no,Model model )
	{
		model.addAttribute("no",no);
		return "User/delete";	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@ModelAttribute UserVo vo)
	{
		userService = new userServiceImpl();
		System.out.println("삭제 column: "+vo );
		boolean isSuccess =userService.deleteMessage(vo);
		if(isSuccess)
		{
			System.out.println("정상적으로 삭제 되었습니다.");
		}
		else
		{
			System.out.println("정상적으로 삭제 되지 않았습니다.");
		}
		return "redirect:/User/userlist";
	}
	@RequestMapping(value="/updateform",method=RequestMethod.POST)
	public String update(@ModelAttribute UserVo vo)
	{
		return "redirect:/User/userlist";
	}
}
