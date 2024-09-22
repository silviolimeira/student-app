package com.sl.bookstore.domain.agregate;

import java.util.List;

public class Order {
	
	private OrderId id;
	private List<OrderLine> orderLines;

	public void addOrderLine(OrderLine orderLine) {
		// Business logic here
	}

	public Order(OrderId id) {
		this.id = id;
	}

	public OrderId getId() {
		return id;
	}

	public void setId(OrderId id) {
		this.id = id;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	
}
