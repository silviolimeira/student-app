package com.sl.bookstore.domain.entity;

import java.util.Objects;

public class UserId {

	private String value;

	public UserId(String value) {
		this.value = value;
	}

	public UserId(int value) {
		this.value = Integer.toString(value);
	}

	public String getValue() {
		return value;
	}
	
	public Integer getInteger() {
		return Integer.parseInt(value);
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserId other = (UserId) obj;
		return Objects.equals(value, other.value);
	}

}
