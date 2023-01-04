package com.edu.di.coffeeshop.coffee5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CoffeeShop {

	public static void main(String[] args) {

		ApplicationContext ctx
		= new GenericXmlApplicationContext("com/edu/di/coffeeshop/coffee5/applicationContext.xml");
		
		Coffee coffee = ctx.getBean("coffee", Coffee.class);
		coffee.coffeeType();
		
	}

}



