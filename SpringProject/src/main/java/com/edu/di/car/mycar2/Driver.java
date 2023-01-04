package com.edu.di.car.mycar2;

//-----------------------------------------------------------------------------------------------------------
//스프링 없이 의존성 주입하기 - 생성자를 통해서 의존성을 주입한다.
//-----------------------------------------------------------------------------------------------------------
public class Driver {

	//-----------------------------------------------------------------------------------------------------------
	// 운전자가 타이어를 생산한다. => Tire	tireK	= new KoreaTire();
	// 운전자가 자동차를 생산하면서 타이어를 장착한다. => Car car = new Car(tireE);
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Tire	tireK	= new KoreaTire();
		Tire	tireA	= new AmericaTire();
		Tire	tireE	= new EuropeTire();
		
		Car		car		= new Car(tireE);
		System.out.println(car.getTireBrand());
		
	}

} // End - public class Driver
