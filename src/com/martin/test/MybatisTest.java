package com.martin.test;

import java.util.List;

import javax.swing.plaf.ListUI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.martin.mapper.UserMapper;
import com.martin.pojo.User;
import com.martin.util.Page;

import javafx.scene.control.ListCell;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 新增一百条数据方便观察
	 */
//	@Test
	public void testAdd() {
		for(int i = 0 ; i < 100 ; i++) {
			User user = new User();
			user.setName("user "+i);
			user.setPassword("123456");
			userMapper.add(user);
		}
	}
	
	/**
	 * 测试查询总数
	 */
	@Test
	public void testTotal() {
		int total = userMapper.count();
		System.out.println(total);
	}
	/**
	 * 
	 * 	 测试分页查询
	 */
	@Test
	public void testList() {
		Page page = new Page();
		page.setStart(2);
		page.setCount(3);
		List<User> users = userMapper.list(page);
		for(User user:users) {
			System.out.println(user);
		}
	}
}
