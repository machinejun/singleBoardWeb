package com.singboardWeb.singleweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singboardWeb.singleweb.dto.ResponseDto;
import com.singboardWeb.singleweb.model.RootType;
import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.service.UserService;

@RestController
@RequestMapping("/api")
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/joinProc")
	public ResponseDto<User> joinUser(@RequestBody User user){
		user.setOauth(RootType.Normal);
		User reponseUser = userService.saveUser(user);
		return new ResponseDto<User>(HttpStatus.OK.value(), reponseUser);
	}
}
