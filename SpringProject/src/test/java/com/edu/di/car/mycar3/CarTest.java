package com.edu.di.car.mycar3;

import org.junit.jupiter.api.Test;

//-----------------------------------------------------------------------------------------------------------
//스프링없이 의존성 주입하기 - 속성을 통한 의존성 주입하기.
//-----------------------------------------------------------------------------------------------------------
public class CarTest {
	
	@Test
	public void 자동차_한국타이어_장착_타이어브랜드_테스트() {
		
		Tire	tire	= new KoreaTire();
		Car		car		= new Car();
		car.setTire(tire);
		
		System.out.println("장착된 한국 타이어 => " + car.getTireBrand());
		
	}

	@Test
	public void 자동차_유럽타이어_장착_타이어브랜드_테스트() {
		
		Tire	tire	= new EuropeTire();
		Car		car		= new Car();
		car.setTire(tire);
		
		System.out.println("장착된 유럽 타이어 => " + car.getTireBrand());
		
	}

	
	
} // End - public class CarTest
