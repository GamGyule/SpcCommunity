package com.spc.comunity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.dto.UserInfo;

@Repository
public interface JpaUserInfoRepository extends JpaRepository<UserInfo, String> {
	
	UserInfo save(final UserInfo userInfo);


}
