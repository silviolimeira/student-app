package com.sl.spring_1;

import org.springframework.stereotype.Component;

@Component
public class Address {

	private String address;
	
	public Address() {
		this.address = "Wall Streeat 20";
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
