package com.spc.comunity.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class FreeBoardDto {
	
	private int idx;
	
	private String title;
	
	private String contents;
	
	private String writer;
	
	private int thumbsUp;
	
	private int thumbsDown;
	
	private int warning;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp regDate;
	
	private String reg;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp upDate;
	
	private int viewPoint;
	
	private int commentCnt;
	
	private String useYn;
	
	private String category;
	
	private String name;
	
	private String keyword;
	
	
}
