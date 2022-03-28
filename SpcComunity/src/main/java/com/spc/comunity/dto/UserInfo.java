package com.spc.comunity.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
@Table(name="TBL_USER_INF")
public class UserInfo {
	@Id
	@Column(name = "UUID")
	private byte[] uuid;
	
	@Column(name = "ID")
	private String id;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PLATFORM")
	private String platform;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "REG_DATE")
	private Date regDate;
	
	@Column(name = "AUTH_CD")
	private int authCode;
	
	@Column(name = "AUTH_NM")
	private String authName;
	
	@Column(name = "POINT")
	private int point;
	
	@Column(name = "LEVEL")
	private int level;
	
	@Column(name = "LOGIN_TIME")
	private Date loginTime;
	
	@Column(name = "LOGIN_FAIL_CNT")
	private int pwdFailCount;
}
