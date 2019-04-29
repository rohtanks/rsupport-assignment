package com.roh.service;

import java.util.List;

import com.roh.domain.BoardVo;
import com.roh.domain.Criteria;
import com.roh.domain.PageMaker;

public interface BoardService {

	public void regist(BoardVo vo) throws Exception;
	
	public List<BoardVo> listAll(Criteria cri) throws Exception;
	
	public BoardVo read(Integer bno) throws Exception;

	public int remove(Integer bno) throws Exception;

	public int modify(BoardVo vo) throws Exception;
	
	public int countTotalNum() throws Exception;
	
	public PageMaker makePage(Criteria cri) throws Exception;
}
