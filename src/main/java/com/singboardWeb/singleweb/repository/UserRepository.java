package com.singboardWeb.singleweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singboardWeb.singleweb.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	User findByUsername(String username);
}
