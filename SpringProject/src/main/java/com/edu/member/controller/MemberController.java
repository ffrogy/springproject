package com.edu.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.member.dto.MemberDTO;

//-----------------------------------------------------------------------------------------------------------
// public interface MemberController
//-----------------------------------------------------------------------------------------------------------
public interface MemberController {
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그인 폼
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그인 처리
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView login(@ModelAttribute("member") MemberDTO member,
								RedirectAttributes rAttr, 
								HttpServletRequest request, HttpServletResponse response)
			throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 로그아웃 처리
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 화면 불러오기
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView addMember(@ModelAttribute("member") MemberDTO memberDTO,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception;
	
	//-----------------------------------------------------------------------------------------------------------
	// 회원 전체 목록 조회하기
	//-----------------------------------------------------------------------------------------------------------
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	
	
	

	
	
	
	
	
	
	
	
} // End - public interface MemberController









