package com.spc.comunity.dao.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.JpaUserInfoRepository;
import com.spc.comunity.dao.MybatisUserInfoRepository;
import com.spc.comunity.dto.UserInfoDto;
import com.spc.comunity.entity.UserInfo;

public class FreeBoardService {
	@Autowired
	private JpaFreeBoardRepository jpaFreeBoardRepositry;
	
	@Autowired
	private MybatisFreeBoardRepository mybatisFreeBoardRepository;
	
	
	@Transactional
	public List<FreeBoardDTO> findAll(){
		return mybatisInfoRepository.findAll();
	}
	
	@Transactional
	public UserInfo userInfoSave(UserInfo userInfo) {
		
		return jpaUserInfoRepository.save(userInfo);
	}
	
	@Transactional
	public boolean findById(String id) {
		return mybatisFreeBoardRepository.findById(id);
	}
	
	@Transactional
	public FreeBoardDto getFreeBoardInfo(FreeBoardDto freeBoardDtO) {
		HashMap<String, String> map = new HashMap<>();
		
		map.put("id", userInfoDto.getId());
		map.put("pw",userInfoDto.getPassword());
		
		return mybatisInfoRepository.getUserInfo(map);
	}
	
	@Transactional
	public String getUserSalt(String id) {
		return mybatisInfoRepository.getUserSalt(id);
	}
}
