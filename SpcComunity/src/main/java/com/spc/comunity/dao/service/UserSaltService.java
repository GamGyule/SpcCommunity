package com.spc.comunity.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spc.comunity.dao.JpaUserSaltRepository;
import com.spc.comunity.dao.MybatisUserSaltRepository;
import com.spc.comunity.dto.UserSalt;

@Service
public class UserSaltService {

	@Autowired
	private JpaUserSaltRepository jpaUserSaltRepository;

	@Autowired
	private MybatisUserSaltRepository mybatisSaltRepository;

	@Transactional
	public UserSalt userSaltSave(UserSalt userSalt) {
		return jpaUserSaltRepository.save(userSalt);
	}

}
