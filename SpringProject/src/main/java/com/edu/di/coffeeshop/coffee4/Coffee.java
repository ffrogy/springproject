package com.edu.di.coffeeshop.coffee4;

public class Coffee {
	
	private	HotAmericano	ame;
	
	public Coffee() {
		ame = new HotAmericano();
	}

	public void CoffeeType() {
		System.out.println("주문하신 커피는 " + ame.getName() + "입니다.");
	}
}
