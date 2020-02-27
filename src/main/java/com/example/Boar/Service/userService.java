package com.example.Boar.Service;

import java.util.List;

import com.example.Boar.repository.UserVo;

public interface userService {
	public List<UserVo> userlist();
	public boolean insertMessage(UserVo vo);
	public boolean deleteMessage(UserVo vo);
	public boolean UpdateMessage(UserVo vo);
}
