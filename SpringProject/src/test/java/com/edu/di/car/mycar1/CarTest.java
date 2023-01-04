package com.edu.di.car.mycar1;

import org.junit.jupiter.api.Test;

//-----------------------------------------------------------------------------------------------------------
public class CarTest {

	@Test
	public void 자동차_장착_타이어브랜드_테스트() {
		
		Car car = new Car();
		
		System.out.println("현재 장착된 타이어는 " + car.getTireBrand());
	}

}
