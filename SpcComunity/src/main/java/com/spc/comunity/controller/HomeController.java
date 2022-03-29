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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dao.service.UserSaltService;
import com.spc.comunity.dto.UserInfo;
import com.spc.comunity.dto.UserSalt;

@RestController
@RequestMapping("/api/*")
public class HomeController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserSaltService userSaltService;

	@RequestMapping("/hi")
	public String Hi() {
		List<UserInfo> mybatisUserInfoList = userInfoService.findAll();

		String myJson = new Gson().toJson(mybatisUserInfoList);

		List<List<UserInfo>> list = new ArrayList<>();

		list.add(mybatisUserInfoList);

		String json = new Gson().toJson(list);
		return json;
	}

	// POST 회원가입
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String Signup(HttpServletRequest req) {

		Random rnd = new Random();
		String randomStr = "";

		for (int i = 0; i <= 12; i++) {
			randomStr += String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
		}

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");

		UserSalt userSalt = UserSalt.UserSaltBuilder().uuid(uuid).salt(randomStr).build();

		String securePw = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			String temp = req.getParameter("password") + userSalt.getSalt();
			digest.reset();
			digest.update(temp.getBytes("utf8"));
			securePw = String.format("%0128x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UserInfo userInfo = UserInfo.UserInfoBuilder()
				.uuid(uuid)
				.id(req.getParameter("id"))
				.password(securePw)
				.userName(req.getParameter("username"))
				.email(req.getParameter("email"))
				.regDate(new Date())
				.build();

		boolean alreadyId = userInfoService.findById(userInfo.getId());
		if (!alreadyId) {
			userSaltService.userSaltSave(userSalt);
			userInfoService.userInfoSave(userInfo);
		} else {
			return "Already";
		}
		return "Success";
	}

}
