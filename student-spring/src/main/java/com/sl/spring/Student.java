package com.sl.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student {
	private static final Logger logger = LogManager.getLogger(Student.class);
	
	String studentName;
	
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void sayHello() {
		logger.info("Hello World from Spring Framework...");
	}
	
	public void initStudent() {
		logger.info("This is the init() method...");
	}
	
	// this is not called when the scope="prototype"
	public void destroyStudent() {
		logger.info("This is the destroy() method ...");
	}
	
}
