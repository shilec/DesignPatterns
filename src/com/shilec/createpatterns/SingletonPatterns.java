package com.shilec.createpatterns;

public class SingletonPatterns {
	
	public static void main(String[] args) {
		Singleton2 instance = Singleton2.getInstance();
		instance.oper("");
		instance = Singleton2.getInstance();
		instance.oper("");
	}
}

/***
 * 线程安全要求不高
 * @author Administrator
 *
 */
class Singleton implements ICommonOper{
	private static Singleton instance;
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}

	public void oper(Object obj) {
		System.out.println("instance = " + instance);
	}
}

/**
 * 线程安全要求高
 * @author Administrator
 */
class Singleton2 implements ICommonOper{
	
	private static Singleton2 instance;
	
	private Singleton2() {
		
	}
	
	private synchronized static void syncInstance() {
		instance = new Singleton2();
	}
	
	public static Singleton2 getInstance() {
		if(instance == null) {
			syncInstance();
		}
		return instance;
	}

	public void oper(Object obj) {
		System.out.println("instance = " + instance);
	}
}

