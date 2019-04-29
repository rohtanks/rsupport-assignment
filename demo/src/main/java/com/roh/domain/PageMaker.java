package com.roh.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 페이지 계산 및 처리 클래스
 * @author roh
 *
 */
public class PageMaker {

	// 전체 데이터 갯수
	private int totalCount;
	// 페이징 시작 페이지 번호
	private int startPage;
	// 페이징 끝 페이지 번호
	private int endPage;
	// 이전 페이지 링크 여부
	private boolean prev;
	// 다음 페이지 링크 여부
	private boolean next;
	// 페이징 한번에 보여지는 페이지 번호 갯수
	private int displayPageNum;
	
	// 현재 페이지와 페이지당 데이터 수를 얻기 위한 데이터
	private Criteria cri;
	
	public PageMaker() {
		displayPageNum = 10;
	}
	
	public void setDisplayPageNum(int displayPageNum) {
		if (displayPageNum <= 0 || displayPageNum > 50) {
			this.displayPageNum = 10;
			return;
		}
		this.displayPageNum = displayPageNum;
	}
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	// 전체 데이터 수정 시점에 계산
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	private void calcData() {
		// 1. endPage 계산
		endPage = (int) (Math.ceil(cri.getPage() / (double) displayPageNum) * displayPageNum);
		// 2. startPage 계산
		startPage = (endPage - displayPageNum) + 1;
		
		// 3. endPage totalCount와 비교 재계산
		// 전체 데이터 수 / 페이지당 데이터 수 = 실제 마지막 페이지
		int tempEndPage = (int) (Math.ceil(totalCount / (double) cri.getPerPageNum()));
		
		if (tempEndPage < endPage) endPage = tempEndPage;
		
		// 4. prev, next 계산
		prev = (startPage == 1) ? false : true;
		// 끝 페이지 * 페이지당 데이터 수 < 전체 데이터 수
		next = (endPage * cri.getPerPageNum() >= totalCount) ? false : true;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean getPrev() {
		return prev;
	}

	public boolean getNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}
	
	/**
	 * URI(쿼리스트링) 생성 메서드
	 * @param page
	 * @return
	 */
	public String makeQuery(int page) {
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
}
