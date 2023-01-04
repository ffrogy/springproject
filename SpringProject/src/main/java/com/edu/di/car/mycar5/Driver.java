package com.edu.di.car.mycar5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

//-----------------------------------------------------------------------------------------------------------
//스프링을 통한 의존성 주입 - 스프링 설정 파일(XML)에서 속성 주입
//-----------------------------------------------------------------------------------------------------------
public class Driver {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		// ApplicationContext	ctx
		// = new GenericXmlApplicationContext("com/edu/di/car/mycar5/appCtx.xml");
		
		// ApplicationContext	ctx
		// = new FileSystemXmlApplicationContext("src/main/java/com/edu/di/car/mycar5/appCtx.xml");
		
		ApplicationContext	ctx
		= new ClassPathXmlApplicationContext("com/edu/di/car/mycar5/appCtx.xml");
		
		// 사용할 Bean을 불러온다.
		Car car = ctx.getBean("car", Car.class);
		System.out.println(car.getTireBrand());

	} // End - public static void main(String[] args)

} // End - public class Driver




