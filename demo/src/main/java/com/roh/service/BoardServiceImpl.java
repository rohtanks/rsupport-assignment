package com.roh.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.domain.BoardVo;
import com.roh.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void regist(BoardVo vo) throws SQLException {
		mapper.create(vo);
	}

	@Override
	public List<BoardVo> listAll() throws SQLException {
		
		return mapper.listAll();
	}

	@Override
	public BoardVo read(Integer bno) throws SQLException {
		
		return mapper.read(bno);
	}

	@Override
	public int remove(Integer bno) throws SQLException {
		int result = -1;
		result = mapper.delete(bno);
		if (result > 1) throw new SQLException();
		
		return result;
	}

	@Override
	public int modify(BoardVo vo) throws SQLException {
		int result = -1;
		result = mapper.update(vo);
		if (result > 1) throw new SQLException();
		
		return result;
	}

}
