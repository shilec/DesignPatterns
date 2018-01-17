package com.shilec.behaviorpatterns;

import java.util.Vector;

public class ObserverPatterns {
	public static void main(String[] args) {
		ISubject subject = new MySubject();
		IObserver observer = new MyObserver1();
		subject.add(observer);
		observer = new MyObserver2();
		subject.add(observer);
		
		subject.oper();
	}
}

interface IObserver {
	void update();
}

interface ISubject {
	void add(IObserver observer);
	void del(IObserver observer);
	void notifyallObservers();
	void oper();
}

class MyObserver1 implements IObserver {

	public void update() {
		System.out.println("myobserver1 被观察这变化");
	}
}

class MyObserver2 implements IObserver {

	public void update() {
		System.out.println("myobserver2 被观察这变化");
	}
}

abstract class BaseSubject implements ISubject {
	private Vector<IObserver> observers = new Vector<IObserver>();
	
	public void add(IObserver observer) {
		observers.add(observer);
	}
	
	public void del(IObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyallObservers() {
		for(IObserver observer : observers) {
			observer.update();
		}
	}
}

class MySubject extends BaseSubject {
	public void oper() {
		System.out.println("正在执行====》");
		System.out.println("执行完成====》");
		notifyallObservers();
	}
}