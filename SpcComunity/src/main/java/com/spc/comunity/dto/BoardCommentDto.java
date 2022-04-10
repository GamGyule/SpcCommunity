package com.spc.comunity.dto;

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

	private String regDate;

	private String upIdx;

}
