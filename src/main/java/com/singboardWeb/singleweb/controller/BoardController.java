package com.singboardWeb.singleweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.singboardWeb.singleweb.model.Board;
import com.singboardWeb.singleweb.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String home(@PageableDefault(size = 10, direction = Direction.DESC , page = 0, sort = "id") Pageable pageable,
			String q, Model model) {
		System.out.println(q);
		String st = (q == null) ? "" : q;

		Page<Board> boards = boardService.findByTitle(st, pageable);
	
		;
		model.addAttribute("boards", boards);
		
		model.addAttribute("pageNums", makePageNumbers(boards));
		return "home";
	}
	
	private ArrayList<Integer> makePageNumbers(Page<Board> pages) {
		int nowPage = pages.getPageable().getPageNumber();
		int startPage = Math.max(nowPage - 2, 0); //두 인트값 중에 큰 값을 반환 한다.
		int endPage = Math.min(nowPage + 2, pages.getTotalPages()-1);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = startPage; i <= endPage; i++) {
			list.add(i);
		}
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/board/write")
	public String write() {
		
		return "/board/write";
	}
	
	@GetMapping("/board/detail/{id}")
	public String showDetail(@PathVariable int id, Model model) {
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@GetMapping("/board/update/{id}")
	public String updateBoard(@PathVariable int id, Model model) {
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);
		return "/board/update";
	}
	
	
	
}
