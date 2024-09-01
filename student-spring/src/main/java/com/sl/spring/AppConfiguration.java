package com.sl.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

	@Bean(name="student_bean")
	@Scope(value="singleton")
	public Student getStudent() {
		return new Student();
	}
	
	@Bean(name="address_bean")
	public Address getAddress() {
		return new Address();
	}
}
