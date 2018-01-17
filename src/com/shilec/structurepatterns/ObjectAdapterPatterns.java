package com.shilec.structurepatterns;

public class ObjectAdapterPatterns {

	public static void main(String[] args) {
		Orignal orignal = new Orignal();
		NewDest2 newDest2 = new Wrraper2(orignal);
		newDest2.func1();
		newDest2.func2();
	}
}

interface NewDest2 extends NewDest {
	void func2();
}

class Wrraper2 implements NewDest2 {

	private Orignal orignal;
	
	public Wrraper2(Orignal orignal) {
		this.orignal = orignal;
	}
	public void func1() {
		System.out.println("newdest func");
	}
	public void func2() {
		orignal.func();
	}
}