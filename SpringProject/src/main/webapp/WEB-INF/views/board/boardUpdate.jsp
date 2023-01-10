<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"	uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>boardUpdate</title>
	<script src="${contextPath}/resources/js/board.js"></script>
</head>
<body>
<!-- 상단 메뉴 -->
<jsp:include page="../common/topMenu.jsp" flush="false"></jsp:include>

<div class="container">
	<form class="form-horizontal" id="frm">
		<div class="form-group">
			<div>
				<h2 align="center">Board Update</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="subject" class="col-sm-2 control-label">Subject</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="subject" name="subject" maxlength="200" value="${boardDetail.subject}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="reg_date" class="col-sm-2 control-label">Date</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="reg_date" name="reg_date" value="<fmt:formatDate value='${boardDetail.reg_date}' pattern='yyyy-MM-dd a hh:mm:ss'/>" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="readCount" class="col-sm-2 control-label">Count</label>
				<div class="col-sm-3">
				<input type="text" class="form-control" id="readCount" name="readCount" maxlength="4" value="${boardDetail.readCount}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="writer" class="col-sm-2 control-label">Writer</label>
				<div class="col-sm-4">
				<input type="text" class="form-control" id="writer" name="writer" maxlength="20" value="${boardDetail.writer}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="content" class="col-sm-2 control-label">Content</label>
				<div class="col-sm-10">
				<textarea rows="10" cols="100" class="form-control" id="content" name="content">${boardDetail.content}</textarea>
			</div>
		</div>
		<div class="form-group">
			<p align="center">
				<button type="reset" class="btn btn-danger">
					<span class="glyphicon glyphicon-erase"> Reset</span>
				</button>
				<button type="button" class="btn btn-primary" onclick="location.href='${contextPath}/board/boardList'">
					<span class="glyphicon glyphicon-list-alt"> List</span>
				</button>
				<button type="button" class="btn btn-warning" onclick="fn_boardUpdate();">
					<span class="glyphicon glyphicon-pencil"> Edit</span>
				</button>				
		</div>
	</form>
</div>
	
<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"></jsp:include>
</body>
</html>