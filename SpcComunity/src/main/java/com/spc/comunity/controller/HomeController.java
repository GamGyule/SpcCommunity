package com.spc.comunity.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dao.service.UserSaltService;
import com.spc.comunity.dto.UserInfo;
import com.spc.comunity.dto.UserSalt;
import com.spc.comunity.util.SecureClass;

@RestController
@RequestMapping("/api/*")
public class HomeController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserSaltService userSaltService;

	@GetMapping("/hi")
	public String Hi() {
		List<UserInfo> mybatisUserInfoList = userInfoService.findAll();

		String myJson = new Gson().toJson(mybatisUserInfoList);

		List<List<UserInfo>> list = new ArrayList<>();

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
			String randomStr = UserSalt.UserSaltGen();
			
			// SALT Ŭ������ �־��ְ� jpa insert
			UserSalt userSalt = UserSalt.UserSaltBuilder().uuid(uuid).salt(randomStr).build();
			userSaltService.userSaltSave(userSalt);
			
			// ȸ�� ������ �� ��й�ȣ+salt ��ȣȭ
			String securePw = SecureClass.sha512(req.getParameter("password"), userSalt.getSalt());
			UserInfo userInfo = UserInfo.UserInfoBuilder()
					.uuid(uuid)
					.id(id)
					.password(securePw)
					.userName(req.getParameter("username"))
					.email(req.getParameter("email"))
					.regDate(new Date())
					.build();
			
			// ȸ������ �Է� jpa insert
			userInfoService.userInfoSave(userInfo);
		} else {
			// �̹� �ִ� ���̵�
			return "Already";
		}
		return "Success";
	}

}
