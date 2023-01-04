package com.edu.di.coffeeshop.coffee4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//-----------------------------------------------------------------------------------------------------------
// 스프링컨테이너의 기본 객체관리는 
//	컨테이너 생성시 자신이 포함할 Bean 객체를 모두 생성한다.
//	객체를 제거하는 것은 컨테이너가 삭제될 때 다 제거된다.
//-----------------------------------------------------------------------------------------------------------
public class CoffeeShop {

	public static void main(String[] args) {

		ApplicationContext	ctx
			= new GenericXmlApplicationContext("com/edu/di/coffeeshop/coffee4/applicationContext.xml");
		
		Coffee coffee = ctx.getBean("coffee", Coffee.class);
		coffee.CoffeeType();
		
	}

}
