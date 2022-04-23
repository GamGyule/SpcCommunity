package com.spc.comunity.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	// 자유게시판 목록조회
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

	// 자유게시판 목록조회
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
	
	//자유게시판 글쓰기
    @GetMapping("/board/free/write")
    public String freeWrite(){
        return "free/write";
    }
    
	/*
	 * //유머게시판 글쓰기
	 * 
	 * @GetMapping("/board/humor/write") public String humorWrite(){ return
	 * "humor/write"; }
	 */
	
	//자유게시판 저장
	@ResponseBody
	@PostMapping("/board/free/write")
	public FreeBoard freeWriteSubmit(@RequestBody FreeBoard freeBoard) {
		jpaFreeBoardRepository.save(freeBoard);
		return freeBoard;
	}
	
	/*
	 * //유머게시판저장
	 * 
	 * @ResponseBody
	 * 
	 * @PostMapping("/board/humor/write") public HumorBoard
	 * humorWriteSubmit(@RequestBody HumorBoard humorBoard) {
	 * jpaHumorBoardRepository.save(humorBoard); return humorBoard; }
	 */
	
	//자유게시판 글 업데이트
	@GetMapping("/board/free/update")
	public String freeUpdate() {
		return "free/update";
	}

}
