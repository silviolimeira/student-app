package com.sl.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Student {
	private static final Logger logger = LogManager.getLogger(Student.class);
	
	// composition
	@Autowired
	private Address address;
	
	String studentName;
	
	public Student() { }
	
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
