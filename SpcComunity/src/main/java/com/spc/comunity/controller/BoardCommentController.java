package com.spc.comunity.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.comunity.dao.service.BoardCommentService;
import com.spc.comunity.entity.BoardComment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class BoardCommentController {
	
	private final BoardCommentService boardCommentService;
	
    @PostMapping("/api/board/{boardId}/boardComment")
    public void commentSave(@PathVariable int boardIdx,
                     @RequestBody BoardComment boardComment,
                     String commentWriter) {
        boardCommentService.findFreeComment(boardIdx, boardComment, commentWriter);
    }
	
	

}
