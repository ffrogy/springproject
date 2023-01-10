package com.edu.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.board.dto.BoardDTO;

//-----------------------------------------------------------------------------------------
//게시글 Data Access Object
//-----------------------------------------------------------------------------------------
@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);	
	
	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	// Namespace 조심하기 : xml의 namespace와 동일해야 한다.
	private static String Namespace = "com.edu.board";
	
	//-----------------------------------------------------------------------------------------
	// 제일 큰 게시글 번호 가져오기
	//-----------------------------------------------------------------------------------------
	@Override
	public Integer getMaxBno() {
		
		logger.info("BoardDAOImpl 제일 큰 게시글 번호 가져오기() 시작");
		return sqlSession.selectOne(Namespace + ".maxBno");
	}	// End - 제일 큰 게시글 번호 가져오기

	//-----------------------------------------------------------------------------------------
	// 게시글 등록 처리하기
	//-----------------------------------------------------------------------------------------
	@Override
	public int boardRegister(BoardDTO boardDTO) {

		logger.info("BoardDAOImpl 게시글 등록 처리하기() 시작");
		return sqlSession.insert(Namespace + ".insertBoard", boardDTO);
	}	// End - 게시글 등록 처리하기

	//-----------------------------------------------------------------------------------------
	// 게시글 목록 보기
	//-----------------------------------------------------------------------------------------
	@Override
	public List<BoardDTO> boardList() throws Exception {

		logger.info("BoardDAOImpl 게시글 목록 보기() 시작");
		
		List<BoardDTO> boardList = sqlSession.selectList(Namespace + ".listAll");
		return boardList;
	}

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글의 조회수를 증가시키기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public void updateReadCount(int bno) {
		logger.info("BoardDAOImpl 게시글 번호에 해당하는 게시글의 조회수를 증가시키기() 시작");
		sqlSession.update(Namespace + ".updateReadCount", bno);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 정보를 가져오기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public BoardDTO boardDetail(int bno) {
		logger.info("BoardDAOImpl 게시글 번호에 해당하는 게시글 정보를 가져오기() 시작");
		return sqlSession.selectOne(Namespace + ".detail", bno);
	}
	
	//-----------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------
	@Override
	public int boardDelete(int bno) {
		logger.info("BoardDAOImpl 게시글 번호에 해당하는 게시글 삭제하기() 시작");
		return sqlSession.delete(Namespace + ".delete", bno);
	}

}
