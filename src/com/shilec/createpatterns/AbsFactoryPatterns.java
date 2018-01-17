package com.shilec.createpatterns;

/***
 * ���󹤳�ģʽ����������ӿ�
 * @author Administrator
 *
 */
public class AbsFactoryPatterns {
	
	public static void main(String[] args) {
		
		IFactory factory = new Oper1Factory();
		ICommonOper oper = factory.create();
		oper.oper("");
		
		factory = new Oper2Factory();
		oper = factory.create();
		oper.oper("");
	}
}

interface IFactory {
	ICommonOper create();
}

class Oper1Factory implements IFactory {

	public ICommonOper create() {
		return new Operanner1();
	}
}

class Oper2Factory implements IFactory {

	public ICommonOper create() {
		return new Operanner2();
	}
}
