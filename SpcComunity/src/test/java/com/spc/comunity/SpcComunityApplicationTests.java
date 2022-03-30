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
	@DisplayName("ȸ������ �׽�Ʈ")
	void ȸ������_�׽�Ʈ�Դϴ�() {

		String id = "test1";
		boolean alreadyId = userInfoService.findById(id);
		if (!alreadyId) {

			// UUID ���� "-" ����
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");
			
			// SALT ���ڿ� ���� ����
			String randomStr = UserSalt.UserSaltGen();
			
			// SALT Ŭ������ �־��ְ� jpa insert
			UserSalt userSalt = UserSalt.UserSaltBuilder().uuid(uuid).salt(randomStr).build();
			userSaltService.userSaltSave(userSalt);
			
			// ȸ�� ������ �� ��й�ȣ+salt ��ȣȭ
			String securePw = SecureClass.sha512("test password", userSalt.getSalt());
			UserInfo userInfo = UserInfo.UserInfoBuilder()
					.uuid(uuid)
					.id(id)
					.password(securePw)
					.userName("test username")
					.email("test email")
					.regDate(new Date())
					.build();
			
			// ȸ������ �Է� jpa insert
			userInfoService.userInfoSave(userInfo);
			System.out.println("���� ����");
		} else {
			// �̹� �ִ� ���̵�
			System.out.println("�̹� �ִ� ���̵�");
		}
	}

	@Test
	@DisplayName("�α��� �׽�Ʈ")
	void �α���_�׽�Ʈ�Դϴ�() {
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
