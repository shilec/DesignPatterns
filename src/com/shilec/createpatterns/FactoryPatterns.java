package com.shilec.createpatterns;

public class FactoryPatterns {
	public static void main(String[] args) {
		ICommonOper oper = OperannerFactory.create("oper1");
		oper.oper("");
		oper = OperannerFactory.create("oper2");
		oper.oper("");
	}
}

interface ICommonOper {
	void oper(Object obj);
}

class Operanner1 implements ICommonOper {

	public void oper(Object obj) {
		System.out.println("operanner1 oper!");
	}
	
}

class Operanner2 implements ICommonOper {

	public void oper(Object obj) {
		System.out.println("operanner2 oper!");
	}
}

class OperannerFactory {
	public static ICommonOper create(String type) {
		if("oper1".equals(type)) {
			return new Operanner1();
		} else if("oper2".equals(type)) {
			return new Operanner2();
		}
		return null;
	}
	
	/***********************************/
	/**静态工厂方法模式**/
	/***********************************/
	public static ICommonOper oper1() {
		return new Operanner1();
	}
	
	public static ICommonOper oper2() {
		return new Operanner2();
	}
}