package com.edu.di.coffeeshop.coffee2;

public class CoffeeShop {

	public static void main(String[] args) {

		IceAmericano	ice	= new IceAmericano();
		HotAmericano	hot	= new HotAmericano();
		
		Coffee	coffee1	= new Coffee(ice);
		coffee1.coffeeType();
		
		Coffee	coffee2	= new Coffee(hot);
		coffee2.coffeeType();
	}

}
