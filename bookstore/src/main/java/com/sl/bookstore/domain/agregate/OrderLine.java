package com.sl.bookstore.domain.agregate;

import com.sl.bookstore.domain.entity.Book;

public class OrderLine {

	private OrderLineId id;
	private Book book;
	private int quantity;

	public OrderLine(OrderLineId id, Book book, int quantity) {
		this.id = id;
		this.book = book;
		this.quantity = quantity;
	}

	public OrderLineId getId() {
		return id;
	}

	public void setId(OrderLineId id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
