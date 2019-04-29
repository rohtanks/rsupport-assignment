package com.roh.service;

import java.sql.SQLException;
import java.util.List;

import com.roh.domain.BoardVo;

public interface BoardService {

	public void regist(BoardVo vo) throws SQLException;
	
	public List<BoardVo> listAll() throws SQLException;
	
	public BoardVo read(Integer bno) throws SQLException;

	public int remove(Integer bno) throws SQLException;

	public int modify(BoardVo vo) throws SQLException;
}
