package com.edu.di.coffeeshop.coffee3;

public class Coffee {
	
	private	Americano americano;
	
	//-----------------------------------------------------------------------------------------------------------
	// setter() 메서드를 사용하여 의존성을 주입한다.
	// 객체 생성을 걷어내기 위해서 의존성을 주입한다.
	//-----------------------------------------------------------------------------------------------------------
	public void setCoffee(Americano americano) {
		this.americano = americano;
	}

	public void coffeeType() {
		System.out.println("주문하신 커피는 " + americano.getName() + "입니다.");
	}
}
