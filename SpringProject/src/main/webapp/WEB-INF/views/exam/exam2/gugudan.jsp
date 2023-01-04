<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구구단</title>
</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="../../common/topMenu.jsp" flush="false"/>
	
<div class="container">
	<h1 align="center">구구단 계산결과</h1>
	<h3>${result}</h3>
</div>

</body>
</html>


