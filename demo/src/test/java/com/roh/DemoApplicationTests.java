package com.roh;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
