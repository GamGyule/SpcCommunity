package com.spc.comunity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.dto.HumorBoardDto;
import com.spc.comunity.entity.FreeBoard;
import com.spc.comunity.entity.HumorBoard;

@Repository
public interface JpaHumorBoardRepository extends JpaRepository<HumorBoard, Integer> {
	
	


}
