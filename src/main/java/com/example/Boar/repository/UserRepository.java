package com.example.Boar.repository;

import java.util.List;

public interface UserRepository {
	public List<UserVo> selectAll();
	public int insert(UserVo vo);
	public int delete(UserVo vo);
	public int update(UserVo vo);
	
}
