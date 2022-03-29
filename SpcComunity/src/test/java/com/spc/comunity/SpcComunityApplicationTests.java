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

@SpringBootTest
class SpcComunityApplicationTests {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserSaltService userSaltService;

	@Test
	@DisplayName("회원가입 테스트")
	void 회원가입_테스트입니다() {

		Random rnd = new Random();
		String randomStr = "";
		
		for(int i = 0; i <= 12; i++) {
			randomStr += String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
		}
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		UserSalt userSalt = UserSalt.UserSaltBuilder()
				.uuid(uuid)
				.salt(randomStr)
				.build();
		
		
		String securePw = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			String temp = "testtesttest"+userSalt.getSalt();
			digest.reset();
			digest.update(temp.getBytes("utf8"));
			securePw = String.format("%0128x", new BigInteger(1,digest.digest()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		UserInfo userInfo = UserInfo.UserInfoBuilder()
				.uuid(uuid)
				.password(securePw)
				.userName("회원가입 테스트")
				.token("default")
				.regDate(new Date())
				.pwdFailCount(0)
				.point(0)
				.level(1)
				.id("SecurePasswordTest")
				.email("Signup@test.com")
				.authCode(0)
				.authName("default")
				.build();
		
		boolean alreadyId = userInfoService.findById(userInfo.getId());
		if(!alreadyId) {
			userSaltService.userSaltSave(userSalt);
			userInfoService.userInfoSave(userInfo);
		}else {
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
