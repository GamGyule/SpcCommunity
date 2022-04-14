package com.spc.comunity.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.spc.comunity.dao.JpaFreeBoardRepository;
import com.spc.comunity.dao.MybatisFreeBoardRepository;
import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.entity.FreeBoard;


@Service
public class FreeBoardService {
	
	@Autowired
	private JpaFreeBoardRepository jpaFreeBoardRepository;
	
	@Autowired
	private MybatisFreeBoardRepository mybatisFreeBoardRepository;
	
	@Transactional
	public int findCountAll() {
		return mybatisFreeBoardRepository.findCountAll();
	}	
	
	@Transactional
	public List<FreeBoardDto> findById(int idx) {
		return mybatisFreeBoardRepository.findById(idx);
	}	
	
	
	@Transactional
	public List<FreeBoardDto> findPage(int page){
		return mybatisFreeBoardRepository.findPage(page);
	}
	
	@Transactional
	public List<FreeBoardDto> findLately(){
		return mybatisFreeBoardRepository.findLately();
	}
	
	@Transactional
	public FreeBoardDto findBoard(int boardNum) {
		return mybatisFreeBoardRepository.findBoard(boardNum);
	}
	
	//한빈이가함
	public FreeBoardService(JpaFreeBoardRepository jpaFreeBoardRepository) {
		this.jpaFreeBoardRepository = jpaFreeBoardRepository;
	}
	
	//게시판 글쓰기 Create Board Rest API
	@Transactional
	public FreeBoard createFreeBoard(@RequestBody FreeBoard freeBoard) {
		return jpaFreeBoardRepository.save(freeBoard);
	}
	
}
