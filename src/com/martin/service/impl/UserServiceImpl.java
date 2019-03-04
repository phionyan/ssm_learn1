package com.martin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.mapper.UserMapper;
import com.martin.pojo.User;
import com.martin.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper UserMapper;
	
	@Override
	public List<User> list() {
		
		return UserMapper.listAll();
	}
	
}
