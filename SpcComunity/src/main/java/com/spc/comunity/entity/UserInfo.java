package com.spc.comunity.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spc.comunity.dto.UserInfoDto;

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
	private Timestamp regDate;

	@Column(name = "AUTH_CODE")
	private int authCode;
	
	@Column(name = "AUTH_NAME")
	private String authName;
	
	@Column(name = "POINT")
	private int point;
	
	@Column(name = "LEVEL")
	private int level;
	
	@Column(name = "LOGIN_TIME")
	private Timestamp loginTime;
	
	@Column(name = "PWD_FAIL_CNT")
	private int pwdFailCount;
	
	@Column(name ="SALT")
	private String salt;
	
	public static UserInfoBuilder builder(UserInfoDto userInfo) {
		return UserInfoBuilder()
				.uuid(userInfo.getUuid())
				.id(userInfo.getId())
				.password(userInfo.getPassword())
				.userName(userInfo.getUserName())
				.email(userInfo.getEmail())
				.platform(userInfo.getPlatform())
				.token(userInfo.getToken())
				.regDate(new Timestamp(System.currentTimeMillis()))
				.authCode(userInfo.getAuthCode())
				.authName(userInfo.getAuthName())
				.point(userInfo.getPoint())
				.level(userInfo.getLevel())
				.loginTime(userInfo.getLoginTime())
				.pwdFailCount(userInfo.getPwdFailCount())
				.salt(userInfo.getSalt());
	}
}