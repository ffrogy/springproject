package com.edu.di.car.mycar3;

//-----------------------------------------------------------------------------------------------------------
//스프링없이 의존성 주입하기 - 속성을 통한 의존성 주입하기.
//-----------------------------------------------------------------------------------------------------------
public class Driver {

	//-----------------------------------------------------------------------------------------------------------
	// 운전자가 타이어를 생산한다. 	=> Tire	tireK	= new KoreaTire();
	// 운전자가 자동차를 생산한다. 	=> Car	car		= new Car();
	// 운전자가 자동차에 타이어를 장착한다.(setter() 메서드를 사용한다.)
	//								=> car.setTire(tireK);
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		Tire	tireK	= new KoreaTire();
		Tire	tireA	= new AmericaTire();
		Tire	tireE	= new EuropeTire();
		
		Car		car		= new Car();
		// 속성을 통해서 의존성을 주입한다.
		car.setTire(tireK);
		
		System.out.println(car.getTireBrand());

	}

} // End - public class Driver







