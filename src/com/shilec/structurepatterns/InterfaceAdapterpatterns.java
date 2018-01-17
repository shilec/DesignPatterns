package com.shilec.structurepatterns;

/***
 * androidÖÐµÄSimpleXXX SimpleAdapter SimpleListenner µÈ
 * @author Administrator
 *
 */
public class InterfaceAdapterpatterns {
	
	public static void main(String[] args) {
		AbsWrraper wrraper = new Dest1();
		wrraper.func1();
		wrraper.func2();
		
		wrraper = new Dest2();
		wrraper.func1();
		wrraper.func2();
	} 
}

abstract class AbsWrraper implements NewDest2 {

	public void func1() {
		
	}

	public void func2() {
		
	}
}

class Dest1 extends AbsWrraper {
	public void func1() {
		System.out.println("dest1 func");
	}
}

class Dest2 extends AbsWrraper {
	public void func2() {
		System.out.println("dest2 func");
	}
}
