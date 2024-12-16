package com.yeonhee.dailynews.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yeonhee.dailynews.vo.UserVO;

@Mapper
public interface UserDAO {
	int selectByCount() throws SQLException;
	void addToUser(UserVO userVO) throws SQLException;
	List<UserVO> selectByUsers() throws SQLException;
}
