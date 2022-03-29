package com.spc.comunity.dto;

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
}

