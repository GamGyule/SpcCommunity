package com.spc.comunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.HumorBoardDto;

@Mapper
public interface MybatisHumorBoardRepository {
	List<HumorBoardDto> findAll();
	
	List<HumorBoardDto> findPage(int page);
	
	List<HumorBoardDto> findLately();
	
//	boolean findByTitle(final String title);
	
//	FreeBoardDto getFreeBoardDto(final HashMap<String, String> map);
	
	
}
