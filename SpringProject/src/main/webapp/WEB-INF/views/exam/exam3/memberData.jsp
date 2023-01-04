<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!-- 상단 메뉴바 -->
<jsp:include page="../../common/topMenu.jsp" flush="false"/>
	
<div class="container">

	<h1>회원 정보 (객체)</h1>
	<h2>MemberVO</h2>
	<h2>MemberVO 아 이 디 : ${member.userId }</h2>
	<h2>MemberVO 비밀번호 : ${member.userPw }</h2>
	
	<hr/>
	
	<h1>회원 정보 (Map)</h1>
	<h2>Map</h2>
	<h2>Map 아 이 디 : ${map.userid }</h2>
	<h2>Map 비밀번호 : ${map.userpw }</h2>

</div>
		
</body>
</html>




