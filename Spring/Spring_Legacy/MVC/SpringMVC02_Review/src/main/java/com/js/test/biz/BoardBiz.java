package com.js.test.biz;

import java.util.List;

import com.js.test.dto.BoardDto;

public interface BoardBiz {
	List<BoardDto> selectList();
	BoardDto 		selectOne(int myNo);
	int 			insert(BoardDto dto);
	int				update(BoardDto dto);
	int				delete(int myNo);
}
