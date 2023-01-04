package com.edu.exam.exam3.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.exam.exam3.vo.MemberVO;

//-----------------------------------------------------------------------------------------------------------
// public class ExamController3
//-----------------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/exam/exam3")
public class ExamController3 {
	
	//-----------------------------------------------------------------------------------------------------------
	// public String doD(Model model)
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping("/doD")
	public String doD(Model model) {
		
		System.out.println("doD가 시작되었습니다.");
		
		MemberVO	memberVO	= new MemberVO();
		memberVO.setUserId("userID-001");
		memberVO.setUserPw("userPW-001");
		
		model.addAttribute("member", memberVO);
		
		return "/exam/exam3/memberData";
		
	} // End - public String doD(Model model)
	
	//-----------------------------------------------------------------------------------------------------------
	// public String doE(Model model)
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping("/doE")
	public String doE(Model model) {
		
		System.out.println("doE가 실행되었습니다.");
		
		Map<String, String> map	= new HashMap<String, String>();
		map.put("userid", "mapID-002");
		map.put("userpw", "mapPW-002");
		
		model.addAttribute("map", map);
		
		return "/exam/exam3/memberData";
		
	} // End - public String doE(Model model)

	
	
	
	
} // End - public class ExamController3







