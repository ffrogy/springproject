package com.edu.di.car.mycar6;

import org.springframework.beans.factory.annotation.Autowired;

//-----------------------------------------------------------------------------------------------------------
//스프링을 통한 의존성 주입 - @Autowired를 통해서 속성을 주입한다.
//-----------------------------------------------------------------------------------------------------------
public class Car {
	
	@Autowired
	Tire tire;

	public String getTireBrand() {
		return "장착된 타이어는 " + tire.getBrand();
	}
}
