package com.roh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.roh.domain.BoardVo;
import com.roh.domain.Criteria;

public interface BoardMapper {

	// 테스트 용도
	public String getTime() throws Exception;

	public void create(BoardVo vo) throws Exception;

	public BoardVo read(Integer bno) throws Exception;

	public int update(BoardVo vo) throws Exception;

	public int delete(Integer bno) throws Exception;

	public List<BoardVo> listAll(Criteria cri) throws Exception;
	
	public int countPaging() throws Exception;
	
//	public List<BoardVo> listSearch(SearchCriteria cri) throws Exception;
//
//	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 테스트에 사용될 메서드
	@Delete("delete from t_board")
	public void deleteAll() throws Exception;
	
	@Select("select count(*) from t_board")
	public int getCount() throws Exception;
	
//	@Select("select max(to_number(bno)) from t_board")
	@Select("select max(bno) from t_board")
	public Integer getLastBno() throws Exception;
}
