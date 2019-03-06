package com.martin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.mapper.CourseMapper;
import com.martin.pojo.Course;
import com.martin.pojo.User;
import com.martin.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseMapper courseMapper;
	
	
	@Override
	public List<Course> list(Map map) {
		List<Course> courses = courseMapper.list(map);
		return courses;
	}

	@Override
	public int total(User user) {
		int total = courseMapper.total(user);
		return 0;
	}

	@Override
	public void add(Course course) {
		courseMapper.add(course);
	}

	@Override
	public void update(Course course) {
		courseMapper.update(course);
	}

	@Override
	public void delete(Course course) {
		courseMapper.delete(course.getId());
	}
	
	@Override
	public Course get(int id) {
		Course course = courseMapper.get(id);
		return course;
	}
}
