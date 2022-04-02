package com.spc.comunity.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.FreeBoardDto;

@Mapper
public interface MybatisFreeBoardRepository {
	List<FreeBoardDto> findAll();
	
	boolean findByTitle(final String title);
	
	FreeBoardDto getFreeBoardDto(final HashMap<String, String> map);
	
	
}
