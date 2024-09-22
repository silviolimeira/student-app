package com.sl.bookstore.domain.entity;

import java.util.Objects;

public class BookTitle {
	private String value;

	public BookTitle() {
	}

	public BookTitle(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
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
		BookTitle other = (BookTitle) obj;
		return Objects.equals(value, other.value);
	}

}
