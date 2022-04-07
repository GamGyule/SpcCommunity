package com.spc.comunity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spc.comunity.dto.FreeBoardDto;
import com.spc.comunity.entity.FreeBoard;

@Repository
public interface JpaHumorBoardRepository extends JpaRepository<FreeBoard, String> {
	
	FreeBoard save(final FreeBoardDto freeBoardDto);


}
