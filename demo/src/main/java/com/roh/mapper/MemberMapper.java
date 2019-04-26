package com.roh.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.roh.domain.MemberVo;

public interface MemberMapper {

	// XML 대신 Mapper interface 사용해봄
	@Insert("insert into t_member (userid, userpw, username, email) "
			+ "values (#{userid}, #{userpw}, #{username}, #{email})")
	public void create(MemberVo vo) throws SQLException;
	
	@Select("select userid, userpw, username, email, regdate, upddate "
			+ "from t_member "
			+ "where userid = #{userid}")
	public MemberVo read(String userid) throws SQLException;
	
	@Update("update t_member "
			+ "set userpw = #{userpw}, username = #{username}, "
			+ "email = #{email}, upddate = sysdate "
			+ "where userid = #{userid}")
	public int update(MemberVo vo) throws SQLException;
	
	@Delete("delete from t_member "
			+ "where userid = #{userid}")
	public int delete(String userid) throws SQLException;
	
	// 테스트에 사용될 메서드
	@Delete("delete from t_member")
	public void deleteAll() throws SQLException;
	
	@Select("select count(*) from t_member")
	public int getCount() throws SQLException;
}
