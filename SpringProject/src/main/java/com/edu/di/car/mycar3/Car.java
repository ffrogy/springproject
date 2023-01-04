package com.edu.di.car.mycar3;

//-----------------------------------------------------------------------------------------------------------
// 스프링없이 의존성 주입하기 - 속성을 통한 의존성 주입하기.
//-----------------------------------------------------------------------------------------------------------
public class Car {
	
	Tire	tire;

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
	public String getTireBrand() {
		return "장착된 타이어는 " + tire.getBrand();
	}

} // End - public class Car
