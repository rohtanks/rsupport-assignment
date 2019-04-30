package com.roh;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roh.domain.BoardVo;
import com.roh.domain.Criteria;
import com.roh.domain.PageMaker;
import com.roh.service.BoardService;

/**
 * 게시판 기능 테스트
 * @author roh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	private BoardService service;
	
	/**
	 * 게시판 페이징 쿼리 테스트
	 * @throws Exception
	 */
	@Test
	public void testPageSQL() throws Exception {
		int page = 11, perPageNum = 11;
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		
		List<BoardVo> listPage = service.listAll(cri);
		assertThat(listPage.size(), is(perPageNum));
		
		logger.info("=============================");
		for (BoardVo boardVo : listPage) {
			logger.info(boardVo.toString());
		}
		logger.info("=============================");

		cri = new Criteria();
		cri.setPage(4);
		
		List<BoardVo> listNotPerPageNum = service.listAll(cri);
		assertThat(listNotPerPageNum.size(), is(10));
		
		logger.info("*****************************");
		for (BoardVo boardVo : listNotPerPageNum) {
			logger.info(boardVo.toString());
		}
		logger.info("*****************************");
	}
	
	/**
	 * 게시판 페이징 테스트
	 * @throws Exception
	 */
	@Test
	public void testPageCalculate() throws Exception {
		Criteria cri = new Criteria();
		PageMaker pageMaker = new PageMaker();
		int totalCount = service.countTotalNum();
		
		// 페이지 번호 3 경우
		// 시작 페이지(startPage): 1
		// 끝 페이지(endPage): 10
		// 이후 페이지(next): true
		// 이전 페이지(prev): false
		cri.setPage(3);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		logger.info(pageMaker.toString());
		assertThat(pageMaker.getStartPage(), is(1));
		assertThat(pageMaker.getEndPage(), is(10));
		assertThat(pageMaker.getNext(), is(true));
		assertThat(pageMaker.getPrev(), is(false));
		
		// 페이지 번호 10, 전체 데이터 100 경우
		// 시작 페이지(startPage): 1
		// 끝 페이지(endPage): 10
		// 이후 페이지(next): false
		// 이전 페이지(prev): false
		cri = new Criteria();
		cri.setPage(10);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(100);
		
		logger.info(pageMaker.toString());
		assertThat(pageMaker.getStartPage(), is(1));
		assertThat(pageMaker.getEndPage(), is(10));
		assertThat(pageMaker.getNext(), is(false));
		assertThat(pageMaker.getPrev(), is(false));
		
		// 페이지 번호 20, 전체 데이터 201 경우
		// 시작 페이지(startPage): 1
		// 끝 페이지(endPage): 10
		// 이후 페이지(next): false
		// 이전 페이지(prev): false
		cri = new Criteria();
		cri.setPage(20);
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(201);
		
		logger.info(pageMaker.toString());
		assertThat(pageMaker.getStartPage(), is(11));
		assertThat(pageMaker.getEndPage(), is(20));
		assertThat(pageMaker.getNext(), is(true));
		assertThat(pageMaker.getPrev(), is(true));
		
		// negative
		// 페이지 번호 7, 보여지는 페이지 갯수 5, 전체 데이터 81 경우
		// 시작 페이지(startPage): 6
		// 끝 페이지(endPage): 10이 아님
		// 페이지 번호의 갯수(displayPageNum): 10이 아님
		// 이후 페이지(next): false
		// 이전 페이지(prev): true
		cri = new Criteria();
		cri.setPage(7);
		pageMaker.setCri(cri);
		pageMaker.setDisplayPageNum(5);
		pageMaker.setTotalCount(81);
		
		logger.info(pageMaker.toString());
		assertThat(pageMaker.getStartPage(), is(6));
		assertThat(pageMaker.getEndPage(), is(not(10)));
		assertThat(pageMaker.getDisplayPageNum(), is(not(10)));
		assertThat(pageMaker.getNext(), is(false));
		assertThat(pageMaker.getPrev(), is(true));
		
	}
}
