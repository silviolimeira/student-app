package com.sl.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JdbcQuery {
	private static final Logger logger = LogManager.getLogger(JdbcQuery.class);
	
	private static final String JDBC_DRIVER =
			"com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = 
			"jdbc:mysql://localhost/udemy?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public void handleDatabase()  
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			
			String sqlQuery = "SELECT * FROM students";
			resultSet = statement.executeQuery(sqlQuery);
			
			int id = 0;
			String name = null;
			int age = 0;
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				name = resultSet.getString("name");
				age = resultSet.getInt("age");
			}
			
			Student student = new Student(id, name, age);
			logger.info(student);
			
			
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error(e);
			}
			
		}
	}
	
	
	
}
