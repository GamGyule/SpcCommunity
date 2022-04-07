package com.spc.comunity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.FreeBoardService;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.dto.UserInfoDto;
import com.spc.comunity.entity.UserInfo;
import com.spc.comunity.util.SecureClass;

@SpringBootTest
class SpcComunityApplicationTests {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private FreeBoardService freeBoardService;

	@Test
	@DisplayName("회원가입 테스트")
	void 회원가입_테스트입니다() {

		String id = "test1";
		boolean alreadyId = userInfoService.findById(id);
		if (!alreadyId) {

			// UUID 생성 "-" 빼고
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");

			// SALT 문자열 임의 생성
			String salt = SecureClass.UserSaltGen();

			// 회원 정보에 들어갈 비밀번호+salt 암호화
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
	
	@Test
	void 게시판_리스트() {
		List<FreeBoardDto> list = freeBoardService.findAll();
		
		String json = new Gson().toJson(list);
		
		System.out.println(json);
	}

}
