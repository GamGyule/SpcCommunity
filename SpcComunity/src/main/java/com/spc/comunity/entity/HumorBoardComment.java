package com.spc.comunity.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.entity.FreeBoard.FreeBoardBuilder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "HumorBoardCommentBuilder")
@Table(name="TBL_HUMOR_COMMENT")
public class HumorBoardComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@Column(name ="BOARD_IDX")
	private String boardIdx;
	
	@Column(name ="CONTENT")
	private String content;

	@Column(name ="COMMENT_WRITER")
	private String commentWriter;
	
	@Column(name ="REG_DATE")
	private Timestamp regDate;
	
	@Column(name ="UP_IDX")
	private String upIdx;
	
	
	public static HumorBoardCommentBuilder builder(BoardComment boardComment) {
		return HumorBoardCommentBuilder()
				.boardIdx(boardComment.getBoardIdx())
				.commentWriter(boardComment.getCommentWriter())
				.content(boardComment.getContent())
				.idx(boardComment.getIdx())
				.regDate(boardComment.getRegDate())
				.upIdx(boardComment.getUpIdx());
	}

}
