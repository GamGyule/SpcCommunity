package com.spc.comunity.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserInfoDto {
	private String uuid;

	private String id;
	
	private String password;
	
	private String userName;
	
	private String email;
	
	private String platform;
	
	private String token;
	
	private Timestamp regDate;
	
	private int authCode = 0;
	
	private String authName = "»ç¿ëÀÚ";
	
	private int point = 0;
	
	private int level = 1;
	
	private Timestamp loginTime;
	
	private int pwdFailCount;
	
	private String salt;

}

