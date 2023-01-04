package com.edu.di.coffeeshop.coffee1;

//-----------------------------------------------------------------------------------------------------------
// public class Coffee
//-----------------------------------------------------------------------------------------------------------
public class Coffee {

	private IceAmericano ame;
	private HotAmericano hme;
	
	public Coffee() {
		// ame = new IceAmericano();
		hme = new HotAmericano();
	}
	public void coffeeType() {
		// System.out.println(ame.getName());
		System.out.println(hme.getName());
	}
	
} // End - public class Coffee
