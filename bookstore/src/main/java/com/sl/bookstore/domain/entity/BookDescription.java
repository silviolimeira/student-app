package com.sl.bookstore.domain.entity;

import java.util.Objects;

public class BookDescription {
	private String value;

	public BookDescription() {
	}

	public BookDescription(String value) {
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
		BookDescription other = (BookDescription) obj;
		return Objects.equals(value, other.value);
	}

}
