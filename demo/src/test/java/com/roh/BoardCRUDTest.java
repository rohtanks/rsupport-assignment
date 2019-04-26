package com.roh;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roh.domain.BoardVo;
import com.roh.mapper.BoardMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardCRUDTest {

	@Autowired
	private BoardMapper mapper;
	
	private BoardVo board1;
	private BoardVo board2;
	private BoardVo board3;
	
	@Before
	public void setUp() {
		// 픽스처
		board1 = new BoardVo("Test", "Test Test Test...", "roh1");
		board2 = new BoardVo("테스트공지입니다.", "한글 테스트 공지입니다.", "roh1");
		board3 = new BoardVo("Test2", "Test Test Test...2", "roh2");
	}
	
	@Test
	public void testGetTime() throws Exception {
		System.out.println(mapper.getTime());
	}
	
	@Test
	public void testGetCount() throws Exception {
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		mapper.create(board1);
		assertThat(mapper.getCount(), is(1));
		mapper.create(board2);
		assertThat(mapper.getCount(), is(2));
		mapper.create(board3);
		assertThat(mapper.getCount(), is(3));
	}
	
	@Test
	public void testCreateAndRead() throws Exception {
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		// 인서트 테스트
		mapper.create(board1);
		assertThat(mapper.getCount(), is(1));
		
		// 마지막으로 입력된 게시글 번호 가져오기(MyBatis 한정)
		int lastBno = mapper.getLastBno();
		
		// 셀렉트 테스트
		BoardVo board1Read = mapper.read(lastBno);
//		assertThat(board1.getTitle(), is(board1Read.getTitle()));
//		assertThat(board1.getContent(), is(board1Read.getContent()));
//		assertThat(board1.getWriter(), is(board1Read.getWriter()));
		checkSameBoard(board1Read, board1);
	}
	
	@Test
	public void testUpdate() throws Exception {
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		mapper.create(board1); // 수정하지 않은 게시글
		mapper.create(board2);
		
		// board2 게시글 번호
		int board2Bno = mapper.getLastBno();
		
		// board2 수정
		board2.setTitle("테스트 제목");
		board2.setContent("테스트 내용");
		board2.setWriter("테스트 작성자");
		board2.setBno(board2Bno);
		
		int updateCnt = mapper.update(board2);
		assertThat(updateCnt, is(1));
		
		BoardVo board2Update = mapper.read(mapper.getLastBno());
		checkSameBoard(board2Update, board2);
	}
	
	@Test
	public void testDelete() throws Exception {
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		mapper.create(board1);
		mapper.create(board2);
		mapper.create(board3); // 삭제 대상
		assertThat(mapper.getCount(), is(3));
		
		// board3 게시글 번호
		int board3Bno = mapper.getLastBno();
		
		int deleteCnt = mapper.delete(board3Bno);
		assertThat(deleteCnt, is(1));
		
		// 남은 게시글 카운트 = 2
		assertThat(mapper.getCount(), is(2));
		
	}

	private void checkSameBoard(BoardVo vo1, BoardVo vo2) {
		assertThat(vo1.getTitle(), is(vo2.getTitle()));
		assertThat(vo1.getContent(), is(vo2.getContent()));
		assertThat(vo1.getWriter(), is(vo2.getWriter()));
	}
}
