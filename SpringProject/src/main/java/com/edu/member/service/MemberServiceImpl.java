package com.edu.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.edu.member.controller.MemberControllerImpl;
import com.edu.member.dao.MemberDAO;
import com.edu.member.dto.MemberDTO;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberDAO memberDAO;

	//-----------------------------------------------------------------------------------------------------------
	// 로그인 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public MemberDTO login(MemberDTO memberDTO) throws DataAccessException {
		
		logger.info("MemberServiceImpl login() 시작");

		return memberDAO.loginByID(memberDTO);
	} // End - 로그인 처리

	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int addMember(MemberDTO memberDTO) throws DataAccessException {

		logger.info("MemberServiceImpl addMember() 시작 : " + memberDTO);
		return memberDAO.addMember(memberDTO);
	} // End - 회원가입 처리

	//-----------------------------------------------------------------------------------------------------------
	// 회원 전체 목록 조회하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public List<MemberDTO> listMembers() throws DataAccessException {

		logger.info("MemberServiceImpl 회원 전체 목록 조회하기 시작");
		
		List<MemberDTO> memberLists = null;
		memberLists = memberDAO.selectAllMemberList();
		return memberLists;
	}

	
	
	
} // End - public class MemberServiceImpl
