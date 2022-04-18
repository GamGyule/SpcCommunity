package com.spc.comunity.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class FreeBoardDto {
	
	private int idx;
	
	private String title;
	
	private String contents;
	
	private String writer;
	
	private int thumbsUp;
	
	private int thumbsDown;
	
	private int warning;
	
	private Timestamp regDate;
	
	private String reg;
	
	private Timestamp upDate;
	
	private int viewPoint;
	
	private String useYn;
	
/*	@Builder
	public FreeBoardDto(int idx, String title, String contents, String writer, int thumbsUp, int thumbsDown, int warning, Timestamp regDate,
			String reg, Timestamp upDate, int viewPoint) {
		this.idx = idx;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.thumbsUp = thumbsUp;
		this.thumbsDown = thumbsDown;
		this.warning = warning;
		this.regDate = regDate;
		this.reg = reg;
		this.upDate = upDate;
		this.viewPoint = viewPoint;
		
		
	}*/
	
}
