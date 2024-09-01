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
	
	@Bean(name="first_address")
	public Address getAddress1() {
		return new Address("First Address");
	}
	
	@Bean(name="second_address")
	public Address getAddress2() {
		return new Address("Second Address");
	}
}
