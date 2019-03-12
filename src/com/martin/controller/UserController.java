package com.martin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
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
	@RequestMapping("addUser")
	public ModelAndView addUser(User user) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject(user);
		mav.setViewName("redirect:/listSomeUser?");
		
		return mav;
	}
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(User user) {
		ModelAndView mav = new ModelAndView();
		userService.delete(user);
		mav.setViewName("redirect:/listSomeUser");
		return mav;
	}
	
	@RequestMapping("editUser")
	public ModelAndView editUser(User user) {
		ModelAndView mav = new ModelAndView();
		User u = userService.get(user.getId());
		mav.addObject("u", u);
		return mav;
	}
	@RequestMapping("updateUser")
	public ModelAndView updateUser(User user) {
		ModelAndView mav = new ModelAndView();
		userService.update(user);
		mav.setViewName("redirect:/listSomeUser");
		return mav;
	}
	
	@ResponseBody
    @RequestMapping("/submitUser")
    public String submitUser(@RequestBody User user) {
        System.out.println("SSM接受到浏览器提交的json，并转换为User对象:"+user);
        return "ok";
    }
     
    @ResponseBody
    @RequestMapping("/getOneUser")
    public String getOneUser() {
         User user = new User();
         user.setId(10);
         user.setName("第10个用戶");
         user.setPassword("123456");
         JSONObject json= new JSONObject();
         json.put("user", JSONObject.toJSON(user));
         return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyUser")
    public String getManyUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("用戶名称:"+i);
            user.setPassword("123456");
            users.add(user);
        }
 
        return JSONObject.toJSON(users).toString();
    }

}
