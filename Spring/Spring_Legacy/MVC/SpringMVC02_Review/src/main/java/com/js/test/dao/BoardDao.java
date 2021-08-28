package com.js.test.dao;

import java.util.List;

import com.js.test.dto.BoardDto;

public interface BoardDao {
	final String NAMESPACE="myBoard.";
	
	List<BoardDto> selectList();
	BoardDto 		selectOne(int myNo);
	int 			insert(BoardDto dto);
	int				update(BoardDto dto);
	int				delete(int myNo);
}
