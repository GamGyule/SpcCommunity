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
	
	@Transactional(rollbackFor=Exception.class)
	public int findCountAll() {
		return mybatisFreeBoardRepository.findCountAll();
	}	
	
	@Transactional(rollbackFor=Exception.class)
	public List<FreeBoardDto> findById(int idx) {
		return mybatisFreeBoardRepository.findById(idx);
	}
	
	
	@Transactional(rollbackFor=Exception.class)
	public List<FreeBoardDto> findPage(int page){
		return mybatisFreeBoardRepository.findPage(page);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public List<FreeBoardDto> findLately(){
		return mybatisFreeBoardRepository.findLately();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public FreeBoardDto findBoard(int boardNum) {
		return mybatisFreeBoardRepository.findBoard(boardNum);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public FreeBoard save(FreeBoard freeBoard) {
		return jpaFreeBoardRepository.save(freeBoard);
	}
	
	//이렇게해야 오류가떴을때 롤백해줌
	@Transactional(rollbackFor=Exception.class)
	public String search(String name, String keyword) {
		return mybatisFreeBoardRepository.findKeyword(name,keyword);
	}
	
	
	
}
