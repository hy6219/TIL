package com.js.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.test.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public List<BoardDto> selectList() {
		// TODO Auto-generated method stub
		List<BoardDto> list= new ArrayList<BoardDto>();
		
		try {
			
			list=session.selectList(NAMESPACE+"selectList");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BoardDto selectOne(int myNo) {
		// TODO Auto-generated method stub
		BoardDto dto=new BoardDto();
		
		try {
			dto=session.selectOne(NAMESPACE+"selectOne",myNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		
		int resIns=0;
		
		try {
			
			resIns=session.insert(NAMESPACE+"insert",dto);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resIns;
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		int resUp=0;
		
		try {
			
			resUp=session.update(NAMESPACE+"update",dto);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resUp;
	}

	@Override
	public int delete(int myNo) {
		// TODO Auto-generated method stub
		int resDel=0;
		
		try{
			resDel=session.delete(NAMESPACE+"delete",myNo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return resDel;
	}

}
