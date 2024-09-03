package com.sl.spring_1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private static final Logger logger = LogManager.getLogger(MyController.class);

	@Autowired
	private Student student;
	
	@Autowired
	private SingletonBean bean;

	@GetMapping(value = "/index")
	public String sayHello() {
		logger.info(student.showInfo());
		return student.showInfo();
	}
	
	@GetMapping("/api")
	public void getMethod() {
		logger.info(bean.get());
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
