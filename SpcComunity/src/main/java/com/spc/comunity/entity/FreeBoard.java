package com.spc.comunity.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.spc.comunity.dto.FreeBoardDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "FreeBoardBuilder")
@Table(name="TBL_FREE_BOARD")
public class FreeBoard {
	@Id
	private int idx;
	
	@Column(name ="TITLE")
	private String title;
	
	@Column(name ="CONTENTS")
	private String contents;
	
	@Column(name ="WRITER")
	private String writer;
	
	@Column(name ="THUMBS_UP")
	private int thumbsUp;
	
	@Column(name ="THUMBS_DOWN")
	private int thumbsDown;
	
	@Column(name ="WARNING")
	private int warning;
	
	@Column(name ="REG_DATE")
	private Date regDate;
	
	@Column(name ="REG")
	private String reg;
	
	@Column(name ="UP_DATE")
	private Date upDate;
	
	@Column(name ="VIEW_POINT",columnDefinition ="integer default 0")
	private int viewPoint;
	
	
	//�������� �߻��ذ�
	@JsonIgnoreProperties({"FreeBoard"})
	@OneToMany(mappedBy = "FreeBoard", fetch = FetchType.EAGER)
	private List<FreeBoardComment> commentList;
	
	public static FreeBoardBuilder builder(FreeBoardDto freeBoard) {
		return FreeBoardBuilder()
				.idx(freeBoard.getIdx())
				.title(freeBoard.getTitle())
				.writer(freeBoard.getWriter())
				.contents(freeBoard.getContents())
				.thumbsUp(freeBoard.getThumbsDown())
				.thumbsDown(freeBoard.getThumbsDown())
				.warning(freeBoard.getWarning())
				.regDate(freeBoard.getRegDate())
				.reg(freeBoard.getReg())
				.upDate(freeBoard.getUpDate())
				.viewPoint(freeBoard.getViewPoint());
	}
	
}
