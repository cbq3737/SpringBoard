package com.example.Boar.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Boar.repository.UserRepository;
import com.example.Boar.repository.UserRepositoryImpl;
import com.example.Boar.repository.UserVo;

public class userServiceImpl implements userService {
	
	UserRepository userRepository; 
	
	@Override	//생성자  -> 우선적으로 가장먼저 생성이 됨.
	public List<UserVo> userlist() {
		List<UserVo> userlist = userRepository.selectAll();
		System.out.println("게시물 목록: "+ userlist);
		return userlist;
	}

	@Override
	public boolean insertMessage(UserVo vo) {
	
		userRepository= new UserRepositoryImpl();
		boolean isSuccess =userRepository.insert(vo) ==1;
		System.out.println("insert Success?? "+ isSuccess);
		return isSuccess;
	}

	@Override
	public boolean deleteMessage(UserVo vo) {
		userRepository= new UserRepositoryImpl();
		boolean isSuccess = userRepository.delete(vo) == 1; // 한개만 지웠다
		// 삭제가 안되었을 때의 처리
		System.out.println("delete success?" + isSuccess);
		return isSuccess;		
	}

	@Override
	public boolean UpdateMessage(UserVo vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
