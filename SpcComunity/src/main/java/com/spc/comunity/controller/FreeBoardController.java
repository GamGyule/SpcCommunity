package com.spc.comunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.JpaFreeBoardRepository;
import com.spc.comunity.dao.service.BoardCommentService;
import com.spc.comunity.dao.service.FreeBoardService;
import com.spc.comunity.dao.service.HumorBoardService;
import com.spc.comunity.dto.BoardCommentDto;
import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.dto.HumorBoardDto;
import com.spc.comunity.entity.FreeBoard;
import com.spc.comunity.entity.HumorBoard;

@RestController
@RequestMapping("/api")
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;
	@Autowired
	private HumorBoardService humorBoardService;
	@Autowired
	private BoardCommentService boardCommentService;
	
	@Autowired
	JpaFreeBoardRepository jpaFreeBoardRepository;

	private Gson gson = new Gson().newBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();

	// �����Խ��� �����ȸ
	@GetMapping("/board/free")
	public String freeList(@RequestParam("page") int page) {
		List<FreeBoardDto> list = freeBoardService.findPage((page-1)*20);
		int count = freeBoardService.findCountAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("board", list);
		map.put("boardCount", count);

		String json = gson.toJson(map);

		return json;
	}
	

	@GetMapping("/board/humor")
	public String humorList(@RequestParam("page") int page) {
		System.out.println(page);
		List<HumorBoardDto> list = humorBoardService.findPage((page-1)*20);
		int count = humorBoardService.findCountAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("board", list);
		map.put("boardCount", count);

		String json = gson.toJson(map);

		return json;
	}

	// �����Խ��� �����ȸ
	@GetMapping("/board/humor/{boardNum}")
	public String getHumorBoard(@PathVariable int boardNum) {
		HumorBoardDto humorDto = humorBoardService.findBoard(boardNum);
		List<BoardCommentDto> commentDto = boardCommentService.findHumorComment(boardNum);

		Map<String, Object> map = new HashMap<>();

		map.put("board", humorDto);
		map.put("comment", commentDto);
		String json = gson.toJson(map);
		
		System.out.println(json);

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
	
	
	@PatchMapping("/board/free/{boardNum}")
	public String freeBoardUpdate(@PathVariable int boardNum, @RequestBody FreeBoardDto dto) {		
		FreeBoardDto boardDto = freeBoardService.findBoard(dto.getIdx());
		FreeBoard entity = FreeBoard.builder(dto).build();
		entity.update(dto.getTitle(), dto.getContents());
		freeBoardService.save(entity);
		return entity.getContents();
	}
	
	
	@PostMapping("/board/free/write")
	public String freeBoardWrite(@RequestBody FreeBoardDto dto) {
		FreeBoard freeBoard = FreeBoard.builder(dto).build();
		freeBoardService.save(freeBoard);
		return "";
	}
	
	@PatchMapping("/board/humor/{boardNum}")
	public String humorBoardUpdate(@PathVariable int boardNum, @RequestBody HumorBoardDto dto) {		
		HumorBoardDto boardDto = humorBoardService.findBoard(dto.getIdx());
		HumorBoard entity = HumorBoard.builder(dto).build();
		entity.update(dto.getTitle(), dto.getContents());
		humorBoardService.save(entity);
		return entity.getContents();
	}
	
	
	@PostMapping("/board/humor/write")
	public String humorBoardWrite(@RequestBody HumorBoardDto dto) {
		HumorBoard humorBoard = HumorBoard.builder(dto).build();
		humorBoardService.save(humorBoard);
		return "";
	}
	

}
