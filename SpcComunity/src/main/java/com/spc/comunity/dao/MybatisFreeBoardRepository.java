package com.spc.comunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.FreeBoardDto;

@Mapper
public interface MybatisFreeBoardRepository {
	List<FreeBoardDto> findAll();
	
	List<FreeBoardDto> findById(int idx);
	
	List<FreeBoardDto> findPage(int page);
	
	List<FreeBoardDto> findLately();
	
}
