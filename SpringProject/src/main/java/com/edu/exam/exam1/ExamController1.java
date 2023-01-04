package com.edu.exam.exam1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//-----------------------------------------------------------------------------------------------------------
// @RequestMapping("/exam/exam1") => url주소:포트번호/exam/exam1으로 요청되는 것을 처리한다.
//-----------------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/exam/exam1")
public class ExamController1 {

	//-----------------------------------------------------------------------------------------------------------
	// public void doA() : void 타입 => return 타입이 없는 경우
	// servlet-context.xml : prefix + 리퀘스트매핑 + suffix
	// 리턴 => /WEB-INF/views/exam/exam1/doA.jsp
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping("/doA")
	public void doAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa() {
		System.out.println("doA가 실행되었습니다.");
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 메서드의 내용을 실행한 후 리턴 => /WEB-INF/views/exam/exam1/doB.jsp
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping("/doB")
	public void doB() {
		System.out.println("doB 요청을 처리합니다.");
	}
	
	
} // End - public class ExamController1










