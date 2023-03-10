package com.edu.board.dao;

import java.util.HashMap;
import java.util.List;

import com.edu.board.dto.BoardDTO;

//-----------------------------------------------------------------------------------------
//게시글 Data Access Object
//-----------------------------------------------------------------------------------------
public interface BoardDAO {
	
	//-----------------------------------------------------------------------------------------
	// 제일 큰 게시글 번호 가져오기
	//-----------------------------------------------------------------------------------------
	public Integer getMaxBno();
	
	//-----------------------------------------------------------------------------------------
	// 게시글 등록 처리하기
	//-----------------------------------------------------------------------------------------
	int boardRegister(BoardDTO boardDTO);

	//-----------------------------------------------------------------------------------------
	// 게시글 목록 보기
	//-----------------------------------------------------------------------------------------
	public List<BoardDTO> boardList() throws Exception;

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글의 조회수를 증가시키기
	//-----------------------------------------------------------------------------------------------------------
	public void updateReadCount(int bno);
	
	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 정보를 가져오기
	//-----------------------------------------------------------------------------------------------------------
	public BoardDTO boardDetail(int bno);

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------------------------
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
	// 게시글 목록 보기 1 (Paging 1 처리)
	// 요청된 페이지에 해당하는 게시글 가져오기 (Paging 1 처리)
	//-----------------------------------------------------------------------------------------------------------
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception;
	
	
	
} // End - public interface BoardDAO
