package com.yeonhee.dailynews.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.yeonhee.dailynews.vo.UserVO;

@Mapper
public interface UserDAO {
	int selectByCount() throws SQLException;
	void addToUser(UserVO userVO) throws SQLException;
}
