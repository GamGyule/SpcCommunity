package com.spc.comunity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.FreeBoardService;
import com.spc.comunity.dto.UserInfoDto;
import com.spc.comunity.entity.FreeBoard;
import com.spc.comunity.entity.UserInfo;
import com.spc.comunity.util.SecureClass;

@RestController
@RequestMapping("/api/*")
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	
	//게시판 목록조회
	@GetMapping("/boardList")
	@ResponseBody
	public List<FreeBoard> boardList() {
		return freeBoardService.getBoard();
	}
	
	

}
