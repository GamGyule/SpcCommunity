package com.spc.comunity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Builder(builderMethodName = "BoardCommentBuilder")
@Table(name="TBL_FREE_COMMENT")

public class BoardComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	//����� ���� �ۼ��ߴ��� ����Խñۿ� �ۼ��ߴ��� �˾ƾ��ϱ⶧���� ���������ʿ�
	@ManyToOne(targetEntity = FreeBoard.class, fetch = FetchType.LAZY)
	@JoinColumn(name ="IDX")
	private String boardIdx;
	
	@Column(name ="CONTENT")
	private String content;

	@ManyToOne(targetEntity = UserInfo.class, fetch = FetchType.LAZY)
	@JoinColumn(name ="USER_NAME")
	private String commentWriter;
	
	@Column(name ="REG_DATE")
	private String regDate;
	
	@Column(name ="UP_IDX")
	private String upIdx;

}
