package com.singboardWeb.singleweb.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.singboardWeb.singleweb.auth.PricipalUserService;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SinglewebConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PricipalUserService pricipalUserService;
	
	@Bean 
	public MyBCryptPasswordEncoder encodePWD() {
		return new MyBCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(pricipalUserService).passwordEncoder(encodePWD());
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}
	
	
	

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests() 
		.antMatchers("/","/js/**","/css/**", "/images/**" ,"/auth/**", "/oauth/**").permitAll() 
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
		
	

