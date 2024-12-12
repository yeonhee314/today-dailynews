package com.yeonhee.dailynews.service;

import com.yeonhee.dailynews.vo.UserVO;

public interface UserService {
	int selectByCount();
	void addToUser(UserVO userVO);
}
