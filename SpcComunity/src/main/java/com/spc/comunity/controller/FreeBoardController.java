package com.spc.comunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.spc.comunity.util.ResultResponse;

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

	// 자유게시판 목록조회
	@GetMapping("/board/free")
	public Map<String, Object> freeList(@RequestParam("page") int page) {
		List<FreeBoardDto> list = freeBoardService.findPage((page-1)*20);
		int count = freeBoardService.findCountAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("board", list);
		map.put("boardCount", count);

		return map;
	}
	
	//검색
	@GetMapping("/board/free/search")
	@ResponseBody
	public String freeBoardSearch(HttpServletRequest req) {		
		
		String name =  req.getParameter("name"); //selectbox name
		String keyword = req.getParameter("keyword"); //키워드
				
		return freeBoardService.search(name,keyword);
	}
	

	@GetMapping("/board/humor")
	public Map humorList(@RequestParam("page") int page) {
		System.out.println(page);
		List<HumorBoardDto> list = humorBoardService.findPage((page-1)*20);
		int count = humorBoardService.findCountAll();
		
		Map<String, Object> map = new HashMap<>();
		map.put("board", list);
		map.put("boardCount", count);

		return map;
	}

	// 자유게시판 목록조회
	@GetMapping("/board/humor/{boardNum}")
	public Map getHumorBoard(@PathVariable int boardNum) {
		HumorBoardDto humorDto = humorBoardService.findBoard(boardNum);
		List<BoardCommentDto> commentDto = boardCommentService.findHumorComment(boardNum);

		Map<String, Object> map = new HashMap<>();

		map.put("board", humorDto);
		map.put("comment", commentDto);

		return map;
	}
	
	@GetMapping("/board/free/{boardNum}")
	public Map getFreeBoard(@PathVariable int boardNum) {
		FreeBoardDto freeDto = freeBoardService.findBoard(boardNum);
		List<BoardCommentDto> commentDto = boardCommentService.findFreeComment(boardNum);

		Map<String, Object> map = new HashMap<>();

		map.put("board", freeDto);
		map.put("comment", commentDto);

		return map;
	}


	@GetMapping("/board/humor/lately")
	public List<HumorBoardDto> humorLately() {

		List<HumorBoardDto> list = humorBoardService.findLately();

		return list;
	}

	@GetMapping("/board/free/lately")
	public List<FreeBoardDto> freeLately() {

		List<FreeBoardDto> list = freeBoardService.findLately();

		return list;
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
		dto.setUseYn("1");
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
		dto.setUseYn("1");
		HumorBoard humorBoard = HumorBoard.builder(dto).build();
		humorBoardService.save(humorBoard);
		return "";
	}
	

	

}
