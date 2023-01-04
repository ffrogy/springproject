package com.edu.di.coffeeshop.coffee2;

public class Coffee {

	private Americano americano;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자를 사용하여 의존성을 주입한다.
	// 객체 생성을 걷어내기 위해서 의존성을 주입한다.
	//-----------------------------------------------------------------------------------------------------------
	public Coffee(Americano ame) {
		americano = ame;
	}
	
	public void coffeeType() {
		System.out.println("주문하신 커피는 " + americano.getName() + "입니다.");
	}
	
}
