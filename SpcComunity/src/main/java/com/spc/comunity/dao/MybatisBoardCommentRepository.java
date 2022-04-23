package com.spc.comunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.BoardCommentDto;
import com.spc.comunity.dto.HumorBoardDto;
import com.spc.comunity.entity.BoardComment;

@Mapper
public interface MybatisBoardCommentRepository {

	List<BoardCommentDto> findHumorComment(int boardNum);

	List<BoardCommentDto> findFreeComment(int boardNum);

	List<BoardCommentDto> findHumorLately();

	List<BoardCommentDto> findFreeLately();

}
