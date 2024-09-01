package com.sl.spring;

public class Address {

	private String address;

	public Address() {
		this.address = "Wall Street 20";
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + "]";
	}

}
