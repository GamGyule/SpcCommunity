package com.spc.comunity.entity;

import java.util.Date;
<<<<<<< HEAD:SpcComunity/src/main/java/com/spc/comunity/dto/UserInfo.java
<<<<<<< HEAD

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

=======
import java.util.UUID;
=======
>>>>>>> Dev:SpcComunity/src/main/java/com/spc/comunity/entity/UserInfo.java

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spc.comunity.dto.UserInfoDto;

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
				.regDate(new Date())
				.authCode(userInfo.getAuthCode())
				.authName(userInfo.getAuthName())
				.point(userInfo.getPoint())
				.level(userInfo.getLevel())
				.loginTime(userInfo.getLoginTime())
				.pwdFailCount(userInfo.getPwdFailCount())
				.salt(userInfo.getSalt());
	}
}

>>>>>>> Dev
