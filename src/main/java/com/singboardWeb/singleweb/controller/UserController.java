package com.singboardWeb.singleweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/auth/loginform")
	public String loginForm() {
		System.out.println("hello");
		return "user/login_form";
	}
	
	@GetMapping("/user/joinform")
	public String joinForm() {
		System.out.println("hello");
		return "user/join_form";
	}
	

}
