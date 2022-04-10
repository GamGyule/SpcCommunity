package com.spc.comunity.dao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spc.comunity.dao.JPaFreeBoardCommentRepository;
import com.spc.comunity.dao.JpaFreeBoardRepository;
import com.spc.comunity.dao.MybatisFreeBoardRepository;
import com.spc.comunity.dao.MybatisUserInfoRepository;
import com.spc.comunity.dto.FreeBoardCommentDto;
import com.spc.comunity.dto.FreeBoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FreeBoardCommentService {
	private final JPaFreeBoardCommentRepository jpaFreeBoardCommentRepositry;
	private final JpaFreeBoardRepository jpaFreeBoardRepository;
	private final MybatisFreeBoardRepository mybatisFreeBoardRepository;	
	private final MybatisUserInfoRepository mybatisUserInfoRepository;
	
	
	@Transactional
	public void commentSave(String commentWriter, int idx, FreeBoardCommentDto dto) {
		User user = mybatisUserInfoRepository.findById(commentWriter);
		
		List<FreeBoardDto> freeBoard = mybatisFreeBoardRepository.findById(idx);
		
		freeBoardComment.save(freeBoard, commentWriter);
		
		jpaFreeBoardCommentRepositry.save(freeBoardComment);
		
		}
	}

