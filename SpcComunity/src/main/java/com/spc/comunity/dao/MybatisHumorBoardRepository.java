package com.spc.comunity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spc.comunity.dto.HumorBoardDto;

@Mapper
public interface MybatisHumorBoardRepository {
	int findCountAll();
	
	List<HumorBoardDto> findPage(int page);
	
	List<HumorBoardDto> findLately();

	HumorBoardDto findBoard(int boardNum);
	
	
}
