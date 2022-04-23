package com.spc.comunity.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spc.comunity.dto.HumorBoardDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "HumorBoardBuilder")
@Table(name="TBL_HUMOR_BOARD")
public class HumorBoard {
	
	@Id
	private int idx;
	
	@Column(name ="TITLE")
	private String title;
	
	@Column(name ="CONTENTS")
	private String contents;
	
	@Column(name ="WRITER")
	private String writer;
	
	@Column(name ="THUMBS_UP")
	private int thumbsUp;
	
	@Column(name ="THUMBS_DOWN")
	private int thumbsDown;
	
	@Column(name ="WARNING")
	private int warning;
	
	@Column(name ="REG_DATE")
	private Timestamp regDate;
	
	@Column(name ="REG")
	private String reg;
	
	@Column(name ="UP_DATE")
	private Timestamp upDate;
	
	@Column(name ="VIEW_POINT",columnDefinition ="integer default 0")
	private int viewPoint;
	
	@Column(name="COMMENT_CNT")
	private int commentCnt;
	
	@Column(name ="USE_YN")
	private String useYn;
	
	
	
	public static HumorBoardBuilder builder(HumorBoardDto freeBoard) {
		return HumorBoardBuilder()
				.idx(freeBoard.getIdx())
				.title(freeBoard.getTitle())
				.writer(freeBoard.getWriter())
				.contents(freeBoard.getContents())
				.thumbsUp(freeBoard.getThumbsDown())
				.thumbsDown(freeBoard.getThumbsDown())
				.warning(freeBoard.getWarning())
				.regDate(freeBoard.getRegDate())
				.reg(freeBoard.getReg())
				.upDate(freeBoard.getUpDate())
				.viewPoint(freeBoard.getViewPoint())
				.commentCnt(freeBoard.getCommentCnt())
				.useYn(freeBoard.getUseYn());
	}
	
	
	//
	public void update(String title, String contents, String writer) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.upDate = new Timestamp(System.currentTimeMillis());
	}
	
	
	
	
}
