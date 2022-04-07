package com.spc.comunity.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.JpaFreeBoardRepository;
import com.spc.comunity.dao.MybatisFreeBoardRepository;
import com.spc.comunity.dto.FreeBoardDto;


@Service
public class FreeBoardService {
	
	@Autowired
	private JpaFreeBoardRepository freeBoardRepository;
	
	@Autowired
	private MybatisFreeBoardRepository mybatisFreeBoardRepository;
	
	@Transactional
	public List<FreeBoardDto> findAll() {
		return mybatisFreeBoardRepository.findAll();
	}	
	
	@Transactional
	public List<FreeBoardDto> findPage(int page){
		return mybatisFreeBoardRepository.findPage(page);
	}
	
	@Transactional
	public List<FreeBoardDto> findLately(){
		return mybatisFreeBoardRepository.findLately();
	}
	
}
