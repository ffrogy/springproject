package com.edu.exam.exam2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//-----------------------------------------------------------------------------------------------------------
// public class ExamController2
//-----------------------------------------------------------------------------------------------------------
@Controller
@RequestMapping("/exam/exam2")
public class ExamController2 {

	//-----------------------------------------------------------------------------------------------------------
	// return 타입이 String인 경우
	// @ModelAttribute("msg") 는 주소창에서 msg라는 파라미터의 값을 가져온다.
	// http://localhost:8099/exam/exam2/doC?msg=hello
	// 이렇게 주소창에 파라미터가 적혀있는 경우에 자동적으로 mgs의 값인 hello를 가져오게 된다.
	// ==> request.getParameter("msg")를 사용하지 않아도 된다.
	//-----------------------------------------------------------------------------------------------------------
	@RequestMapping("/doC")
	public String doC(@ModelAttribute("msg") String msg) {
		
		System.out.println("doC가 실행되었습니다. msg => " + msg);
		
		// return에 문자열이 사용될 경우에는 리턴되는 문자열.jsp파일을 찾아서 실행하게 된다.
		// /WEB-INF/views + "exam/exam2/doC" + .jsp
		// void타입과는 다르게 
		// return 타입이 String인 경우에는 리턴하는 문자열이 View의 이름이 된다.
		return "exam/exam2/doC";
		
	} // End - public String doC(@ModelAttribute("msg") String msg)

	//-----------------------------------------------------------------------------------------------------------
	// 구구단 입력화면 보내주기
	// return 타입이 void이면 value의 값이 page이름이 된다.
	//-----------------------------------------------------------------------------------------------------------
	// @RequestMapping("gugudanForm.do")
	@RequestMapping(value = "gugudanForm.do", method = RequestMethod.GET)
	public void goguForm() {
		
		System.out.println("구구단 입력화면을 호출하였습니다.");
		
	} // End - @RequestMapping(value = "gugudanForm.do", method = RequestMethod.GET)

	//-----------------------------------------------------------------------------------------------------------
	// 요청된 단에 대한 구구단 결과 보여주기
	//-----------------------------------------------------------------------------------------------------------
	// @RequestMapping("gugu.do")	// GET, POSt 방식에 상관없다.
	@RequestMapping(value="gugu.do", method=RequestMethod.GET)
	// public String gugu(int dan, Model model) {
	// public String gugu(@RequestParam(defaultValue="3") int dan, Model model) {	// 단의 값이 없을 때 기본 단을 설정한다.
	// public String gugu(@RequestParam(defaultValue="3") int dan, String msg, Model model) {
	public String gugu(@RequestParam(defaultValue="3") int dan, Model model, String msg) {
		
		System.out.println("구구단 계산결과를 보여주세요.");
		
		//-----------------------------------------------------------------------------------------------------------
		// 스프링에서는 get방식에서 아래와 같은 방식으로 사용하지 않는다.
		// int	dan	= Integer.parseInt(request.getParameter("dan"));
		//-----------------------------------------------------------------------------------------------------------
		// <a href="http://localhost:8090/exam/exam2/gugu.do?dan=3">구구단</a>
		// public String gugu(HttpServletRequest request, Model model)을 사용하지 않고,
		// public String gugu(int dan, Model model)을 사용한다.
		
		// 값을 넘겨주는 페이지에서 값은 String으로 넘어오지만,
		// Spring에서는 정수형으로 잘 받는다. 이러한 점이 스프링의 장점이다.
		
		// public String gugu(@RequestParam(defaultValue="3") int dan, String msg, Model model) {
		// public String gugu(@RequestParam(defaultValue="3") int dan, Model model, String msg) {
		// 넘어오는 매개변수명만 맞으면 매개변수의 위치와는 상관없이 값을 잘 받아들인다.
		// <a href="http://localhost:8090/exam/exam2/gugu.do?dan=3&msg=안녕">구구단</a>
		// <a href="http://localhost:8090/exam/exam2/gugu.do?msg=안녕&dan=3">구구단</a>

		// public String gugu(int dan, String msg, Model model) {
		// public String gugu(@RequestParam(defaultValue="3") int dan, String msg, Model model) {
		// 실제로는 @RequestParam이 숨어 있기 때문에 기술하지 않아도 된다.
			
		System.out.println("계산할 구구단은 " + dan + "단입니다.");
		
		System.out.println("전송받은 문자열 => " + msg);
		
		String	result = "";
		for(int i = 1; i <= 9; i++) {
			result += "<h3>" + dan + " x " + i + " = " + dan * i + "</h3>";
		}
		
		model.addAttribute("result", result);
		return "exam/exam2/gugudan";
		
	} // End - 구구단 계산결과()
	
	
	
} // End - public class ExamController2














