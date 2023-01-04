package com.edu.di.coffeeshop.coffee6;

//-----------------------------------------------------------------------------------------------------------
// setter() 메서드를 통한 주입
//-----------------------------------------------------------------------------------------------------------
public class Coffee {
	
	private	Americano americano;
	
	public void setCoffee(Americano ame) {
		americano = ame;
	}
	
	public void coffeeType() {
		System.out.println("주문하신 커피는 " + americano.getName() + "입니다.");
	}

}
