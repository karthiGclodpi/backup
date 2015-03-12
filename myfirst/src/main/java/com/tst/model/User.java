package com.tst.model;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class User {

	private String name;
	private int age;
	private int location;
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
