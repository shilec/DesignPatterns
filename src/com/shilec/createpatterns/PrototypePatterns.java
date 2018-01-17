package com.shilec.createpatterns;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PrototypePatterns {
	
	public static void main(String[] args) {
		Prototype prototype = new Prototype();
		Serializable obj = new ContentObj(123, "shile", false);
		prototype.setObj(obj);
		try {
			ContentObj o = (ContentObj) prototype.clone();
			o.name = "test";
			
			System.out.println(obj);
			System.out.println(o);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class Prototype implements Cloneable {
	
	private Serializable obj;
	protected Object clone() throws CloneNotSupportedException {
		try {
			return getObj();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Object getObj() throws IOException, ClassNotFoundException {
		if(obj == null) return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
	}
	
	public void setObj(Serializable obj) {
		this.obj = obj;
	}
}

class ContentObj implements Serializable {
	private static final long serialVersionUID = 1L;
	int age;
	String name;
	boolean sex;
	
	public ContentObj(int age,String name,boolean sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	public String toString() {
		return "ContentObj [age=" + age + ", name=" + name + ", sex=" + sex
				+ "]";
	}
	
}