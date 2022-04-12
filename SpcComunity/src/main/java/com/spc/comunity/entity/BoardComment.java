package com.spc.comunity.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "BoardCommentBuilder")
@Table(name="TBL_FREE_COMMENT")
public class BoardComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@Column(name ="BOARD_IDX")
	private String boardIdx;
	
	@Column(name ="CONTENT")
	private String content;

	@Column(name ="COMMENT_WRITER")
	private String commentWriter;
	
	@Column(name ="REG_DATE")
	private Timestamp regDate;
	
	@Column(name ="UP_IDX")
	private String upIdx;

}
