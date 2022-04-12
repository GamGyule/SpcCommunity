package com.spc.comunity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.entity.BoardComment;

@Repository
public interface JpaBoardCommentRepository extends JpaRepository<BoardComment, String>{
	
}
