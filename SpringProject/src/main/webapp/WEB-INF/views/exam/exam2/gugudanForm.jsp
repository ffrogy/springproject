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
	<form class="form-horizontal" method="get" action="${contextPath}/exam/exam2/gugu.do">
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-3">
				<h2 align="left">구구단</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-offset-2 col-sm-2 control-label">단 입력</label>
			<div class="col-sm-2">
				<input type="text" 	 class="form-control" id="dan" name="dan" maxlength="2" placeholder="단입력"/>
				<input type="hidden" class="form-control" name="msg" value="안녕하세요?"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-4">
				<button type="reset"  class="btn btn-warning">다시입력</button>
				<button type="submit" class="btn btn-primary">구구단 계산</button>
			</div>
		</div>
	</form>
</div>


</body>
</html















>