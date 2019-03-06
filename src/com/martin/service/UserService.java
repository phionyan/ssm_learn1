package com.martin.service;

import java.util.List;

import com.martin.pojo.Course;
import com.martin.pojo.User;
import com.martin.util.Page;

public interface UserService {
	
	public List<User> list();
	
	public int count();
	
	public List<User> list(Page page);
	
	public void add(User user);
	public void update(User user);
	public void delete(User user);
	public User get(int id);
}
