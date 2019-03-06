package com.martin.service;

import java.util.List;
import java.util.Map;

import com.martin.pojo.Course;
import com.martin.pojo.User;


public interface CourseService {
	
	List<Course> list(Map map);
	int total(User user);

	void add(Course course);
	void update(Course course);
	void delete(Course course);
	Course get(int id);
}
