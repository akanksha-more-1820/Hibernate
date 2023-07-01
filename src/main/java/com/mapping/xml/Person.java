package com.mapping.xml;

public class Person {

	private int id;
	private String nameString;
	private String address;
	private String phoneString;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneString() {
		return phoneString;
	}
	public void setPhoneString(String phoneString) {
		this.phoneString = phoneString;
	}
	public Person(int id, String nameString, String address, String phoneString) {
		super();
		this.id = id;
		this.nameString = nameString;
		this.address = address;
		this.phoneString = phoneString;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
