package com.shilec.behaviorpatterns;

public class IteraterPatterns {
	
	public static void main(String[] args) {
		Collection collection = new MyColection();
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
}

interface Iterator {
	Object previous();
	Object next();
	boolean hasNext();
	Object first();
}

interface Collection {
	int size();
	Object get(int i);
	Iterator iterator();
}

class MyColection implements Collection {

	private String[] str = new String[]{
			"a","b","c"
	};
	public int size() {
		return str.length;
	}

	public Object get(int i) {
		return str[i];
	}

	public Iterator iterator() {
		return new MyIterator(this);
	}
	
}

class MyIterator implements Iterator {
	
	private int index = 0;
	private Collection collection;
	
	public MyIterator(Collection collection) {
		this.collection = collection;
	}
	public Object previous() {
		if(index > 0) {
			index--;
		}
		return collection.get(index);
	}

	public Object next() {
		if(index <=collection.size()) {
			return collection.get(index++);
		}
		return null;
	}

	public boolean hasNext() {
		return index <= collection.size() - 1;
	}

	public Object first() {
		return collection.get(0);
	}
	
}