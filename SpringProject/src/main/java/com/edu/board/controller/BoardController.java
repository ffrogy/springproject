package com.edu.board.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
		
	} // End - 게시글 목록 보기
	
	//-----------------------------------------------------------------------------------------
	// 게시글 상세 조회 GET
	//-----------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 게시글 상세 조회 GET() ==> " + Integer.parseInt((String) request.getParameter("bno")));
		
		// 게시물 번호에 해당하는 게시글의 정보를 가져온다.
		BoardDTO boardDTO = boardService.boardDetail(Integer.parseInt((String)request.getParameter("bno")));
		model.addAttribute("boardDetail", boardDTO);
		
		return "/board/boardDetail";
		
	} // End - 게시글 상세 조회 GET
	
	//-----------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 게시글 번호에 해당하는 게시글 삭제하기 " + 
					request.getParameter("bno"));
		
		if(boardService.boardDelete(Integer.parseInt((String)request.getParameter("bno")))==1) {
			return "Y";
		} else {
			return "N";
		}
	} // End - 게시글 번호에 해당하는 게시글 삭제하기
	
	//-----------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 삭제하기
	//-----------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardUpdateForm", method = RequestMethod.POST)
	public String boardUpdateForm(Model model, HttpServletRequest request) throws Exception {
		
		BoardDTO boardDTO = boardService.boardDetail(Integer.parseInt((String)request.getParameter("bno")));
		
		model.addAttribute("boardDetail", boardDTO);
		return "/board/boardUpdate";
	}
	
	
} // End - public class BoardController 
