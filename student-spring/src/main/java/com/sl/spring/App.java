package com.sl.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	private static final Logger logger = LogManager.getLogger(App.class);
	
	public static void main(String[] args) {
		logger.info("Hello World ");
		// IoC container - this is where the beans are location
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student s = (Student) context.getBean("student_bean");
		s.sayHello();
	}
}
