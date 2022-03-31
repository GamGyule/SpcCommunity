package com.spc.comunity.dto;

import java.util.Date;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name="TBL_USER_INFO")
public class UserInfoDto {
	private String uuid;

	private String id;
	
	private String password;
	
	private String userName;
	
	private String email;
	
	private String platform;
	
	private String token;
	
	private Date regDate;
	
	private int authCode = 0;
	
	private String authName = "»ç¿ëÀÚ";
	
	private int point = 0;
	
	private int level = 1;
	
	private Date loginTime;
	
	private int pwdFailCount;
	
	private String salt;

}

