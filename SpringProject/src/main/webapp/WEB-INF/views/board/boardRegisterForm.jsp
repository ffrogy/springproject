<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 등록 화면</title>
	<script src="${contextPath}/resources/js/board.js"></script>
</head>
<body>
<!-- 상단 메뉴 -->
<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>

<div class="container">
	<form class="form-horizontal" name="boardRegisterForm">
		<div class="form-group">
			<div class="col-sm-12">
				<h2 align="center">Board Register</h2>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Title</label>
			<div class="col-sm-2">
				<input type="text" class="form-controll" id="subject" name="subject" maxlength="200" placeholder="Insert Title"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Writer</label>
			<div class="col-sm-3">
				<input type="text" class="form-controll" id="writer" name="writer" maxlength="20" placeholder="Insert Writer"/>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">Content</label>
			<div class="col-sm-8">
				<textarea class="form-controll" id="content" name="content" rows="10" cols="100" placeholder="Insert Text"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 left">
				<button type="reset"	class="btn btn-warning">Reset</button>
				<button type="button"	class="btn btn-primary" onclick="fn_boardRegister();">Enter</button>
			</div>
		</div>
	</form>
</div>

<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
</body>
</html>