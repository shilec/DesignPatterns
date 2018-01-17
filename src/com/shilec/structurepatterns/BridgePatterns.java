package com.shilec.structurepatterns;

public class BridgePatterns {
	
	public static void main(String[] args) {
		Client client = new Client();
		client.oper();
	}
}

interface IDBOper {
	void add();
	void del();
	void modify();
	void query();
}

class MySql implements IDBOper {

	public void add() {
		System.out.println("mysql add");
	}

	public void del() {
		System.out.println("mysql del");
	}

	public void modify() {
		System.out.println("mysql modify");
	}

	public void query() {
		System.out.println("mysql query");
	}
	
}

class Sqlite implements IDBOper {

	public void add() {
		System.out.println("sqlite add");
	}

	public void del() {
		System.out.println("sqlite del");
	}

	public void modify() {
		System.out.println("sqlite modify");
	}

	public void query() {
		System.out.println("sqlite query");
	}
}

 class Bridge implements IDBOper{
	private IDBOper db;
	
	public Bridge(IDBOper db) {
		this.db = db;
	}
	public void setDb(IDBOper db) {
		this.db = db;
	}

	public void add() {
		db.del();
	}

	public void del() {
		db.del();
	}

	public void modify() {
		db.modify();
	}

	public void query() {
		db.query();
	}
	
}
 
class Client {
	public void oper() {
		Bridge bridge = new Bridge(new MySql());
		bridge.add();
		
		bridge.setDb(new Sqlite());
		bridge.del();
	}
}