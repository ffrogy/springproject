<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pagecontext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 화면</title>
</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

<div class="container">
	<form class="form-horizontal" method="post" name="memInsForm" action="${contextPath}/member/addMember.do">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<h2 align="center">회원 가입</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="id" class="col-sm-3 control-label">아이디</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="id" name="id" maxlength="20" placeholder="아이디 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="pwd" class="col-sm-3 control-label">비밀번호</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="pwd" name="pwd" maxlength="20" placeholder="비밀번호 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="repwd" class="col-sm-3 control-label">비밀번호 확인</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="repwd" name="repwd" maxlength="20" placeholder="비밀번호 확인"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">이		름</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="name" name="name" maxlength="20" placeholder="이름 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이 메 일</label>
			<div class="col-sm-2">
				<input type="email" class="form-control" id="email" name="email" maxlength="100" placeholder="이메일 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">회원가입 동의</label>
			<div class="col-sm-2">
				<label class="radio-inline">
					<input type="radio" id="register_Yn" name="register_Yn" value="Y" checked> 동의&nbsp;&nbsp;
				</label>
				<label class="radio-inline">
					<input type="radio" id="register_Nn" name="register_Nn" value="N"> 동의 안 함
				</label>
			</div>
		</div>
		<div class="alert alert-info fade in col-sm-offset-1 col-sm-10">
         	<strong>[도서쇼핑몰의 개인 정보 수집 및 이용 안내]</strong>
	         <h5>
	         개인 정보 제3자 제공 동의
	         <br>① 개인정보를 제공받는 자: BookStore
	         <br>② 개인정보를 제공받는 자의 개인 정보 이용 목적 : 영업관리, 
	         설문조사 및 프로모션, 이벤트 경품 제공, eDM 발송, 행사 관련 마케팅
	         <br>③ 제공하는 개인정보항목 : 이름, 이메일주소, 회사명, 직무/직책, 연락처, 휴대전화
	         <br>④ 개인정보를 제공받는 자의 개인 정보 보유 및 이용 기간 :
	         개인정보 취급 목적을 달성하여 더 이상 개인정보가 불 필요하게 된 경우이거나
	         5년이 지나면 지체 없이 해당 정보를 파기할 것입니다.
	         <br>귀하는 위와 같은 BookStore의 개인정보 수집 및 이용정책에 동의하지 
	         않을 수 있으나, BookStore으로부터 솔루션, 최신 IT정보, 행사초청안내 등의 
	         유용한 정보를 제공받지 못 할 수 있습니다.
	         <br> 개인 정보 보호에 대한 자세한 내용은 http://www.BookStore.com 을 참조바랍니다.
	         </h5>
		<div class="checkbox" align="center">
			<label>
				<input type="checkbox" id="is_subscribed" name="is_subscribed" value="o"/>
			</label> BookStore의 개인정보 수집 및 이용에 동의합니다.
		</div>
	</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-4">
				<button type="reset"  class="btn btn-warning">다시 입력</button>
				<button type="submit" class="btn btn-primary">회원 가입</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>