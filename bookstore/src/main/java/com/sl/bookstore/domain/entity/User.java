package com.sl.bookstore.domain.entity;

public class User {

	private UserId id;
	private String name;
	private String email;

	public User() {
	}

	public User(UserId id, String name, String email) {
		this();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public UserId getId() {
		return id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
