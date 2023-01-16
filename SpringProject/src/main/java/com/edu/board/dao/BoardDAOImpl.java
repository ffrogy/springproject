package com.edu.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.edu.board.dto.BoardDTO;
import com.edu.board.service.BoardServiceImpl;

//-----------------------------------------------------------------------------------------------------------
//게시글 Data Access Object
//-----------------------------------------------------------------------------------------------------------
@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Inject	// 의존 관계 주입(Defendency Inject, DI)
	private SqlSession sqlSession;
	
	// Namespace 조심하자 : xml의 namespace와 동일해야 한다.(대소문자 주의할 것)
	private static String Namespace = "com.edu.board";
	
	//-----------------------------------------------------------------------------------------------------------
	// 제일 큰 게시글 번호 가져오기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public Integer getMaxBno() {

		logger.info("BoardDAOImpl 제일 큰 게시글 번호 가져오기() 시작");
		return sqlSession.selectOne(Namespace + ".maxBno");
		
	} // End - 제일 큰 게시글 번호 가져오기()

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 등록 처리하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int boardRegister(BoardDTO boardDTO) {

		logger.info("BoardDAOImpl 게시글 등록 처리하기() 시작");
		return sqlSession.insert(Namespace + ".insertBoard", boardDTO);

	} // End - 게시글 등록 처리하기()

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 목록 보기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public List<BoardDTO> boardList() throws Exception {

		logger.info("BoardDAOImpl 게시글 목록 보기() 시작");

		List<BoardDTO> boardList = sqlSession.selectList(Namespace + ".listAll");
		return boardList;
		
	} // End - 게시글 목록 보기()

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

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int boardDelete(int bno) {
		logger.info("BoardDAOImpl 게시글 번호에 해당하는 게시글 삭제하기() 시작");
		return sqlSession.delete(Namespace + ".delete", bno);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int boardUpdate(BoardDTO boardDTO) {
		logger.info("BoardDAOImpl 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기() 시작");
		return sqlSession.update(Namespace + ".update", boardDTO);
	}

	//-----------------------------------------------------------------------------------------------------------
	// 전체 게시글 수 가져오기 (Paging 1 처리)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int boardListTotalCount1() throws Exception {
		logger.info("BoardDAOImpl 전체 게시글 수 가져오기 (Paging 1 처리) 시작");
		return sqlSession.selectOne(Namespace + ".boardListTotalCount1");
	}

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 목록 보기 1 (Paging 1 처리)
	// 요청된 페이지에 해당하는 게시글 가져오기 (Paging 1 처리)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public List<BoardDTO> boardListPaging1(HashMap<String, Integer> pageList) throws Exception {
		logger.info("BoardDAOImpl 게시글 목록 보기 1 (Paging 1 처리) 시작");
		logger.info("pageList => " + pageList);
		
		// SQL의 Limit에는 사칙연산을 사용할 수가 없으므로,
		// startRow를 계산하여 sqlSession에 넘겨준다.
		int	pageNum		= pageList.get("pageNum");
		int	startRow	= (pageNum - 1) * pageList.get("pageSize");
		
		pageList.put("startRow", startRow);
		return sqlSession.selectList(Namespace + ".boardListPaging1", pageList);
	}
	
	
	
	
	

} // End - public class BoardDAOImpl implements BoardDA
