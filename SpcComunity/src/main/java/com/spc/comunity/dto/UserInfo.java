package com.spc.comunity.dto;

import java.util.Date;
<<<<<<< HEAD

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

=======
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
>>>>>>> Dev
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
<<<<<<< HEAD
@NoArgsConstructor
@Entity
@Table(name="TBL_USER_INF")
public class UserInfo {
	@Id
	@Column(name = "UUID")
	private byte[] uuid;
=======
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder(builderMethodName = "UserInfoBuilder")
@Table(name="TBL_USER_INFO")
public class UserInfo {
	@Id
	private String uuid;
>>>>>>> Dev
	
	@Column(name = "ID")
	private String id;
	
<<<<<<< HEAD
=======
	@Column(name ="PASSWORD")
	private String password;
	
>>>>>>> Dev
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
	
<<<<<<< HEAD
	@Column(name = "AUTH_CD")
	private int authCode;
	
	@Column(name = "AUTH_NM")
=======
	@Column(name = "AUTH_CODE")
	private int authCode;
	
	@Column(name = "AUTH_NAME")
>>>>>>> Dev
	private String authName;
	
	@Column(name = "POINT")
	private int point;
	
	@Column(name = "LEVEL")
	private int level;
	
	@Column(name = "LOGIN_TIME")
	private Date loginTime;
	
<<<<<<< HEAD
	@Column(name = "LOGIN_FAIL_CNT")
	private int pwdFailCount;
}
=======
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

>>>>>>> Dev
