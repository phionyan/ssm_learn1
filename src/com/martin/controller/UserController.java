package com.martin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.martin.pojo.User;
import com.martin.service.UserService;
import com.martin.util.Page;

@Controller//声明为一个控制器类
@RequestMapping("")//声明访问到这个控制器的路径,""为根目录
public class UserController {
	
	//设置为自动装载
	@Autowired
	UserService userService;
	
	//匹配请求路径
	@RequestMapping("listUser")
	public ModelAndView listUser() {
		ModelAndView mav = new ModelAndView();
		
		List<User> users = userService.list();
		//放入数据
		mav.addObject("users",users);
		//设置显示页面
		mav.setViewName("listUser");
		return mav;
	}
	
	/**
	 * 接受分页信息注入
	 * @param page
	 * @return
	 */
	@RequestMapping("listSomeUser")
	public ModelAndView listUser(Page page) {
		ModelAndView mav = new ModelAndView();
		
//		List<User> users = userService.list(page);
		PageHelper.offsetPage(page.getStart(),5);
		List<User> users = userService.list();
		
//		int total = userService.count();
		int total = (int) new PageInfo<>(users).getTotal();
		
		page.caculateLast(total);
		
		//放入数据
		mav.addObject("users",users);
		//设置显示页面
		mav.setViewName("listSomeUser");
		
		return mav;
	}
}
