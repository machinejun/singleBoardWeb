package com.singboardWeb.singleweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.singboardWeb.singleweb.model.Board;
import com.singboardWeb.singleweb.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String home(@PageableDefault(size = 4, direction = Direction.DESC , page = 0, sort = "id") Pageable pageable, Model model) {
		Page<Board> boards = boardService.getAllBoards(pageable);
		model.addAttribute("boards", boards);
		return "home";
	}
	
	@GetMapping("/board/write")
	public String write() {
		
		return "/board/write";
	}
	
	@GetMapping("/board/detail/{id}")
	public String showDetail(@PathVariable int id) {
		System.out.println("heelooooo");
		return "/board/detail";
	}
	
}
