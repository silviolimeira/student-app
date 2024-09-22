package com.sl.bookstore.domain.entity;

public class Book {

	private BookId id;
	private BookTitle title;
	private BookDescription description;

	public Book(BookId id, BookTitle title, BookDescription description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public BookId getId() {
		return id;
	}

	public void setId(BookId id) {
		this.id = id;
	}

	public BookTitle getTitle() {
		return title;
	}

	public void setTitle(BookTitle title) {
		this.title = title;
	}

	public BookDescription getDescription() {
		return description;
	}

	public void setDescription(BookDescription description) {
		this.description = description;
	}

}
