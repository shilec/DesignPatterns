package com.shilec.behaviorpatterns;

public class TemplatePatterns {
	
	public static void main(String[] args) {
		ICalculator cal = new Sum1();
		int calculate = cal.calculate("1,2");
		System.out.println(calculate);
		
		cal = new Max1();
		calculate = cal.calculate("3,4");
		System.out.println(calculate);
	}
}

abstract class BaseCalculator extends ExpressionHelper implements ICalculator {
	
	public int calculate(String exp) {
		int[] num = getNumber(exp);
		return calculate(num[0],num[1]);
	}
	
	public abstract int calculate(int num1,int num2);
}

class Sum1 extends BaseCalculator {

	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
	
}

class Max1 extends BaseCalculator {

	@Override
	public int calculate(int num1, int num2) {
		return num1 > num2 ? -1 : 1;
	}
	
}