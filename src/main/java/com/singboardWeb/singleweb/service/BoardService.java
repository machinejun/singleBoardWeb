package com.singboardWeb.singleweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.singboardWeb.singleweb.model.Board;
import com.singboardWeb.singleweb.model.Reply;
import com.singboardWeb.singleweb.repository.BoardRepository;
import com.singboardWeb.singleweb.repository.ReplyRepository;

@Service
public class BoardService {
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public String writeBoard(Board board) {
		boardRepository.save(board);
		return "";
	}
	
	@Transactional(readOnly = true)
	public Page<Board> getAllBoards(Pageable pageable){
		Page<Board> pages = boardRepository.findAll(pageable);
		return pages;
	}
	
	@Transactional
	public Board getBoard(int id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("해당하는 게시판이 존재하지 않습니다");
		});
		board.setCount(board.getCount() + 1);
		return board;
	}
	
	@Transactional
	public boolean updateBoard(int id, Board board) {
		System.out.println("id : "+ id +" board: " + board );
		Board oldboard = boardRepository.findById(id).get();
		if(oldboard == null) {
			return false;
		}
		
		oldboard.setTitle(board.getTitle());
		oldboard.setContent(board.getContent());
		oldboard.setSecret(board.getSecret());
		oldboard.setPassword(board.getPassword());
		System.out.println("oldboard");
		return true;
	}
	
	@Transactional
	public boolean removeBoard(int id) {
		int result = boardRepository.removeById(id);
		if(result != 1) {
			return false;
		}
		return true;
		
	}
	
	@Transactional
	public Reply addReplyIntoBoard(int boardid, Reply reply) {
		Board board = boardRepository.findById(boardid).orElseThrow(() ->{
			return new RuntimeException("해당하는 게시판이 존재하지 않습니다");
		});
		reply.setBoard(board);
		reply.setUser(board.getUser());
		replyRepository.save(reply);
		return reply;
	}
	
	@Transactional
	public String removeReply(int replyId) {
		int boardid = replyRepository.findById(replyId).get().getBoard().getId();
		int result = replyRepository.removeById(replyId);
		if(result == 1) {
			return ""+boardid;
		}
		return null;
	}
	@Transactional(readOnly = true)
	public Page<Board> findByTitle(String title, Pageable pageable){
		Page<Board> pages = boardRepository.findByTitleContaining(title, pageable);
		return pages;
	}
	
}
