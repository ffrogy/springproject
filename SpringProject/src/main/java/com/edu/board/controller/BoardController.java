package com.edu.board.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		
		logger.info("BoardController 게시글 상세 조회 " + 
				Integer.parseInt((String) request.getParameter("bno")));
	
		int bno		= Integer.parseInt((String)request.getParameter("bno"));
		int flag	= Integer.parseInt((String)request.getParameter("flag"));	
		
		// 게시글 번호에 해당하는 게시글의 정보를 가져온다.
		BoardDTO boardDTO = boardService.boardDetail(bno, flag);
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
	
	//-----------------------------------------------------------------------------------------------------------
	// 게시글 수정화면 불러오기 - 조회수가 증가되면 안된다.
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardUpdateForm", method = RequestMethod.POST)
	public String boardUpdateForm(Model model, HttpServletRequest request) throws Exception {
		
		logger.info("BoardController 게시글 수정화면 불러오기() 시작");
		
		int bno		= Integer.parseInt((String)request.getParameter("bno"));
		int flag	= Integer.parseInt((String)request.getParameter("flag"));	
		
		// 게시글 번호에 해당하는 정보를 수정하기 위한 데이터를 가져온다. - 조회수가 증가되면 안된다.
		// BoardDTO boardDTO = boardDAO.boardDetail(Integer.parseInt((String)request.getParameter("bno")));
		BoardDTO boardDTO = boardService.boardDetail(bno, flag);
		
		model.addAttribute("boardDetail", boardDTO);
		return "/board/boardUpdate";
		
	} // End - 게시글 수정화면 불러오기

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기
	//-----------------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST)
	public String boardUpdate(Model model, BoardDTO boardDTO) throws Exception {
		
		logger.info("BoardController 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기() 시작");
		
		if(boardService.boardUpdate(boardDTO) == 1) {
			return "Y";
		} else {
			return "N";
		}
		
	} // End - 게시글 번호에 해당하는 게시글 내용(제목, 글쓴이, 내용) 수정하기()

	//-----------------------------------------------------------------------------------------------------------
	// 게시글 목록 보여주기 (Paging 1 처리)
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/boardList1", method = RequestMethod.GET)
	public ModelAndView boardList1(Model model, @RequestParam(defaultValue="1") int pageNum, @RequestParam(defaultValue="10") int pageSize) throws Exception {
		
		logger.info("BoardController 게시글 목록 보여주기 (Paging 1 처리) 시작");
		
		// Mapper에서는 파라미터를 2개 이상 받아들이지 않아서, Map에다 넘겨줄 값들이 저장한다. 
		HashMap<String, Integer> pageList = new HashMap<String, Integer>();
		pageList.put("pageNum", 	pageNum);
		pageList.put("pageSize",	pageSize);
		
		for(int key : pageList.values()) {
			System.out.println(key);
		}
				
		// 전체 게시글 수를 구한다.
		int totalCount = boardService.boardListTotalCount1();
		
		// 요청된 페이지에 해당하는 게시글을 가져온다.
		List<BoardDTO> boardList = boardService.boardListPaging1(pageList);
		System.out.println("찾은 목록 ==> " + boardList);
		
		ModelAndView mav = new ModelAndView("/board/boardList1");
		mav.addObject("pageNum", 	pageNum); 	// 현재 페이지 번호
		mav.addObject("boardList", 	boardList); // 현재 페이지 번호에 해당하는 게시글 목록
		mav.addObject("totalCount", totalCount);//전체 게시글 건수
		
		return mav;
		
	} // End - 게시글 목록 보여주기 (Paging 1 처리)
	
	
	
	
	
	
} // End - public class BoardController










