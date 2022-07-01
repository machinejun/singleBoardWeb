package com.singboardWeb.singleweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.singboardWeb.singleweb.model.Board;
import com.singboardWeb.singleweb.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public String writeBoard(Board board) {
		boardRepository.save(board);
		return "";
	}
	
	public Page<Board> getAllBoards(Pageable pageable){
		Page<Board> pages = boardRepository.findAll(pageable);
		return pages;
	}
}
