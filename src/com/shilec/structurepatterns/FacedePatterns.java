package com.shilec.structurepatterns;

import java.util.ArrayList;
import java.util.List;

public class FacedePatterns {

	public static void main(String[] args) {
		Computer pc = new Computer();
		pc.start();
		pc.shutdown();
	}
}

interface IHardOper {
	void start();
	void shutdown();
}

class CPU implements IHardOper{

	public void start() {
		System.out.println("cpu start");
	}

	public void shutdown() {
		System.out.println("cpu shutdown");
	}
	
}

class Disk implements IHardOper {

	public void start() {
		System.out.println("disk start");
	}

	public void shutdown() {
		System.out.println("disk shutdown");
	}
	
}

class Memeroy implements IHardOper {

	public void start() {
		System.out.println("memeroy start");
	}

	public void shutdown() {
		System.out.println("memeroy shutdown");
	}
	
}

class Computer implements IHardOper {
	List<IHardOper> hardwares;
	
	public Computer() {
		hardwares = new ArrayList();
		hardwares.add(new CPU());
		hardwares.add(new Disk());
		hardwares.add(new Memeroy());
	}
	
	public void start() {
		for(IHardOper oper : hardwares) {
			oper.start();
		}
		System.out.println("computer start!");
	}

	public void shutdown() {
		for(IHardOper oper : hardwares) {
			oper.shutdown();
		}
		System.out.println("computer shutdown!");
	}
	
}