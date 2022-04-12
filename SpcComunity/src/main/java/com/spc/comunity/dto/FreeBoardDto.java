package com.spc.comunity.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
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
	
}
