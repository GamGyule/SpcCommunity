package com.spc.comunity;

import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dto.UserInfoDto;
import com.spc.comunity.entity.UserInfo;
import com.spc.comunity.util.SecureClass;

@SpringBootTest
class SpcComunityApplicationTests {

	@Autowired
	private UserInfoService userInfoService;

	@Test
	@DisplayName("ȸ������ �׽�Ʈ")
	void ȸ������_�׽�Ʈ�Դϴ�() {

		String id = "test1";
		boolean alreadyId = userInfoService.findById(id);
		if (!alreadyId) {

			// UUID ���� "-" ����
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");

			// SALT ���ڿ� ���� ����
			String salt = SecureClass.UserSaltGen();

			// ȸ�� ������ �� ��й�ȣ+salt ��ȣȭ
			String securePw = SecureClass.sha512("test1", salt);
			UserInfoDto userInfoDto = new UserInfoDto();
			userInfoDto.setUuid(uuid);
			userInfoDto.setId(id);
			userInfoDto.setPassword(securePw);
			userInfoDto.setUserName("test User Name");
			userInfoDto.setEmail("test User Email");
			userInfoDto.setRegDate(new Date());
			userInfoDto.setSalt(salt);
			
			
			UserInfo userInfo = UserInfo.builder(userInfoDto).build();
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

		
		String id = "test1";
		String pw = "test1";
		
		String salt = userInfoService.getUserSalt(id);
		System.out.println(salt);
		
		String securePw = SecureClass.sha512(pw, salt);
		UserInfoDto userInfoDto = new UserInfoDto();
		userInfoDto.setId(id);
		userInfoDto.setPassword(securePw);

		UserInfoDto myInfo = userInfoService.getUserInfo(userInfoDto);

		String json = "";

		if (myInfo == null) {
			json = "missmatched";
		} else {
			json = new Gson().toJson(myInfo);
		}
		System.out.println(json);
	}

}
