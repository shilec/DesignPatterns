package com.shilec.structurepatterns;

public class ProxyPatterns {
	
	public static void main(String[] args) {
		OperProxy proxy = new OperProxy();
		proxy.oper();
	}
}

/***
 * Ҫȷ���ӿڵĵ�һԭ���������ܱ�֤������չ��Ӱ�����нӿ�
 * @author Administrator
 */
interface ICommonOper {
	void oper();
}
class NativeOper implements ICommonOper{

	public void oper() {
		System.out.println("nativie oper");
	}
}

class OperProxy implements ICommonOper{
	private ICommonOper oper;
	
	public OperProxy() {
		oper = new NativeOper();
	}
	
	public void oper() {
		System.out.println("oper before");
		oper.oper();
		System.out.println("oper after");
	}
}