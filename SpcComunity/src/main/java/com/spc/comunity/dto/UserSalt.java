package com.spc.comunity.dto;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Builder(builderMethodName = "UserSaltBuilder")
@Table(name="TBL_SALT")
public class UserSalt {
	
	@Id
	@Column(name = "UUID")
	private String uuid;
	
	@Column(name = "SALT")
	private String salt;
	
	public static UserSaltBuilder builder(UserSalt userSalt) {
		return UserSaltBuilder()
				.uuid(userSalt.uuid)
				.salt(userSalt.salt);
	}
	public static String UserSaltGen() {
		Random rnd = new Random();
		String randomStr = "";

		for (int i = 0; i <= 12; i++) {
			randomStr += String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
		}
		
		return randomStr;
	}
}

