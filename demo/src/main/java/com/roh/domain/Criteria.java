package com.roh.domain;

/**
 * 페이지 설정을 위한 기준(page, perPageNum) 클래스
 * @author roh
 *
 */
public class Criteria {

	// 조회하는 페이지 번호
	private int page;
	// 페이지당 보여지는 게시물 갯수
	private int perPageNum;

	// 기본값
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	// MyBatis 인라인 파라미터에 사용하기 위한 getter
	public int getStartNum() {
		return (page - 1) * perPageNum;
	}
	// MyBatis 인라인 파라미터에 사용하기 위한 getter
	public int getPerPageNum() {
		return perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
