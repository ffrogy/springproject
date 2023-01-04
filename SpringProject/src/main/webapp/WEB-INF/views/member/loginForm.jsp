<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="result"		 value="${param.result}"/>
<%	request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 화면</title>

<!-- 로그인 여부 체크 -->
<c:choose>
	<c:when test="${result == 'loginIdEmpty'}">
		<script>
		window.onload = function() {
			alert("\n아이디를 입력하셔야 합니다.");
		}
		</script>
	</c:when>
	<c:when test="${result == 'loginFailed'}">
		<script>
		window.onload = function() {
			alert("\n아이디를 잘못입력하셨습니다.\n\n다시 로그인을 해주십시오.");
		}
		</script>
	</c:when>
	<c:when test="${result == 'PasswordFailed'}">
		<script>
		window.onload = function() {
			alert("\n비밀번호를 잘못입력하셨습니다.\n\n다시 로그인을 해주십시오.");
		}
		</script>
	</c:when>
</c:choose>

</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

<div class="container">
	<form class="form-horizontal" method="post"  action="${contextPath}/member/login.do">
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-3">
				<h2 align="center">로그인</h2>
			</div>
		</div>
		<div class="form-group">
			<label for="id" class="col-sm-offset-3 col-sm-2 control-label">아이디</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="id" name="id" maxlength="20" placeholder="아이디"/>
			</div>
		</div>
		<div class="form-group">
			<label for="id" class="col-sm-offset-3 col-sm-2 control-label">비밀번호</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" id="pwd" name="pwd" maxlength="20" placeholder="비밀번호"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-3">
				<button type="reset"  class="btn btn-warning">다시입력</button>
				<button type="submit" class="btn btn-primary" id="submit">로그인</button>
			</div>
		</div>
	</form>
</div>

<%	// form의 action이 실행되기 이전에 아이디, 비밀번호에 값이 입력되었는지,
	// 자리수가 맞는지 검사한다.
%>
<script>
$(document).ready(function() {
	// 로그인 버튼이 눌렸을 경우
	$("#submit").on("click", function() {
		// alert("로그인 버튼을 눌렀습니다.");
		
		if($("#id").val() == "") {
			alert("아이디를 입력하셔야 합니다.");
			$("#id").focus();
			return false;
		}
		if($("#id").val().length < 4) {
			alert("아이디는 최소 4자리 이상을 입력하셔야 합니다.");
			$("#id").focus();
			return false;
		}
		
		if($("#pwd").val() == "") {
			alert("비밀번호를 입력하셔야 합니다.");
			$("#pwd").focus();
			return false;
		}
		if($("#pwd").val().length < 4) {
			alert("비밀번호는 최소 4자리 이상을 입력하셔야 합니다.");
			$("#pwd").focus();
			return false;
		}
		
	});
	
	
});
</script>

</body>
</html>










