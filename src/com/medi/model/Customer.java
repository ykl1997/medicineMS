package com.medi.model;

public class Customer {
	int id;
	String name;
	String phone;
	String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(int id, String name, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
	}

	public Customer() {
		super();
	}

}
