package com.spc.comunity.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.UserInfoDto;
import com.spc.comunity.entity.UserInfo;

@Mapper
public interface MybatisUserInfoRepository {

	List<UserInfoDto> findAll();

	boolean findById(final String id);
	
	UserInfoDto getUserInfo(final HashMap<String, String> map);
	
	String getUserSalt(final String id);
}
