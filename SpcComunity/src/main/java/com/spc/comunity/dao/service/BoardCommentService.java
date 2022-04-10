package com.spc.comunity.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.JpaFreeBoardRepository;
import com.spc.comunity.dao.MybatisBoardCommentRepository;
import com.spc.comunity.dao.MybatisFreeBoardRepository;
import com.spc.comunity.dto.BoardCommentDto;
import com.spc.comunity.dto.FreeBoardDto;


@Service
public class BoardCommentService {
	
	@Autowired
	private MybatisBoardCommentRepository mybatisBoardCommentRepository;

	@Transactional
	public List<BoardCommentDto> findHumorComment(int boardNum) {
		return mybatisBoardCommentRepository.findHumorComment(boardNum);
	}	
	
	@Transactional
	public List<BoardCommentDto> findFreeComment(int boardNum) {
		return mybatisBoardCommentRepository.findFreeComment(boardNum);
	}	
	
}
