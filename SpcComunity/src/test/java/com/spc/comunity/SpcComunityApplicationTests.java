package com.spc.comunity;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dao.service.UserSaltService;
import com.spc.comunity.dto.UserInfo;
import com.spc.comunity.dto.UserSalt;
import com.spc.comunity.util.SecureClass;

@SpringBootTest
class SpcComunityApplicationTests {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserSaltService userSaltService;

	@Test
	@DisplayName("회원가입 테스트")
	void 회원가입_테스트입니다() {

		String id = "test1";
		boolean alreadyId = userInfoService.findById(id);
		if (!alreadyId) {

			// UUID 생성 "-" 빼고
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			// SALT 문자열 임의 생성
			String randomStr = UserSalt.UserSaltGen();
			
			// SALT 클래스에 넣어주고 jpa insert
			UserSalt userSalt = UserSalt.UserSaltBuilder().uuid(uuid).salt(randomStr).build();
			userSaltService.userSaltSave(userSalt);
			
			// 회원 정보에 들어갈 비밀번호+salt 암호화
			String securePw = SecureClass.sha512("test password", userSalt.getSalt());
			UserInfo userInfo = UserInfo.UserInfoBuilder()
					.uuid(uuid)
					.id(id)
					.password(securePw)
					.userName("test username")
					.email("test email")
					.regDate(new Date())
					.build();
			
			// 회원정보 입력 jpa insert
			userInfoService.userInfoSave(userInfo);
			System.out.println("생성 성공");
		} else {
			// 이미 있는 아이디
			System.out.println("이미 있는 아이디");
		}
	}

	@Test
	@DisplayName("로그인 테스트")
	void 로그인_테스트입니다() {
		UserInfo userInfo = UserInfo.UserInfoBuilder()
				.id("test1")
				.password("q1w2e3r4")
				.build();
		
		UserInfo myInfo = userInfoService.getUserInfo(userInfo);
		String json = "";		
		
		if(myInfo == null) {
			json = "missmatched";
		}else {
			json = new Gson().toJson(myInfo);
		}
		System.out.println(json);
	}


}
