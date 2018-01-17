package com.shilec.behaviorpatterns;

import javax.security.auth.Subject;

public class VisitorPatterns {
	
	public static void main(String[] args) {
		IVisitor visitor = new MyVisitor();
		ISubject1<String> subject1 = new MySubject1();
		subject1.accept(visitor);
	}
}

interface IVisitor {
	void visit(ISubject1 subject);
}

interface ISubject1<T>{
	void accept(IVisitor visitor);
	T getContent();
}

class MyVisitor implements IVisitor {

	public void visit(ISubject1 subject) {
		System.out.println("visis " + subject.getContent());
	}
}

class MySubject1 implements ISubject1<String> {

	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public String getContent() {
		return "subject content";
	}
	
}