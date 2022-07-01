package com.singboardWeb.singleweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.singboardWeb.singleweb.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
