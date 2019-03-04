package com.martin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.martin.pojo.User;
import com.martin.service.UserService;

@Controller
@RequestMapping("")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("listUser")
	public ModelAndView listUser() {
		System.out.println("i ma here");
		ModelAndView mav = new ModelAndView();
		
		List<User> users = userService.list();
		//放入数据
		mav.addObject("users",users);
		//设置显示页面
		mav.setViewName("listUser");
		return mav;
	}
}
