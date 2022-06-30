package com.singboardWeb.singleweb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singboardWeb.singleweb.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	Optional<User> findByUsername(String username);
}
