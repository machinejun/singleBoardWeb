package com.singboardWeb.singleweb.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SinglewebConfig extends WebSecurityConfigurerAdapter{
	
	@Bean     //Ioc가 된다 필요할 때 가져와서 쓰면 된다.
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests() 
		.antMatchers("/","/js/**","/css/**", "/image/**" ,"/auth/**", "/dummy/**").permitAll() 
		.anyRequest().authenticated() 
		.and()
		.formLogin()
		.loginPage("/auth/loginform")
		.loginProcessingUrl("/auth/loginProc") 
		.defaultSuccessUrl("/")
		.failureHandler(new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
			
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().println("<script>alert('아이디&비빌번호 wrong'); history.back();</script>");
				response.getWriter().flush();		
			}
		}); 
	}
	

	
	
}
		
	

