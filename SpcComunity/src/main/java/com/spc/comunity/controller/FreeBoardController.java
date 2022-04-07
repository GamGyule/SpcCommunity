package com.spc.comunity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.FreeBoardService;
import com.spc.comunity.dao.service.HumorBoardService;
import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.dto.HumorBoardDto;

@RestController
@RequestMapping("/api")
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private HumorBoardService humorBoardService;

	// �Խ��� �����ȸ
	@GetMapping("/board/free")
	public String freeList(@RequestParam(value="page", defaultValue = "0") int _page) {
		List<FreeBoardDto> list = freeBoardService.findPage(_page);

		String json = new Gson().newBuilder().setDateFormat("yyyy.MM.dd").create().toJson(list);

		return json;
	}

	// �Խ��� �����ȸ
	@GetMapping("/board/humor")
	public String humorList(@RequestParam(value="page", defaultValue = "0") int _page) {
		
		List<HumorBoardDto> list = humorBoardService.findPage(_page);

		String json = new Gson().newBuilder().setDateFormat("yyyy.MM.dd").create().toJson(list);

		return json;
	}

}
