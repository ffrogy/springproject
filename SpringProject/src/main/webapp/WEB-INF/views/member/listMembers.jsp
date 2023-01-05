<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 전체 목록</title>
</head>
<body>
<%
if(session.getAttribute("isLogOn") == null || session.getAttribute("isLogOn").equals("")) {
	// 로그인 하지 않으면 로그인화면으로 돌려보낸다.
	response.sendRedirect("/member/loginForm.do");
}
%>

<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

<div class="container">
	<h1 align="center">회원 전체 목록</h1>
	<a href="${contextPath}/member/logout.do" class="btn btn-danger"><span class="glyphicon glyphicon-log-out">로그아웃</span></a>

	<table class="table table-bordered table-striped table-hover" style="width:1200px; margin:auto;">
		<tr class="info">
			<td align="center" width="80"><b>아이디</b></td>
			<td align="center" width="80"><b>비밀번호</b></td>
			<td align="center" width="80"><b>이  름</b></td>
			<td align="center" width="300"><b>이메일</b></td>
			<td align="center" width="120"><b>가입일자</b></td>
			<td align="center" width="60"><b>수정</b></td>
			<td align="center" width="60"><b>삭제</b></td>
		</tr>
	<c:forEach var="member" items="${memberLists}">
		<tr>
			<td align="center">${member.id}</td>
			<td align="center">${member.pwd}</td>
			<td align="center">${member.name}</td>
			<td align="center">${member.email}</td>
			<td align="center">${member.joinDate}</td>
			<td align="center"><a class="btn btn-sm btn-primary" href="${contextPath}/member/updateMemberForm.do?id=${member.id}">수정</a></td>
			<td align="center"><a class="btn btn-sm btn-danger"  href="${contextPath}/member/removeMember.do?id=${member.id}">삭제</a></td>
		</tr>
	</c:forEach>
		
	</table>
</div>

<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>

</body>
</html>








