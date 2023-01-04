package com.edu.di.car.mycar2;

import org.junit.jupiter.api.Test;

//-----------------------------------------------------------------------------------------------------------
public class CarTest {

	//-----------------------------------------------------------------------------------------------------------
	@Test
	public void 자동차_한국타이어_장착_타이어브랜드_테스트() {
		
		Tire 	tire 	= new KoreaTire();
		Car		car		= new Car(tire);
		
		System.out.println("장착된 한국 타이어 => " + car.getTireBrand());
		
	}

	//-----------------------------------------------------------------------------------------------------------
	@Test
	public void 자동차_미국타이어_장착_타이어브랜드_테스트() {
		
		Tire 	tire 	= new AmericaTire();
		Car		car		= new Car(tire);
		
		System.out.println("장착된 미국 타이어 => " + car.getTireBrand());
		
	}

	
	
} // End - public class CarTest
