<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<%
if(session.getAttribute("isLogOn") == null || session.getAttribute("member") == null) {
	out.println("로그인 후 서비스 이용이 가능합니다.");
	response.sendRedirect("/main.do");
} else { 
	String id = (String)session.getAttribute("id");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 상단 메뉴 -->
<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>

	<div class="container">
	<h1 align="center">BOARD</h1>
	<a href="${contextPath}/member/logout.do" class="btn btn-danger"><span class="glyphicon glyphicon-log-out">로그아웃</span></a>
	<br/>
	<hr/>

	<table class="table table-bordered table-striped table-hover" style="width:1200px; margin:auto;">
		<tr class="info">
			<td align="center" width="30"><b>No</b></td>
			<td align="center" width="100"><b>Subject</b></td>
			<td align="center" width="130"><b>Content</b></td>
			<td align="center" width="30"><b>Writer</b></td>
			<td align="center" width="30"><b>Date</b></td>
			<td align="center" width="30"><b>Count</b></td>
		</tr>
	<c:forEach var="board" items="${boardLists}">
		<tr>
			<td align="center">${board.bno}</td>
			<td align="center">${board.subject}</td>
			<td align="center">${board.content}</td>
			<td align="center">${board.writer}</td>
			<td align="center">${board.reg_date}</td>
			<td align="center">${board.readCount}</td>

		</tr>
	</c:forEach>
		
	</table>
</div>

<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
</body>
</html>