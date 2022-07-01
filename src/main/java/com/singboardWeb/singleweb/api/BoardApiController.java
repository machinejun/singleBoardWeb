package com.singboardWeb.singleweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singboardWeb.singleweb.dto.ResponseDto;
import com.singboardWeb.singleweb.model.Board;
import com.singboardWeb.singleweb.model.User;
import com.singboardWeb.singleweb.service.BoardService;
import com.singboardWeb.singleweb.service.UserService;

@RestController
@RequestMapping("/api")
public class BoardApiController {
	@Autowired
	private UserService userService;
	@Autowired
	private BoardService boardService; 
	
	@PostMapping("/board/write/{userId}")
	public ResponseDto<String> writeBoard(@PathVariable int userId,@RequestBody Board board){
		User user = userService.findById(userId);
		board.setUser(user);
		System.out.println(board);
		boardService.writeBoard(board);
		return new ResponseDto<String>(HttpStatus.OK.value(), "ok");
		
	}
}
