package com.spc.comunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.UserInfo;

@Mapper
public interface MybatisUserInfoRepository {
	
	List<UserInfo> findAll();

}
