package com.martin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.mapper.UserMapper;
import com.martin.pojo.User;
import com.martin.service.UserService;
import com.martin.util.Page;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper UserMapper;
	
	@Override
	/**
	 * 返回所有用户信息
	 */
	public List<User> list() {
		
		return UserMapper.listAll();
	}

	@Override
	/**
	 *查询总用户数 
	 */
	public int count() {
		
		return UserMapper.count();
	}

	@Override
	/**
	 * 分页返回用户信息
	 */
	public List<User> list(Page page) {
		
		return UserMapper.list(page);
	}
	
}
