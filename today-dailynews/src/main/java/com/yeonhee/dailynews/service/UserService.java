package com.yeonhee.dailynews.service;

import java.util.List;

import com.yeonhee.dailynews.vo.UserVO;

public interface UserService {
	int selectByCount();
	void addToUser(UserVO userVO);
	List<UserVO> selectByUsers();
}
