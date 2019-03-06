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
	UserMapper userMapper;
	
	@Override
	/**
	 * 返回所有用户信息
	 */
	public List<User> list() {
		
		return userMapper.listAll();
	}

	@Override
	/**
	 *查询总用户数 
	 */
	public int count() {
		
		return userMapper.count();
	}

	@Override
	/**
	 * 分页返回用户信息
	 */
	public List<User> list(Page page) {
		
		return userMapper.list(page);
	}

	@Override
	public void add(User user) {
		userMapper.add(user);
	}

	@Override
	/**
	 * 删除用户
	 */
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public void delete(User user) {
		userMapper.delete(user.getId());
	}

	@Override
	public User get(int id) {
		User user = userMapper.get(id);
		return user;
	}	
}
