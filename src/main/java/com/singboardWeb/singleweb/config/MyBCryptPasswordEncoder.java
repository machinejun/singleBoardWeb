package com.singboardWeb.singleweb.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyBCryptPasswordEncoder extends BCryptPasswordEncoder{
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		System.out.println("rawPassword: " + rawPassword);
		System.out.println("encodedPassword: " + encodedPassword);
		return super.matches(rawPassword, encodedPassword);
	}
}
