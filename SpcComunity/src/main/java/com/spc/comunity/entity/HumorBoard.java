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
	
	@Column(name ="UP_DATE")
	private Timestamp upDate;
	
	@Column(name ="VIEW_POINT",columnDefinition ="integer default 0")
	private Integer viewPoint = 0;
	
	@Column(name="COMMENT_CNT",columnDefinition ="integer default 0")
	private Integer commentCnt = 0;
	
	@Column(name ="USE_YN")
	private String useYn;
	
	
	
	public static HumorBoardBuilder builder(HumorBoardDto humorBoard) {
		return HumorBoardBuilder()
				.idx(humorBoard.getIdx())
				.title(humorBoard.getTitle())
				.writer(humorBoard.getWriter())
				.contents(humorBoard.getContents())
				.thumbsUp(humorBoard.getThumbsDown())
				.thumbsDown(humorBoard.getThumbsDown())
				.warning(humorBoard.getWarning())
				.regDate(new Timestamp(System.currentTimeMillis()))
				.upDate(humorBoard.getUpDate())
				.viewPoint(humorBoard.getViewPoint())
				.commentCnt(humorBoard.getCommentCnt())
				.useYn(humorBoard.getUseYn());
	}
	
	
	//
	public void update(String title, String contents) {
		this.title = title;
		this.contents = contents;
		this.upDate = new Timestamp(System.currentTimeMillis());
	}
	
	
	
	
}
