package com.spc.comunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.BoardCommentService;
import com.spc.comunity.dao.service.FreeBoardService;
import com.spc.comunity.dao.service.HumorBoardService;
import com.spc.comunity.dto.BoardCommentDto;
import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.dto.HumorBoardDto;

@RestController
@RequestMapping("/api")
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private HumorBoardService humorBoardService;
	@Autowired
	private BoardCommentService boardCommentService;

	private Gson gson = new Gson().newBuilder().setDateFormat("yyyy.MM.dd HH:mm").create();

	// 자유게시판 목록조회
	@GetMapping("/board/free")
	public String freeList(@RequestParam(value = "page", defaultValue = "0") int _page) {
		List<FreeBoardDto> list = freeBoardService.findPage(_page);

		String json = gson.toJson(list);

		return json;
	}

	// 자유게시판 목록조회
	@GetMapping("/board/humor/{boardNum}")
	public String getHumorBoard(@PathVariable int boardNum) {
		HumorBoardDto humorDto = humorBoardService.findBoard(boardNum);
		List<BoardCommentDto> commentDto = boardCommentService.findHumorComment(boardNum);

		Map<String, Object> map = new HashMap<>();

		map.put("board", humorDto);
		map.put("comment", commentDto);
		String json = gson.toJson(map);

		return json;
	}
	
	@GetMapping("/board/free/{boardNum}")
	public String getFreeBoard(@PathVariable int boardNum) {
		FreeBoardDto freeDto = freeBoardService.findBoard(boardNum);
		List<BoardCommentDto> commentDto = boardCommentService.findFreeComment(boardNum);

		Map<String, Object> map = new HashMap<>();

		map.put("board", freeDto);
		map.put("comment", commentDto);
		String json = gson.toJson(map);

		return json;
	}

	@GetMapping("/board/humor")
	public String humorList(@RequestParam(value = "page", defaultValue = "0") int _page) {

		List<HumorBoardDto> list = humorBoardService.findPage(_page);

		String json = gson.toJson(list);

		return json;
	}

	@GetMapping("/board/humor/lately")
	public String humorLately() {

		List<HumorBoardDto> list = humorBoardService.findLately();

		String json = gson.toJson(list);

		return json;
	}

	@GetMapping("/board/free/lately")
	public String freeLately() {

		List<FreeBoardDto> list = freeBoardService.findLately();

		String json = gson.toJson(list);

		return json;
	}

}
