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
	
	<h1>doC.jsp 실행화면</h1>
	<h1>ModelAttribute에 담겨져오는 메시지 받기</h1>
	<hr/>
	<h1>메시지 : ${msg }</h1>
</body>
</html>