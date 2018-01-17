package com.shilec.behaviorpatterns;

public class StrategyPatterns {
	
	public static void main(String[] args) {
		ICalculator cal = new Sum();
		int calculate = cal.calculate("1,2");
		System.out.println(calculate);
		
		cal = new Max();
		calculate = cal.calculate("3,4");
		System.out.println(calculate);
	}
}

interface ICalculator {
	int calculate(String exp);
}

abstract class ExpressionHelper {
	public int[] getNumber(String exp) {
		String[] nums = exp.split(",");
		int[] ns = new int[2];
		ns[0] = Integer.parseInt(nums[0]);
		ns[1] = Integer.parseInt(nums[1]);
		return ns;
	}
}

class Sum extends ExpressionHelper implements ICalculator {

	public int calculate(String exp) {
		int[] nums = getNumber(exp);
		return nums[0] + nums[1];
	}
}

class Max extends ExpressionHelper implements ICalculator {

	public int calculate(String exp) {
		int[] nums = getNumber(exp);
		return nums[0] > nums[1] ? -1 : 1;
	}
	
}