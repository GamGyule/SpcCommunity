package com.spc.comunity.dao.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.JpaFreeBoardRepository;
import com.spc.comunity.dao.MybatisFreeBoardRepository;
import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.entity.FreeBoard;
import com.spc.comunity.entity.UserInfo;

public class FreeBoardService {
	@Autowired
	private JpaFreeBoardRepository jpaFreeBoardRepositry;
	
	@Autowired
	private MybatisFreeBoardRepository mybatisFreeBoardRepository;
	
	@Transactional
	public List<FreeBoardDto> findAll() {
		return mybatisFreeBoardRepository.findAll();
	}	
	
}
