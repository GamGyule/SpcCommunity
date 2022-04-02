package com.spc.comunity.dto;

import java.sql.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name="TBL_FREE_BOARD")
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
