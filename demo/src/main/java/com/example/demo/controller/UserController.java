package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	public String getUser(@PathVariable int userId,Model model) {
		model.addAttribute("user", userMapper.getUserById(userId).getUserName());
		return "index";
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "hello";
	}
	@RequestMapping(value="/addUser/{userName}/{age}",method=RequestMethod.GET)
	@ResponseBody
	public int addUser(@PathVariable String userName,@PathVariable int age) {
		User user = new User();
		user.setAge(age);
		user.setUserName(userName);
		return userMapper.saveUser(user );
	}
}
