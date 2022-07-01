package com.singboardWeb.singleweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.singboardWeb.singleweb.model.RoleType;
import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User saveUser(User user) {
		String encodePw = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePw);
		user.setRole(RoleType.User);
		userRepository.save(user);
		return user;
	}
	
	@Transactional(readOnly = true)
	public User findById(int userid) {
		User user = userRepository.findById(userid).orElseThrow(() -> {
			return new RuntimeException("해당하는 유저가 없습니다");
		});
		return user;
	}
	
	

}
