package com.sunway.servlet.assignment3;

public class Student {

	private String name;
	private Integer age;
	private String gender;
	private String address;
	private String phoneNo;

	public Student(String name, Integer age, String gender, String address, String phoneNo) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
