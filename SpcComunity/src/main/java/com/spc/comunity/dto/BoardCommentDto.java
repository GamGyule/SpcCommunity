package com.spc.comunity.dto;

import java.sql.Timestamp;

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

	private Timestamp regDate;

	private String upIdx;

}
