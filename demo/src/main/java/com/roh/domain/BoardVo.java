package com.roh.domain;

import java.util.Date;

public class BoardVo {

	// null처리 유연하게 하기 위해
	private Integer bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date upddate;
	private int viewcnt;

	public BoardVo() {
	}
	
	public BoardVo(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Date getUpddate() {
		return upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", upddate=" + upddate + ", viewcnt=" + viewcnt + "]";
	}

}
