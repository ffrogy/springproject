package com.edu.board.service;

import java.util.HashMap;
import java.util.List;

import com.edu.board.dto.BoardDTO;

//-----------------------------------------------------------------------------------------
// 게시글 서비스
//-----------------------------------------------------------------------------------------
public interface BoardService {

	//-----------------------------------------------------------------------------------------
	// 게시글 등록 처리하기
	//-----------------------------------------------------------------------------------------
	public int boardRegister(BoardDTO boardDTO) throws Exception;

	//-----------------------------------------------------------------------------------------
	// 게시글 목록 보기
	//-----------------------------------------------------------------------------------------
	public List<BoardDTO> boardList() throws Exception;

	//-----------------------------------------------------------------------------------------
	// 게시글 상세 조회 GET
	//-----------------------------------------------------------------------------------------
	public BoardDTO boardDetail(int bno, int flag) throws Exception;

	//-----------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------
	public int boardDelete(int bno);
	
	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	public int boardUpdate(BoardDTO boardDTO);
	
	//-----------------------------------------------------------------------------------------------------------
	// 전체 게시글 수 가져오기 (Paging 1 처리)
	//-----------------------------------------------------------------------------------------------------------
	public int boardListTotalCount1() throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 요청된 페이지에 해당하는 게시글을 가져온다.
	//-----------------------------------------------------------------------------------------------------------
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception;
	
	
	
	
	} // End - public interface BoardService
	
	
	
	
