package com.edu.board.dto;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

// -----------------------------------------------------------------------------------------
// public class BoardDTO : 게시글
// @Component : Bean Configuration 파일에 Bean을 따로 등록하지 않아도 사용할 수 있다.
// Bean 등록 자체를 Bean Class 자체에 할 수 있다는 의미
// -----------------------------------------------------------------------------------------
@Component("boardDTO")
@Data
public class BoardDTO {

	private int			bno;		// 게시글 번호
	private String		subject;	// 제목
	private String 		content;	// 내용
	private String		writer;		// 작성자
	private Timestamp	reg_date;	// 작성일
	private int			readCount;	// 조회수
	
} // End - public class BoardDTO
