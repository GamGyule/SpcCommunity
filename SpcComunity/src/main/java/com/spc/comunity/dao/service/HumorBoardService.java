package com.spc.comunity.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.JpaHumorBoardRepository;
import com.spc.comunity.dao.MybatisHumorBoardRepository;
import com.spc.comunity.dto.HumorBoardDto;


@Service
public class HumorBoardService {
	
	@Autowired
	private JpaHumorBoardRepository humorBoardRepository;
	
	@Autowired
	private MybatisHumorBoardRepository mybatisHumorBoardRepository;
	
	@Transactional
	public List<HumorBoardDto> findAll() {
		return mybatisHumorBoardRepository.findAll();
	}
	
	@Transactional
	public List<HumorBoardDto> findPage(int page){
		return mybatisHumorBoardRepository.findPage(page);
	}
	
	@Transactional
	public List<HumorBoardDto> findLately(){
		return mybatisHumorBoardRepository.findLately();
	}
	
	@Transactional
	public HumorBoardDto findBoard(int boardNum){
		return mybatisHumorBoardRepository.findBoard(boardNum);
	}
	
	
}
