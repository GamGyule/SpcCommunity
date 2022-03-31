package com.spc.comunity.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dto.UserInfoDto;
import com.spc.comunity.entity.UserInfo;
import com.spc.comunity.util.SecureClass;

@RestController
@RequestMapping("/api/*")
public class HomeController {

	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/hi")
	public String Hi() {
		List<UserInfoDto> mybatisUserInfoList = userInfoService.findAll();

		List<List<UserInfoDto>> list = new ArrayList<>();

		list.add(mybatisUserInfoList);

		String json = new Gson().toJson(list);
		return json;
	}

	// POST ȸ������
	@PostMapping("/user")
	public String Signup(HttpServletRequest req) {


		String id = req.getParameter("id");
		boolean alreadyId = userInfoService.findById(id);
		if (!alreadyId) {

			// UUID ���� "-" ����
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");

			// SALT ���ڿ� ���� ����
			String salt = SecureClass.UserSaltGen();

			// ȸ�� ������ �� ��й�ȣ+salt ��ȣȭ
			String securePw = SecureClass.sha512(req.getParameter("pw"), salt);
			UserInfoDto userInfoDto = new UserInfoDto();
			userInfoDto.setUuid(uuid);
			userInfoDto.setId(id);
			userInfoDto.setPassword(securePw);
			userInfoDto.setUserName(req.getParameter("username"));
			userInfoDto.setEmail(req.getParameter("email"));
			userInfoDto.setRegDate(new Date());
			userInfoDto.setSalt(salt);
			
			
			UserInfo userInfo = UserInfo.builder(userInfoDto).build();
			// ȸ������ �Է� jpa insert
			userInfoService.userInfoSave(userInfo);
		} else {
			// �̹� �ִ� ���̵�
			return "Already";
		}
		return "Success";
	}
	
	@PostMapping("/login")
	public String Login(HttpServletRequest req) {
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		System.out.println(id);
		System.out.println(pw);
		
		String salt = userInfoService.getUserSalt(id);
		
		String securePw = SecureClass.sha512(pw, salt);
		System.out.println(salt);
		System.out.println(securePw);
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
		return json;
	}

}
