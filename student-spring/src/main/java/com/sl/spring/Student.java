package com.sl.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student {
	private static final Logger logger = LogManager.getLogger(Student.class);
	
	// composition
	private Address address;
	
	String studentName;
	
	public Student(Address address) {
		this.address = address;
	}
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String showInfo() {
		return "Address is: " + address.toString();
	}
	
	

	
}
