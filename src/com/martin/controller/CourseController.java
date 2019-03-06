package com.martin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.martin.mapper.CourseMapper;
import com.martin.pojo.Course;
import com.martin.pojo.User;
import com.martin.service.CourseService;
import com.martin.service.UserService;
import com.martin.util.Page;


@Controller
@RequestMapping("")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CourseMapper courseMapper;
	
	
	
	/**
	 * 接受分页信息注入
	 * @param page
	 * @return
	 */
	@RequestMapping("listSomeCourse")
	public ModelAndView listUser(Page page,User user) {
		ModelAndView mav = new ModelAndView();
		//System.out.println(user);
		PageHelper.offsetPage(page.getStart(),5);
		Map map = new HashMap();
		user=userService.get(user.getId());
		System.out.println(page);
		map.put("user", user);
		map.put("page", page);
		System.out.println(user+"222");
		//List<Course> courses = courseService.list(map);
		List<Course> courses = courseMapper.list(map);
		
		int total = (int) new PageInfo<>(courses).getTotal();
		
		page.caculateLast(total);
		//System.out.println(courses.size());
		//System.out.println(user);
		//放入数据
		mav.addObject("courses",courses);
		mav.addObject("user",user);
		//设置显示页面
		mav.setViewName("listSomeCourse");
		
		return mav;
	}
	
	@RequestMapping("addCourse")
	public ModelAndView addCourse(Course course){
		//System.out.println(course);
		courseService.add(course);
		ModelAndView mav = new ModelAndView("redirect:/listSomeCourse?id="+course.getUser().getId());
	    return mav;
	}	
	@RequestMapping("deleteCourse")
	public ModelAndView deleteCourse(Course course){
		course = courseService.get(course.getId());
		courseService.delete(course);
		ModelAndView mav = new ModelAndView("redirect:/listSomeCourse?id="+course.getUser().getId());
		return mav;
	}	
	@RequestMapping("editCourse")
	public ModelAndView editCourse(Course course){
		Course c= courseService.get(course.getId());
		ModelAndView mav = new ModelAndView("editCourse");
		mav.addObject("c", c);
		return mav;
	}	
	@RequestMapping("updateCourse")
	public ModelAndView updateCourse(Course course){
		courseService.update(course);
		ModelAndView mav = new ModelAndView("redirect:/listCourse?id="+course.getUser().getId());
		return mav;
	}	

}
