package com.edu.di.car.mycar4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//-----------------------------------------------------------------------------------------------------------
//	스프링을 통한 의존성 주입 - XML 파일을 사용한다.
// 
//	스프링을 도입해서 얻게 되는 이점은?
//	자동차의 타이어 브랜드를 변경할 때 재컴파일/재배포를 하지 않아도
//	XML 파일만 수정하면 프로그램의 실행 결과를 바꿀 수 있다는 것이다.
//-----------------------------------------------------------------------------------------------------------
public class Driver {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		// ApplicationContext	ctx
		// = new GenericXmlApplicationContext("com/edu/di/car/mycar4/appCtx.xml");
		
		ApplicationContext	ctx
		= new FileSystemXmlApplicationContext("src/main/java/com/edu/di/car/mycar4/appCtx.xml");
		
		Car		car		= ctx.getBean("car",	Car.class);
		// Tire	tireA	= ctx.getBean("tireA",	Tire.class);
		// Tire	tireE	= ctx.getBean("tireE",	Tire.class);
		// Tire	tireK	= ctx.getBean("tireK",	Tire.class);
		
		Tire	tire	= ctx.getBean("tire",	Tire.class);
		
		car.setTire(tire);
		System.out.println(car.getTireBrand());
		
	} // End - public static void main(String[] args)

} // End - public class Driver







