package com.spc.comunity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spc.comunity.dao.service.UserInfoService;
import com.spc.comunity.dto.UserInfo;

@RestController
public class HomeController {
	
	@Autowired
	private UserInfoService userInfoService;
	@RequestMapping("/api/hi")
	public String Hi() {
		List<UserInfo> mybatisUserInfoList = userInfoService.mybatisFindAll();
		List<UserInfo> jpaUserInfoList = userInfoService.jpaFindAll();
		
		String myJson = new Gson().toJson(mybatisUserInfoList);
		String jpaJson = new Gson().toJson(jpaUserInfoList);
		
		List<List<UserInfo>> list = new ArrayList<>();
		
		list.add(mybatisUserInfoList);
		list.add(jpaUserInfoList);
		
		
		String json = new Gson().toJson(list);
		return json;
	}

}
