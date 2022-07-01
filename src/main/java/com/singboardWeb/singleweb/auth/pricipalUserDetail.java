package com.singboardWeb.singleweb.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.singboardWeb.singleweb.model.User;

public class PricipalUserDetail implements UserDetails{
	
	private User user;
	private int id;
	
	public PricipalUserDetail(User user) {
		this.user = user;
		this.id = user.getId();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collections = new ArrayList<GrantedAuthority>();
		collections.add(new GrantedAuthority() {
			@Override
			public String getAuthority() {
				
				return "ROLE_" + user.getRole();
			}
		});
		return collections;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}
	
	@Bean
	public int getid() {
		return user.getId();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
