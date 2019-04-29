package com.roh.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.roh.domain.BoardVo;

public interface BoardMapper {

	// 테스트 용도
	public String getTime() throws SQLException;

	public void create(BoardVo vo) throws SQLException;

	public BoardVo read(Integer bno) throws SQLException;

	public int update(BoardVo vo) throws SQLException;

	public int delete(Integer bno) throws SQLException;

	public List<BoardVo> listAll() throws SQLException;
//
//	public List<BoardVo> listPage(int page) throws Exception;
//
//	public List<BoardVo> listCriteria(Criteria cri) throws Exception;
//
//	public int countPaging(Criteria cri) throws Exception;
//
//	public List<BoardVo> listSearch(SearchCriteria cri) throws Exception;
//
//	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 테스트에 사용될 메서드
	@Delete("delete from t_board")
	public void deleteAll() throws SQLException;
	
	@Select("select count(*) from t_board")
	public int getCount() throws SQLException;
	
//	@Select("select max(to_number(bno)) from t_board")
	@Select("select max(bno) from t_board")
	public Integer getLastBno() throws SQLException;
}
