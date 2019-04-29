package com.roh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roh.domain.BoardVo;
import com.roh.domain.Criteria;
import com.roh.domain.PageMaker;
import com.roh.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void regist(BoardVo vo) throws Exception {
		mapper.create(vo);
	}

//	@Override
//	public List<BoardVo> listAll() throws Exception {
//		
//		return mapper.listAll();
//	}
	
	@Override
	public List<BoardVo> listAll(Criteria cri) throws Exception {
		
		return mapper.listAll(cri);
	}

	@Override
	public BoardVo read(Integer bno) throws Exception {
		
		return mapper.read(bno);
	}

	@Override
	public int remove(Integer bno) throws Exception {
		int result = -1;
		result = mapper.delete(bno);
		if (result > 1) throw new Exception();
		
		return result;
	}

	@Override
	public int modify(BoardVo vo) throws Exception {
		int result = -1;
		result = mapper.update(vo);
		if (result > 1) throw new Exception();
		
		return result;
	}

	@Override
	public int countTotalNum() throws Exception {
		return mapper.countPaging();
	}
	
	@Override
	public PageMaker makePage(Criteria cri) throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(countTotalNum());
		
		return pageMaker;
	}


}
