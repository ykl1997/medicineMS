package com.medi.model;

public class Employee {
	int id;
	String name;
	String sex;
	String degeree;
	String position;
	int age;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegeree() {
		return degeree;
	}

	public void setDegeree(String degeree) {
		this.degeree = degeree;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee(int id, String name, String sex, String degeree, String position, int age, String password) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.degeree = degeree;
		this.position = position;
		this.age = age;
		this.password = password;
	}

	public Employee() {
		super();
	}

}
