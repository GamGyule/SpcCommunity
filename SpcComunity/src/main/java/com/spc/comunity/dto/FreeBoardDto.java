package com.spc.comunity.dto;

import java.sql.Date;

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
	
	private int thumbsUp;
	
	private int thumbsDown;
	
	private int warning;
	
	private Date regDate;
	
	private String reg;
	
	private Date upDate;
	
	private Date viewPoint;
	
}
