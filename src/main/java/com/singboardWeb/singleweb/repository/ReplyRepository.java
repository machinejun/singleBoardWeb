package com.singboardWeb.singleweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.singboardWeb.singleweb.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	@Modifying
	@Query(value = "DELETE FROM reply r WHERE r.id = ?1", nativeQuery = true)
	int removeById(@Param(value = "id")int id);
}
