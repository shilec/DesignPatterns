package com.shilec.behaviorpatterns.demo;

import java.util.ArrayList;
import java.util.List;

public class VisitorPatternDemo {
	
	public static void main(String[] args) {
		List<FileItem> items = new ArrayList<FileItem>();
		for(int i = 0; i < 10; i++) {
			items.add(new FileItem("1"));
		}
		IOperSubject<List<? extends IFileItem>> operSubject = new OperaWindow();
		operSubject.setOperaItem(items);
		
		
		IOperaion<List<? extends IFileItem>> operaion = new Operator();
		operSubject.accept(operaion);
		
		operSubject.accept(new IOperaion<List<? extends IFileItem>>() {
			public void oper(IOperSubject<List<? extends IFileItem>> item) {
				System.out.println("item operated");
			}
		});
	}
}

interface IFileItem {
	
}

class FileItem implements IFileItem{
	String name;
	public FileItem(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

interface IOperaion<T> {
	void oper(IOperSubject<T> item);
}

interface IOperSubject<T> {
	void accept(IOperaion<T> oper);
	T getOperaItem();
	void setOperaItem(T t);
}

class Operator implements IOperaion<List<? extends IFileItem>> {

	public void oper(IOperSubject<List<? extends IFileItem>> item) {
		System.out.println("oper " + item.getOperaItem());
	}

}

class OperaWindow implements IOperSubject<List<? extends IFileItem>> {
	private List<? extends IFileItem> items;
	public void accept(IOperaion<List<? extends IFileItem>> oper) {
		oper.oper(this);
	}

	public List<? extends IFileItem> getOperaItem() {
		return items;
	}

	public void setOperaItem(List<? extends IFileItem> t) {
		items = t;
	}

}

