package com.spc.comunity.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class HumorBoardDto {
	
	private int idx;
	
	private String title;
	
	private String contents;
	
	private String writer;
	
	private int thumbsUp;
	
	private int thumbsDown;
	
	private int warning;
	
	private Timestamp regDate;
	
	private Timestamp upDate;
	
	private int viewPoint;
	
	private int commentCnt;
	
	private String useYn;
	
}
