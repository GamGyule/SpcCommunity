package com.spc.comunity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spc.comunity.dao.service.BoardCommentService;
import com.spc.comunity.entity.BoardComment;

@RestController
@RequestMapping("/api")
public class BoardCommentController {

	@Autowired
	private BoardCommentService boardCommentService;

	@PostMapping("/board/{boardId}/boardComment")
	public void commentSave(@PathVariable int boardIdx, @RequestBody BoardComment boardComment, String commentWriter) {
		boardCommentService.findFreeComment(boardIdx);
	}

}
