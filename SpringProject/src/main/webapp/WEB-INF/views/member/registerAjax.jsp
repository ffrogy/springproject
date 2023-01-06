<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pagecontext.request.contextPath}"/>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 (Ajax)</title>
</head>
<body>

<!-- 상단 메뉴바 -->
<jsp:include page="../common/topMenu.jsp" flush="false"/>

<h1 align="center">회원가입 (Ajax)</h1>

<div class=container>
	<form class="form-horizontal" method="post" action="${contextPath}/member/register">
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<h2 align="center">회원가입 (실시간 아이디 중복검사)</h2>
			</div>
		</div>
		<hr/>
		<div class="form-group">
			<label for="id" class="col-sm-3 control-label">아이디</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="id" name="id" maxlength="20" placeholder="아이디"/>
			</div>
			<div class="col-sm-2">
				<button class="btn btn-warning idCheck" type="button" id="idCheck" onClick="fn_idCheck();" value="N">아이디 중복검사</button>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-9">
				<input type="text" class="form-control msg" name="msg" placeholder="알림" id="msg"/>
			</div>
			<div class="col-sm-offset-3 col-sm-9">
				<div id="msg2"></div>
			</div>
		</div>
		<div class="form-group">
			<label for="pwd" class="col-sm-3 control-label">비밀번호</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="pwd" name="pwd" maxlength="20" placeholder="비밀번호 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="repwd" class="col-sm-3 control-label">비밀번호 확인</label>
			<div class="col-sm-2">
				<input type="password" class="form-control" id="repwd" name="repwd" maxlength="20" placeholder="비밀번호 확인"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">이		름</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="name" name="name" maxlength="20" placeholder="이름 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이 메 일</label>
			<div class="col-sm-2">
				<input type="email" class="form-control" id="email" name="email" maxlength="100" placeholder="이메일 입력"/>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">회원가입 동의</label>
			<div class="col-sm-2">
				<label class="radio-inline">
					<input type="radio" id="register_Yn" name="register_Yn" value="Y" checked> 동의&nbsp;&nbsp;
				</label>
				<label class="radio-inline">
					<input type="radio" id="register_Nn" name="register_Nn" value="N"> 동의 안 함
				</label>
			</div>
		</div>
		<div class="alert alert-info fade in col-sm-offset-1 col-sm-10">
         	<strong>[도서쇼핑몰의 개인 정보 수집 및 이용 안내]</strong>
	         <h5>
	         개인 정보 제3자 제공 동의
	         <br>① 개인정보를 제공받는 자: BookStore
	         <br>② 개인정보를 제공받는 자의 개인 정보 이용 목적 : 영업관리, 
	         설문조사 및 프로모션, 이벤트 경품 제공, eDM 발송, 행사 관련 마케팅
	         <br>③ 제공하는 개인정보항목 : 이름, 이메일주소, 회사명, 직무/직책, 연락처, 휴대전화
	         <br>④ 개인정보를 제공받는 자의 개인 정보 보유 및 이용 기간 :
	         개인정보 취급 목적을 달성하여 더 이상 개인정보가 불 필요하게 된 경우이거나
	         5년이 지나면 지체 없이 해당 정보를 파기할 것입니다.
	         <br>귀하는 위와 같은 BookStore의 개인정보 수집 및 이용정책에 동의하지 
	         않을 수 있으나, BookStore으로부터 솔루션, 최신 IT정보, 행사초청안내 등의 
	         유용한 정보를 제공받지 못 할 수 있습니다.
	         <br> 개인 정보 보호에 대한 자세한 내용은 http://www.BookStore.com 을 참조바랍니다.
	         </h5>
		<div class="checkbox" align="center">
			<label>
				<input type="checkbox" id="is_subscribed" name="is_subscribed" value="o"/>
			</label> BookStore의 개인정보 수집 및 이용에 동의합니다.
		</div>
	</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-sm-4">
				<button type="reset"  class="btn btn-warning">다시 입력</button>
				<button type="button" class="btn btn-danger cancel">가입 취소</button>
				<button type="submit" class="btn btn-success" id="submit">회원 가입</button>
				<button type="submit" class="btn btn-primary signOkBtn" disabled="disabled">회원 가입</button>
			</div>
		</div>
	</form>
</div>

<!-- 하단 메뉴 -->
<jsp:include page="../common/footer.jsp" flush="false"/>


<script>
// 아이디 중복 검사 버튼을 눌렀을 경우
function fn_idCheck(){
	
	$.ajax({
		url: 		"/member/idCheck",
		type:		"post",
		dataType: 	"json",
		data:		{"id":$("#id").val()},
		success:	function(data){
						if(data == 1) { // 입력한 아이디가 이미 존재하는 경우
							alert("이미 사용 중인 아이디입니다.");
						} else if(data == 0) { // 입력한 아이디가 존재하지 않는 경우
							// 버튼 id = "idCheck"의 속성인 value의 값을 "Y"로 변경한다.
							$("#idCheck").attr("value","Y");
							alert("사용 가능한 아이디입니다.");
						}
					}
	});
}
</script>

<script>
$(document).ready(function(){
	// 취소 버튼이 눌렸을 경우 로그인 화면으로 이동한다.
	$(".cancel").on("click", function(){
		alert("가입이 취소되었습니다.")
		location.href="/member/loginForm.do";
	});
	
	// 회원가입 버튼을 눌렀을 경우 (id="submit")
	$("#submit").on("click", function(){
		
		if($("#id").val() == "") {
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}

		if($("#id").val().length < 4) {
			alert("아이디는 최소 4자리 이상을 입력하셔야 합니다.");
			$("#id").focus();
			return false;
		}
		
		if($("#name").val().length == "") {
			alert("이름을 입력해주세요.");
			$("#name").focus();
			return false;
		}
		
		if($("#pwd").val() == "") {
			alert("비밀번호를 입력해주세요.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd").val().length < 4) {
			alert("비밀번호는 최소 4자리 이상을 입력하셔야 합니다.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#email").val().length == "") {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		
		alert("회원가입이 완료되었습니다.")
		location.href="/member/loginForm.do"
	});
});
</script>

</body>
</html>