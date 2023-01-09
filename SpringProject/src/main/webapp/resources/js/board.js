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
}