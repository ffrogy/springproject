package com.edu.board.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.board.dto.BoardDTO;
import com.edu.board.service.BoardService;

//-----------------------------------------------------------------------------------------
// 게시글 관리 컨트롤러
//-----------------------------------------------------------------------------------------
@Controller 	// Bean의 대상으로 인식시키기 위해서 servlet-context.xml에 등록한다.
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService boardService;

	//-----------------------------------------------------------------------------------------
	// 게시글 화면 불러오기 
	//-----------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardRegisterForm", method = RequestMethod.GET)
	public String boardRegisterForm() throws Exception {
		
		logger.info("BoardController 게시글 화면 불러오기() 시작");
		return "/board/boardRegisterForm";
		
	} // End - 게시글 화면 불러오기 
	
	//-----------------------------------------------------------------------------------------
	// 게시글 등록하기
	//-----------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/boardRegister", method = RequestMethod.POST)
	// request 객체를 통해 데이터를 가져온다.
	// 메서드의 파라미터에 객체를 전달하면 자동으로 데이터가 set 된 상태로 전달ㄹ하게 된다.
	public String boardRegister(BoardDTO boardDTO) throws Exception {
		
		logger.info("BoardController 게시글 등록하기() 시작");
		logger.info("BoardDTO 값 : " + boardDTO);
		
		if(boardService.boardRegister(boardDTO) == 1) {		// 게시글 등록 완료
			return "Y";
		} else {	// 게시글 등록 실패
			return "N";
		}
		
	} // End - 게시글 화면 불러오기 	

	//-----------------------------------------------------------------------------------------
	// 게시글 목록 보기
	//-----------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void boardList(Locale locale, Model model) throws Exception {
		
		logger.info("BoardController 게시글 목록 보기() 시작");
		
		List<BoardDTO> boardList = boardService.boardList();
		logger.info("BoardController 게시글 목록 ==> " + boardList);
		
		model.addAttribute("boardList", boardList);
		
	} // End - 게시글 화면 불러오기 
	
	
	
	
	
} // End - public class BoardController 
