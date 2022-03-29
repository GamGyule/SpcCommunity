package com.spc.comunity.dto;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Builder(builderMethodName = "UserInfoBuilder")
@Table(name="TBL_USER_INFO")
public class UserInfo {
	@Id
	private String uuid;
	
	@Column(name = "ID")
	private String id;
	
	@Column(name ="PASSWORD")
	private String password;
	
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
	
	@Column(name = "AUTH_CODE")
	private int authCode;
	
	@Column(name = "AUTH_NAME")
	private String authName;
	
	@Column(name = "POINT")
	private int point;
	
	@Column(name = "LEVEL")
	private int level;
	
	@Column(name = "LOGIN_TIME")
	private Date loginTime;
	
	@Column(name = "PWD_FAIL_CNT")
	private int pwdFailCount;
	
	public static UserInfoBuilder builder(UserInfo userInfo) {
		return UserInfoBuilder()
				.uuid(userInfo.uuid)
				.id(userInfo.id)
				.password(userInfo.password)
				.userName(userInfo.userName)
				.email(userInfo.email)
				.platform(userInfo.platform)
				.token(userInfo.token)
				.regDate(new Date())
				.authCode(userInfo.authCode)
				.authName(userInfo.authName)
				.point(userInfo.point)
				.level(userInfo.level)
				.loginTime(userInfo.loginTime)
				.pwdFailCount(userInfo.pwdFailCount);
	}
}

