package com.spc.comunity.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.dto.UserInfo;

@Repository
public interface JpaUserInfoRepository extends JpaRepository<UserInfo, UUID> {
	
	List<UserInfo> findAll();

}
