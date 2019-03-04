package com.martin.mapper;

import java.util.List;

import com.martin.pojo.User;

public interface UserMapper {
	
	public int add(User user);
	
	public int delete(int id);
	
	public int update(User user);
	
	public User get(int id);
	
	public List<User> listAll();
	
	public int count();
}
