package com.spc.comunity.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.MybatisFreeBoardRepository;
import com.spc.comunity.dto.FreeBoardDto;


public class FreeBoardService {
	//@Autowired
	//private JpaFreeBoardRepository jpaFreeBoardRepositry;
	
	@Autowired
	private MybatisFreeBoardRepository mybatisFreeBoardRepository;
	
	@Transactional
	public List<FreeBoardDto> findAll() {
		return mybatisFreeBoardRepository.findAll();
	}	
	
}
