package com.singboardWeb.singleweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.singboardWeb.singleweb.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	@Modifying
	@Query(value = "DELETE FROM board b WHERE b.id = ?1", nativeQuery = true)
	int removeById(@Param(value = "id")int id);
	
	@Query(value = "SELECT * FROM board WHERE title like %?%", nativeQuery = true)
	Page<Board> findByTitleContaining(String title, Pageable pageable);
	
}
