package com.shilec.structurepatterns;

public class ClassAdapterPatterns {
	public static void main(String[] args) {
		Wrraper wrraper = new Wrraper();
		wrraper.func();
		wrraper.func1();
	}
}

class Orignal {
	void func() {
		System.out.println("Orignal func");
	}
}

interface NewDest {
	void func1();
}

class Wrraper extends Orignal implements NewDest{

	public void func1() {
		System.out.println("newdest func");
	}
}