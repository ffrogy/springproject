package com.edu.di.bmi;

//-----------------------------------------------------------------------------------------------------------
// BMI(Body Mass Index : 체질량 지수)
// 비만도 측정(BMI지수)
// BMI를 이용한 비만도 계산은 자신의 몸무게를 키의 제곱으로 나누는 것으로 공식은 kg/㎡.
// BMI가 18.5 이하면 저체중 ／ 18.5 ~ 22.9 사이면 정상 ／ 23.0 ~ 24.9 사이면 과체중 ／ 25.0 이상부터는 비만으로 판정.
// ex) 키 170㎝에 몸무게 73kg이면, 계산식 : 73 / (1.7×1.7) = 25.26 → 과체중
//-----------------------------------------------------------------------------------------------------------
public class BMICalculator {

	// 체질량 계산에 기준이 되는 변수들
	private	double	lowWeight;		// 저체중
	private	double	normal;			// 정상
	private	double	overWeight;		// 과체중
	private	double	obesity;		// 비만
	
	//-----------------------------------------------------------------------------------------------------------
	// 체질량 지수를 계산하는 메서드
	//-----------------------------------------------------------------------------------------------------------
	public void bmiCalculator(double weight, double height) {
		
		double	h		= height * 0.01;
		double	result	= weight / (h*h);
		
		if(result > obesity) {
			System.out.println("비만입니다.");
		} else if(result > overWeight) {
			System.out.println("과체중입니다.");
		} else if(result > normal) {
			System.out.println("정상입니다.");
		} else {
			System.out.println("저체중입니다.");
		}
		
	} // End - public void bmiCalculator(double weight, double height)

	public double getLowWeight() {
		return lowWeight;
	}

	public void setLowWeight(double lowWeight) {
		this.lowWeight = lowWeight;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getOverWeight() {
		return overWeight;
	}

	public void setOverWeight(double overWeight) {
		this.overWeight = overWeight;
	}

	public double getObesity() {
		return obesity;
	}

	public void setObesity(double obesity) {
		this.obesity = obesity;
	}

	@Override
	public String toString() {
		return "BMICalculator [lowWeight=" + lowWeight + ", normal=" + normal + ", overWeight=" + overWeight
				+ ", obesity=" + obesity + "]";
	}

	
} // End - public class BMICalculator







