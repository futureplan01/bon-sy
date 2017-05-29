package com.beans;

public class Drug {
	
	private int id;
	
	private String name;
	
	private String Pname;
	
	public Drug() {
	}
	
	public Drug(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.Pname = Pname;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPerson() {
		return Pname;
	}
	
}
