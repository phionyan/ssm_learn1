package com.martin.service;

import java.util.List;

import com.martin.pojo.User;
import com.martin.util.Page;

public interface UserService {
	
	public List<User> list();
	
	public int count();
	
	public List<User> list(Page page);
}
