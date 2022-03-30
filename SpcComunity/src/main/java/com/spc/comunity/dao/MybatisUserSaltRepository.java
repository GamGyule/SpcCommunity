package com.spc.comunity.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.UserInfo;

@Mapper
public interface MybatisUserSaltRepository {

	List<UserInfo> findAll();

	boolean findById(final String id);
	
	UserInfo getUserInfo(final HashMap<String, String> map);
}
