package com.edu.di.bmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//-----------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------
public class BmiMain {

	//-----------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		// classpath => src/main/resources를 가리킨다.
		String	conf	= "classpath:applicationContext.xml";
		
		// 스프링 컨테이너가 형성된다.
		ApplicationContext ctx = new GenericXmlApplicationContext(conf);
		
		// 스프링 컨테이너에서 컴포넌트를 가져온다.
		MyInfo	myInfo	= ctx.getBean("myInfo", MyInfo.class);
		
		myInfo.getInfo();
		
	}

} // End - public class BmiMain













