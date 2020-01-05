package com.example.demo.controller;

import java.security.Principal;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin("*")
//@RequestMapping("/api/user")
public class UserController {
	
	@RequestMapping("/api/user")
	
	public Principal user(Principal user) {
		return user;
	}
	
	
	
	
}
