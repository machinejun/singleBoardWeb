package com.singboardWeb.singleweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singboardWeb.singleweb.model.RoleType;
import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		user.setRole(RoleType.User);
		userRepository.save(user);
		return user;
	}

}
