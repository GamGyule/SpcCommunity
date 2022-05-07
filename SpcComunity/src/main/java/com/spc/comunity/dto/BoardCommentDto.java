package com.spc.comunity.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class BoardCommentDto {

	private int idx;

	private String boardIdx;

	private String content;

	private String commentWriter;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Timestamp regDate;

	private String upIdx;
	

}
