package com.yeonhee.dailynews.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeonhee.dailynews.dao.UserDAO;
import com.yeonhee.dailynews.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	public int selectByCount() {
		int count = 0;
		try {
			count = userDAO.selectByCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void addToUser( UserVO userVO) {
		try {
			userDAO.addToUser(userVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserVO> selectByUsers() {
		List<UserVO> users = null;
		try {
			users = userDAO.selectByUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}