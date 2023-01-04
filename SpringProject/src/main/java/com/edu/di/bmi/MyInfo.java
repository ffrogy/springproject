package com.edu.di.bmi;

import java.util.ArrayList;

//-----------------------------------------------------------------------------------------------------------
// 개인 정보
//-----------------------------------------------------------------------------------------------------------
public class MyInfo {

	private	String				name;		// 이름
	private	double				height;		// 키
	private	double				weight;		// 몸무게
	private	ArrayList<String>	hobby;		// 취미

	private	BMICalculator		bmiCalculator;
	
	public void bmiCalculate() 	{
		bmiCalculator.bmiCalculator(weight, height);
	}
	
	public void getInfo() {
		System.out.println("이  름 : " + name);
		System.out.println("키     : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("취  미 : " + hobby);
		
		// BMI 지수를 계산하여 결과를 보여준다.
		bmiCalculate();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ArrayList<String> getHobby() {
		return hobby;
	}

	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}

	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}

	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}

	@Override
	public String toString() {
		return "나의 정보 [이름=" + name + ", 키=" + height + ", 몸무게;=" + weight + ", 취미=" + hobby
				+ ", BMI 지수=" + bmiCalculator + "]";
	}
		
} // End - public class MyInfo






