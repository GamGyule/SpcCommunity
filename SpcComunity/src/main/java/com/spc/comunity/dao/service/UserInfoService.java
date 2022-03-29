package com.spc.comunity.dao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spc.comunity.dao.JpaUserInfoRepository;
import com.spc.comunity.dao.MybatisUserInfoRepository;
import com.spc.comunity.dto.UserInfo;


@Service
public class UserInfoService {
	
	@Autowired
	private JpaUserInfoRepository userInfoRepository;
	
	@Autowired
	private MybatisUserInfoRepository mybatisInfoRepository;
	
	public List<UserInfo> jpaFindAll() {
		return userInfoRepository.findAll();
	}
	
	@Transactional
	public List<UserInfo> mybatisFindAll(){
		return mybatisInfoRepository.findAll();
	}

}
