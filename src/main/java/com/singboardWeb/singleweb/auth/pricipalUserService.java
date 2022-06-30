package com.singboardWeb.singleweb.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.repository.UserRepository;

public class pricipalUserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();
		
		return new pricipalUserDetail(user);
	}

}
