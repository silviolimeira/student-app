package com.sl.student;

public class App {

	public static void main(String[] args) {
		JdbcQuery query = new JdbcQuery(args[0], args[1], args[2]);
		query.handleDatabase();
	}
}
