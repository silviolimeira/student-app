package com.sl.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student {

	private static final Logger logger = LogManager.getLogger(Student.class);
	
	public void sayHello() {
		logger.info("Hello World from Spring Framework...");
	}
}
