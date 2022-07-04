package com.singboardWeb.singleweb.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true, nullable = false, length = 100)
	private String username;
	
	@Column(length = 200)
	private String password;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@CreationTimestamp 
	private Timestamp createDate;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	@Enumerated(EnumType.STRING)
	private RootType oauth;

}
