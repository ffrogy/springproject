package com.edu.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.edu.member.dto.MemberDTO;
import com.edu.member.service.MemberServiceImpl;

//-----------------------------------------------------------------------------------------------------------
//회원 정보 서비스
//-----------------------------------------------------------------------------------------------------------
@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger 
			= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private	static final String Namespace = "com.edu.member";

	//-----------------------------------------------------------------------------------------------------------
	// 로그인 처리
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public MemberDTO loginByID(MemberDTO memberDTO) throws DataAccessException {

		MemberDTO memDTO = sqlSession.selectOne(Namespace + ".loginByID", memberDTO);
		return memDTO;
		
	} // End - 로그인 처리()

	//-----------------------------------------------------------------------------------------------------------
	// 회원가입 처리하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public int addMember(MemberDTO memberDTO) throws DataAccessException {

		logger.info("MemberDAOImpl 회원가입 처리하기() 시작 : " + memberDTO);
		
		int result = sqlSession.insert(Namespace + ".addMember", memberDTO);
		System.out.println("MemberDAOImpl 회원가입 처리하기() 결과 : " + result);
		return result;
		
	} // End - 회원가입 처리하기

	//-----------------------------------------------------------------------------------------------------------
	// 회원 전체 목록 조회하기
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public List<MemberDTO> selectAllMemberList() throws DataAccessException {

		System.out.println("MemberDAOImpl 회원 전체 목록 조회하기()");
		
		List<MemberDTO> memberLists = null;
		memberLists = sqlSession.selectList(Namespace + ".selectAllMemberList");
		return memberLists;
		
	} // End - 회원 전체 목록 조회하기

}
