package com.singboardWeb.singleweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.singboardWeb.singleweb.dto.ResponseDto;
import com.singboardWeb.singleweb.model.Board;
import com.singboardWeb.singleweb.model.Reply;
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
	
	@PostMapping("/board/update")
	public ResponseDto<String> updateBoard(@RequestBody Board board){
		System.out.println(board);
		if(boardService.updateBoard(board.getId(), board)) {
			return new ResponseDto<String>(HttpStatus.OK.value(), "ok");
		}
		return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "fail");
	}
	
	@DeleteMapping("/board/remove/{boardid}")
	public ResponseDto<String> removeBoard(@PathVariable int boardid){
		System.out.println("remove : " + boardid);
		if(boardService.removeBoard(boardid)) {
			return new ResponseDto<String>(HttpStatus.OK.value(), "ok");
		}
		return new ResponseDto<String>(HttpStatus.BAD_REQUEST.value(), "fail");
	}
	///api/reply/${boardid}
	@PostMapping("/reply/{boardid}")
	public ResponseDto<Reply> addReplyIntoBoard(@PathVariable int boardid, @RequestBody Reply reply){
		System.out.println("addReply>>" +boardid + "reply: " +reply );
		Reply Sreply = boardService.addReplyIntoBoard(boardid, reply);
		return new ResponseDto<Reply>(HttpStatus.OK.value(),Sreply);
	}
	///api/reply/remove/${id}
	@DeleteMapping("/reply/remove/{replyId}")
	public ResponseDto<Integer> removeReplyFromBoard(@PathVariable int replyId){
		System.out.println(">>>>>>>" + replyId);
		String result = boardService.removeReply(replyId);
		if(result != null) {
			return new ResponseDto<Integer>(HttpStatus.OK.value(), Integer.parseInt(result));
		}
		return new ResponseDto<Integer>(HttpStatus.BAD_REQUEST.value(), 0);
	}
}
