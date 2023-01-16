<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>
<%
if(session.getAttribute("isLogOn") == null || session.getAttribute("member") == null) {
	out.println("<script>");
	out.println("alert('로그인 후 서비스 이용이 가능합니다.')");
	out.println("location.href='/main.do'");
	out.println("</script>");
} else { 
	String id = (String)session.getAttribute("id");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<!-- 상단 메뉴 -->
<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>

	<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">BOARD</h2>
			</div>
		</div>
		<p align="center">
			<button type="button" class="btn btn-primary" onclick="location.href='/board/boardRegisterForm'">게시글 쓰기</button>
		<table class="table table-bordered table-striped table-hover">
			<thead>
				<tr class="info">
					<th class="col-sm-1 text-center"><b>No</b></th>
					<th class="col-sm-4 text-center"><b>Subject</b></th>
					<th class="col-sm-4 text-center"><b>Content</b></th>
					<th class="col-sm-1 text-center"><b>Writer</b></th>
					<th class="col-sm-2 text-center"><b>Date</b></th>
					<th class="col-sm-1 text-center"><b>Count</b></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boardList}" var="list">
					<tr>
						<td align="center">${list.bno}</td>
						<td align="center"><a href="${contextPath}/board/boardDetail?bno=${list.bno}&flag=0">${list.subject}</a></td>
						<td align="center">${list.content}</td>
						<td align="center">${list.writer}</td>
						<td align="center"><fmt:formatDate value="${list.reg_date}" pattern="yyyy-MM-dd a hh:mm:ss"/></td>
						<td align="right">${list.readCount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</div>

<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
</body>
</html>