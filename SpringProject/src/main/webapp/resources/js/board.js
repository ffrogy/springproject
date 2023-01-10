/*
 * 게시글 관련 함수
 */
 
//-----------------------------------------------------------------------------------------
// 게시글 관리 컨트롤러
//-----------------------------------------------------------------------------------------
function fn_boardRegister() {
	
	// alert("게시글 등록 버튼을 눌렀습니다.");
	
	// 게시글 등록 화면에서 입력한 값을 가져온다.
	let subject = $("#subject").val();
	let writer	= $("#writer").val();
	let content = $("#content").val();
	
	alert(subject + ":" + writer + ":" + content);
	
	// 제목 항목에 값이 없으면 입력하도록 한다.
	if($("#subject").val() == "") {
		alert("제목은 필수 입력 항목입니다.");
		$("#subject").focus();
		return false;
	}
	
	// 작성자 항목에 값이 없으면 입력하도록 한다.
	if($("#writer").val() == "") {
		alert("작성자는 필수 입력 항목입니다.");
		$("#writer").focus();
		return false;
	}
	
	$.ajax({
		type:		"POST",
		url:		"/board/boardRegister",
		data:		{subject:subject, writer:writer, content:content},
		success:	function(data)	{
			if(data == "Y") {
				alert("게시글을 등록하였습니다.");
				// 게시글 등록이 완료되면 게시글 목록 화면으로 이동한다.
				location.href = "/board/boardList";
			}
		},
		error:		function(data)	{
			alert("게시글을 등록하는데 실패하였습니다.");
		}
	});
} // End - function fn_boardRegister()

//-----------------------------------------------------------------------------------------
// 게시글 관리 컨트롤러
//-----------------------------------------------------------------------------------------
function fn_boardDelete(bno) {

// 삭제를 진행하기 전 먼저 삭제 여부를 확인한다.
	if(!confirm("게시글을 삭제하시겠습니까?\n삭제하려면 [확인]버튼을 눌러주세요.")) {
		alert("게시글 삭제를 취소하였습니다.");
	} else { // [확인] 버튼을 눌렀을 경우
		$.ajax({
			type : 			"POST",
			url: 			"/board/boardDelete",
			data:			{bno : bno},
			success: 		function(data) {
				if(data == "Y") {
					alert("게시글의 삭제가 완료되었습니다.");
					location.href = "board/boardList";
				}
			},
			error: 			function(data){
				alert("게시글 삭제에 실패하였습니다.(오류 발생)")
			},
			done: 			function(data){
				alert("요청 성공");
			},
			fail: 			function(data){
				alert("요청 실패");
			},
			always: 		function(data){
				alert("요청 완료");
			}
		});
	}
} // End - function fn_boardDelete(bno)

//-----------------------------------------------------------------------------------------
// 게시글 수정 화면 불러오기
// form에 action과 method가 없기 때문에 여기에서 만든다.
// <form action="/board/boardUpdateForm", method="POST">
// 전송할 bno를 담아놓은 것이 없으므로 input을 만들어서 bno를 서버에 전송한다.
// form.append($('만들태그', {태그에 사용할 속성 : 값, 속성 : 값, ...})
//-----------------------------------------------------------------------------------------
function fn_boardUpdateForm(bno) {
	
	var f = $("#frm");
	f.attr("action", "/board/boardUpdateForm");
	f.attr("method", "POST");
	// <input type="hidden" name="bno" vlaue="${boardDetail.bno}"/>
	f.append($('<input/>', {type: 'hidden', name: 'bno', value: bno}));
	f.appendTo('body');
	f.submit();
}

