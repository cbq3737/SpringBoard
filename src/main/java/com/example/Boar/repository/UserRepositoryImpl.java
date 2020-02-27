package com.example.Boar.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;


public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<UserVo> selectAll() {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet  rs = null;
//		
//		List<UserVo> userlist = new ArrayList<UserVo>();
//		
//		try {
//			ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
//			DataSource ds=(DataSource)ctx.getBean("dataSource");
//			conn = ds.getConnection();
//			stmt= conn.createStatement();
//			
//			String sql ="SELECT no, name, password, content, regdate " +
//					"FROM Userbook ORDER BY regdate DESC";
//			
//			System.out.println("SQL: "+ sql);
//			
//			rs = stmt.executeQuery(sql);
//			while(rs.next())
//			{
//				Long no = rs.getLong(1);
//				String name = rs.getString(2);
//				String password = rs.getString(3);
//				String content = rs.getString(4);
//				String regdate = rs.getString(5);
//			
//				UserVo vo =new UserVo();
//				vo.setNo(no);
//				vo.setName(name);
//				vo.setPassword(password);
//				vo.setContent(content);
//				vo.setRegdate(regdate);
//				userlist.add(vo);
//			}
//		}
//		catch(SQLException e)
//		{
//			e.printStackTrace();
//		}finally 
//		{
//			try
//			{
//				conn.close();
//				stmt.close();
//				rs.close();
//			}
//			catch(SQLException e)
//			{
//				e.printStackTrace();
//			}
//		}
		return null;
	}

	@Override
	public int insert(UserVo vo) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		int insertedCount=0;
		String sql ="INSERT INTO Userbook" + "(name, password, content)"+" VALUES(?,?,?)";
		try
		{
			ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
			DataSource ds=(DataSource)ctx.getBean("dataSource");
			conn =ds.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());//값을 받아오고 나서 값을 세팅해주기에 preparedstatement를 사용한다.
			pstmt.setString(2,vo.getPassword());
			pstmt.setString(3,vo.getContent());
			
			insertedCount =pstmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return insertedCount;
	}

	@Override
	public int delete(UserVo vo) {
		Connection conn= null;
		PreparedStatement pstmt= null;
		int deletedCount=0;
		String sql ="DELETE FROM Userbook" + " WHERE no = ? AND password = ?";
		try
		{
			ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
			DataSource ds=(DataSource)ctx.getBean("dataSource");
			conn =ds.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setLong(1,vo.getNo());
			pstmt.setString(2,vo.getPassword());//값을 받아오고 나서 값을 세팅해주기에 preparedstatement를 사용한다.
			
			deletedCount =pstmt.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return deletedCount;
	}

	@Override
	public int update(UserVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
