package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserService;

@RestController
//@CrossOrigin("*")
//@RequestMapping("/api/user")
public class UserController extends CrudController<User, Long> {
	
	@RequestMapping("/api/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@Autowired
	private UserService userservice;
	public void add(@RequestBody User user) {
		userservice.add(user);
	}
	
}
