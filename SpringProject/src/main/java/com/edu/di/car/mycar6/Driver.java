package com.edu.di.car.mycar6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//-----------------------------------------------------------------------------------------------------------
//스프링을 통한 의존성 주입 - @Autowired를 통해서 속성을 주입한다.
//-----------------------------------------------------------------------------------------------------------
public class Driver {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		// 스프링 설정 파일을 읽어 들인다. => 컨테이너가 구성된다.
		// 컨테이너 구성 => 설정 파일에서 <bean>으로 지정한 것이 Bean으로 등록된다.
		ApplicationContext ctx
		= new ClassPathXmlApplicationContext("com/edu/di/car/mycar6/appCtx.xml");
		// <bean id="tire"	class="com.edu.di.car.mycar6/KoreaTire"/>
		// KoreaTire tire	= new KoreadTire();
		
		// 필요한 Bean을 가져온다.
		Car car = ctx.getBean("car", Car.class);
		System.out.println(car.getTireBrand());
		
	}

} // End - public static void main(String[] args)








