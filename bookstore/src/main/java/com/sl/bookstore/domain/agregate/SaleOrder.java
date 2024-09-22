package com.sl.bookstore.domain.agregate;

import java.util.List;

// Within the Sales Bounded Context
public class SaleOrder {

	private OrderId id;
	private List<OrderLine> orderLines;
	
	// Ohter sales-specific fields and methods
	
}
