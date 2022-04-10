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
public class FreeBoardCommentDto {
	
	private int idx;
	
	private int boardIdx;
	
	private String comment;
	
	private String commentWriter;
	
	private Date regDate;
	
	private int upIdx;

}
