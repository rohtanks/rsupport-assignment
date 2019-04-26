package com.roh;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.roh.domain.MemberVo;
import com.roh.mapper.MemberMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberCRUDTest {

	@Autowired
	private MemberMapper mapper;
	
	private MemberVo member1;
	private MemberVo member2;
	private MemberVo member3;
	
	@Before
	public void setUp() {
		// 픽스처
		member1 = new MemberVo("roh1", "password1", "name1");
		member2 = new MemberVo("roh2", "password2", "name2");
		member3 = new MemberVo("roh3", "password3", "name3");
	}
	
	@Test
	public void testCreatAndRead() throws Exception {
		
		// 테이블 초기화
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		// 인서트 카운트 테스트
		mapper.create(member1);
		assertThat(mapper.getCount(), is(1));
		
		// 정확한 값 비교
		MemberVo dbMember1 = mapper.read(member1.getUserid());
		checkSameMember(dbMember1, member1);
	}
	
	@Test
	public void testGetCount() throws Exception {
		// 테이블 초기화
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		// 입력에 따른 테이블 로우 수 확인
		mapper.create(member1);
		assertThat(mapper.getCount(), is(1));

		mapper.create(member2);
		assertThat(mapper.getCount(), is(2));
		
		mapper.create(member3);
		assertThat(mapper.getCount(), is(3));
		
		
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		// 테이블 초기화
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		mapper.create(member1);
		mapper.create(member2); // 수정하지 않을 사용자
		
		member1.setUserpw("pw111");
		member1.setUsername("아람");
		
		mapper.update(member1);
		
		MemberVo mem1update = mapper.read(member1.getUserid());
		checkSameMember(mem1update, member1);
		
		// 정확한 타겟만 업데이트됐는지 검증
		MemberVo mem2same = mapper.read(member2.getUserid());
		checkSameMember(mem2same, member2);
		
	}
	
	@Test
	public void testDelete() throws Exception {
		
		// 테이블 초기화
		mapper.deleteAll();
		assertThat(mapper.getCount(), is(0));
		
		mapper.create(member1);
		mapper.create(member2);
		mapper.create(member3);
		assertThat(mapper.getCount(), is(3));
		
		// member2 삭제
		mapper.delete(member2.getUserid());
		assertThat(mapper.getCount(), is(2));
		
		MemberVo nullMember = mapper.read(member2.getUserid());
		assertThat(nullMember, is(nullValue()));
	}
	
	private void checkSameMember(MemberVo mem1, MemberVo mem2) {
		assertThat(mem1.getUserid(), is(mem2.getUserid()));
		assertThat(mem1.getUserpw(), is(mem2.getUserpw()));
		assertThat(mem1.getUsername(), is(mem2.getUsername()));
	}
}
