package com.edu.member.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

//-----------------------------------------------------------------------------------------------------------
//	회원 정보
//	@Component 어노테이션을 이용하면 Bean Configuration 파일에 Bean으로 따로 
//				등록하지 않아도 사용할 수가 있다.
//	@Component 어노테이션은 기본적으로 타입기반의 자동주입 어노테이션이다.
//-----------------------------------------------------------------------------------------------------------
@Component("memberDTO")
public class MemberDTO {
	
	private	String	id;			// 사용자 아이디
	private	String	pwd;		// 비밀번호
	private	String	name;		// 사용자 이름
	private	String	email;		// 이메일
	private	Date	joinDate;	// 가입일자
	
	public	MemberDTO()	{}		// 기본생성자
	public	MemberDTO(String id, String pwd, String name, String email) {
		this.id		= id;
		this.pwd	= pwd;
		this.name	= name;
		this.email	= email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", joinDate=" + joinDate
				+ "]";
	}
	
	
} // End - public class MemberDTO






