package com.spc.comunity.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Builder(builderMethodName = "FreeBoardCommentBuilder")
@Table(name="TBL_FREE_COMMENT")

public class FreeBoardComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	@ManyToOne
	@Column(name ="BOARD_IDX")
	private String boardIdx;
	
	@Column(name ="CONTENT")
	private String content;
	
	@ManyToOne
	@Column(name ="COMMENT_WRTIER")
	private String commentWriter;
	
	@Column(name ="REG_DATE")
	private String regDate;
	
	@Column(name ="UP_IDX")
	private String upIdx;

}
