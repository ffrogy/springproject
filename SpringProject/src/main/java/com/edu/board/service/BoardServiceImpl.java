package com.edu.board.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.board.dao.BoardDAO;
import com.edu.board.dto.BoardDTO;

//-----------------------------------------------------------------------------------------
//게시글 서비스
//-----------------------------------------------------------------------------------------
@Service	// Bean으로 인식시키기 위해서 사용한다.
public class BoardServiceImpl implements BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);	
	
	@Inject
	private BoardDAO boardDAO;

	//-----------------------------------------------------------------------------------------
	// 게시글 등록 처리하기
	//-----------------------------------------------------------------------------------------
	@Override
	public int boardRegister(BoardDTO boardDTO) throws Exception {

		/*
		// 게시글이 하나도 존재하지 않을 경우(맨 처음으로 게시글을 등록할 때)
		if(boardDAO.getMaxBno() == null) {	// 게시글 번호를 1로 한다.
			boardDTO.setBno(1);
		} else {	// 최대값에 1을 더한 게시글 번호로 한다.
			boardDTO.setBno(boardDAO.getMaxBno() + 1); 
		}
		*/
		
		logger.info("BoardServiceImpl 게시글 등록하기() 시작" + boardDTO);
		return boardDAO.boardRegister(boardDTO);
	}

	//-----------------------------------------------------------------------------------------
	// 게시글 목록 보기
	//-----------------------------------------------------------------------------------------
	@Override
	public List<BoardDTO> boardList() throws Exception {

		logger.info("BoardServiceImpl 게시글 목록 보기() 시작");
		return boardDAO.boardList();
	}

	//-----------------------------------------------------------------------------------------
	// 게시글 상세 조회 GET
	//-----------------------------------------------------------------------------------------
	@Override
	 public BoardDTO boardDetail(int bno, int flag) throws Exception {

		logger.info("BoardServiceImpl 게시글 상세 조회() 시작");
		
		// 게시글 번호에 해당하는 게시글의 자료를 가져오기 전에 조회수를 1증가 시킨다.
		if(flag == 0) {
			boardDAO.updateReadCount(bno);
		}
		return boardDAO.boardDetail(bno);
		
	} // End - 게시글 상세 조회

	//-----------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------
	@Override
	public int boardDelete(int bno) {

		logger.info("BoardServiceImpl 게시글 번호에 해당하는 게시글 삭제하기() 시작");
		return boardDAO.boardDelete(bno);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int boardUpdate(BoardDTO boardDTO) {

		logger.info("BoardServiceImpl 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기() 시작");
		return boardDAO.boardUpdate(boardDTO);
		
	} // End - 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기

	//-----------------------------------------------------------------------------------------------------------
	// 전체 게시글 수 가져오기 (Paging 1 처리)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int boardListTotalCount1() throws Exception {
		logger.info("BoardServiceImpl 전체 게시글 수 가져오기 (Paging 1 처리) 시작");
		return boardDAO.boardListTotalCount1();
	}

	//-----------------------------------------------------------------------------------------------------------
	// 요청된 페이지에 해당하는 게시글을 가져온다.
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception {
		logger.info("BoardServiceImpl 요청된 페이지에 해당하는 게시글을 가져오기() 시작");
		System.out.println("페이지 정보보기 => " + pageList.get("pageNum"));
		System.out.println("페이지 정보보기 => " + pageList.get("pageSize"));
		return boardDAO.boardListPaging1(pageList);
	}
	
	
	
	
	
	
	
	

}
