package com.edu.board.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

// -----------------------------------------------------------------------------------------
// public class BoardDTO : 게시글
// @Component : Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
// Bean 등록 자체를 Bean Class 자체에 할 수 있다는 의미
// -----------------------------------------------------------------------------------------
@Component("boardDTO")
public class BoardDTO {

	private int			bno;		// 게시글 번호
	private String		subject;	// 제목
	private String 		content;	// 내용
	private String		writer;		// 작성자
	private Timestamp	reg_date;	// 작성일
	private int			readCount;	// 조회수
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", subject=" + subject + ", content=" + content + ", writer=" + writer
				+ ", reg_date=" + reg_date + ", readCount=" + readCount + "]";
	}
	
} // End - public class BoardDTO
