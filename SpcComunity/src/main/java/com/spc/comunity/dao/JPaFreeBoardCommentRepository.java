package com.spc.comunity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.entity.FreeBoardComment;

@Repository
public interface JPaFreeBoardCommentRepository extends JpaRepository<FreeBoardComment, String>{
	
}
