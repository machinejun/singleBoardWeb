package com.singboardWeb.singleweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.singboardWeb.singleweb.model.RootType;
import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.service.UserService;

@Controller
public class UserController {
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession httpSession;
	
	
	@GetMapping("/auth/loginform")
	public String loginForm() {
		System.out.println("hello");
		return "user/login_form";
	}
	
	@GetMapping("/auth/joinform")
	public String joinForm() {
		System.out.println("hello");
		return "user/join_form";
	}
	
	@PostMapping("/auth/joinProc")
	public String joinUser( User user){
		user.setOauth(RootType.Normal);
		User reponseUser = userService.saveUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		httpSession.invalidate();
		return "redirect:/";
	}
	


}
