package com.spc.comunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spc.comunity.dao.service.FreeBoardService;
import com.spc.comunity.dto.FreeBoardDto;

@RestController
@RequestMapping("/api/board")
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	
	//게시판 목록조회
	@GetMapping("/list")
	public List<FreeBoardDto> boardList() {
		return freeBoardService.findAll();
	}
	
	

}
