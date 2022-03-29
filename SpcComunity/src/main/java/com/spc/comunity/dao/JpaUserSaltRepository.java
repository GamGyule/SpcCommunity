package com.spc.comunity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.dto.UserInfo;
import com.spc.comunity.dto.UserSalt;

@Repository
public interface JpaUserSaltRepository extends JpaRepository<UserSalt, String> {
	
	UserSalt save(final UserSalt userSalt);


}
