package com.roh;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roh.domain.MemberVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSession;
	
	@Test
	public void contextLoads() {
	}
	
	/*
	 * H2 설정 후 DB Connection 테스트
	 */
	@Test
	public void testConnection() {
		assertThat(dataSource, is(notNullValue()));
		
		try (Connection con = dataSource.getConnection()) {
			assertThat(con, is(notNullValue()));
			System.out.println(con);
			
			String url = con.getMetaData().getURL();
			System.out.println(url);
			System.out.println(con.getMetaData().getDriverName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetTable() {
		try (Connection con = dataSource.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from t_member");
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				MemberVo member = new MemberVo();
				member.setUserid(rs.getString("userid"));
				member.setUserpw(rs.getString("userpw"));
				member.setUsername(rs.getString("username"));
				member.setEmail(rs.getString("email"));
				member.setRegdate(rs.getDate("regdate"));
				member.setUpddate(rs.getDate("upddate"));
				
				System.out.println(member.toString());
			}
		} catch (Exception se) {
			System.out.println(se.getMessage());
		}
	}
	
	/*
	 * MyBatis 설정 후 Session 테스트
	 */
	@Test
	public void testSqlSession() {
		assertThat(sqlSession, is(notNullValue()));
		System.out.println(sqlSession);
	}

}
