package com.martin.mapper;

import java.util.List;
import java.util.Map;

import com.martin.pojo.Course;
import com.martin.pojo.User;

public interface CourseMapper {
	
	public int add(Course course);  
    
    public void delete(int id);  
         
    public Course get(int id);  
       
    public int update(Course course);   
          
    public List<Course> list(Map m);
    
    public int total(User c);  
}
