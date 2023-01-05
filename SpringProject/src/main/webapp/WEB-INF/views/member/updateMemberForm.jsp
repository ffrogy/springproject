<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 정보 수정</title>
</head>
<body>

<!-- 상단 메뉴 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

<div class="container">
	<form class="form-horizontal" method="post" name="memModifyForm" action="${contextPath}/member/modifyMember.do">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-5">
				<h2 align="center">회원 정보 수정</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="id" class="col-sm-3 control-label">아이디</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="id" name="id" maxlength="20" value="${member.id}" readonly/>
			</div>
		</div>
		<div class="form-group">
			<label for="pwd" class="col-sm-3 control-label">비밀번호</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="pwd" name="pwd" maxlength="20" value="${member.pwd}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="repwd" class="col-sm-3 control-label">비밀번호 확인</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="repwd" name="repwd" maxlength="20"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">이  름</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="name" name="name" maxlength="20" value="${member.name}"/>
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-7">
				<input type="email" class="form-control" id="email" name="email" maxlength="100" value="${member.email}"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-4">
				<button type="reset"  class="btn btn-warning">다시 입력</button>
				<button type="submit" class="btn btn-primary">회원 정보 수정</button>
			</div>
		</div>
	</form>
</div>

<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>

</body>
</html>














