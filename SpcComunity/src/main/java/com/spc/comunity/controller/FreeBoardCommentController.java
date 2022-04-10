package com.spc.comunity.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spc.comunity.dao.service.FreeBoardCommentService;
import com.spc.comunity.entity.FreeBoardComment;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FreeBoardCommentController {
	
	private final FreeBoardCommentService freeBoardCommentService;
	
    @PostMapping("/api/board/{boardId}/freeBoardComment")
    public void commentSave(@PathVariable int boardIdx,
                     @RequestBody FreeBoardComment freeBoardComment,
                     String commentWriter) {
        freeBoardCommentService.commentSave(boardIdx, freeBoardComment, commentWriter);
    }
	
	

}
