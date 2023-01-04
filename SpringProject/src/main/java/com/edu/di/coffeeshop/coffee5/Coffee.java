package com.edu.di.coffeeshop.coffee5;

//-----------------------------------------------------------------------------------------------------------
// 생성자를 통한 주입 (인터페이스 사용)
//-----------------------------------------------------------------------------------------------------------
public class Coffee {
	
	private	Americano americano;
	
	public Coffee(Americano ame) {
		americano = ame;
	}
	
	// public Coffee() {}
	
	public void coffeeType() {
		System.out.println("주문하신 커피는 " + americano.getName() + "입니다.");
	}

}
