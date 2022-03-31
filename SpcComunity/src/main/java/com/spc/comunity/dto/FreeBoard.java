package com.spc.comunity.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "FreeBoardBuilder")
@Table(name="TBL_FREE_BOARD")

public class FreeBoard {
	@Id
	private int idx;
	
	@Column(name ="TITLE")
	private String title;
	
	@Column(name ="CONTENTS")
	private String contents;
	
	@Column(name ="THUMBS_UP")
	private int thumbsUp;
	
	@Column(name ="THUMBS_DOWN")
	private int thumbsDown;
	
	@Column(name ="WARNING")
	private int warning;
	
	@Column(name ="REG_DATE")
	private Date regDate;
	
	@Column(name ="REG")
	private String reg;
	
	@Column(name ="UP_DATE")
	private Date upDate;
	
	@Column(name ="VIEW_POINT")
	private Date viewPoint;
	
	public static FreeBoardBuilder builder(FreeBoard freeBoard) {
		return FreeBoardBuilder()
				.idx(freeBoard.idx)
				.title(freeBoard.title)
				.contents(freeBoard.contents)
				.thumbsUp(freeBoard.thumbsUp)
				.thubsDown(freeBoard.thumbsDown)
				.warning(freeBoard.warning)
				.regDate(freeBoard.regDate)
				.reg(freeBoard.reg)
				.upDate(freeBoard.upDate)
				.viewPoint(freeBoard.viewPoint);
	}
	
}
