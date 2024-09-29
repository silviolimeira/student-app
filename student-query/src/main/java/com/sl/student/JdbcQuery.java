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
			"jdbc:mysql://localhost/db000?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	
	public void handleDatabase()  
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			
			connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			executeColumnUpdate(connection);
			executeTableUpdate(connection);
			executeDatabaseUpdate(connection);
			
			
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void executeColumnUpdate(Connection connection) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;		
		statement = connection.createStatement();
		String sqlQuery = "SELECT CONCAT('ALTER TABLE `', TABLE_NAME, '` MODIFY COLUMN `', COLUMN_NAME,'` ', \n"
				+ "              DATA_TYPE, IF(CHARACTER_MAXIMUM_LENGTH IS NULL \n"
				+ "       OR DATA_TYPE LIKE 'longtext', '', CONCAT('(', CHARACTER_MAXIMUM_LENGTH, \n"
				+ "                                         ')') \n"
				+ "       ), ' COLLATE utf8mb4_unicode_ci ', \n"
				+ "       IF(INFORMATION_SCHEMA.COLUMNS.IS_NULLABLE = 'YES', 'DEFAULT NULL;', 'NOT NULL;')) \n"
				+ "       AS 'Columns' \n"
				+ "FROM   INFORMATION_SCHEMA.COLUMNS \n"
				+ "WHERE  TABLE_SCHEMA = 'db000' \n"
				+ "       AND (SELECT INFORMATION_SCHEMA.TABLES.TABLE_TYPE \n"
				+ "            FROM   INFORMATION_SCHEMA.TABLES \n"
				+ "            WHERE  INFORMATION_SCHEMA.TABLES.TABLE_SCHEMA = \n"
				+ "                   INFORMATION_SCHEMA.COLUMNS.TABLE_SCHEMA \n"
				+ "                   AND INFORMATION_SCHEMA.TABLES.TABLE_NAME = \n"
				+ "                       INFORMATION_SCHEMA.COLUMNS.TABLE_NAME \n"
				+ "            LIMIT  1) LIKE 'BASE TABLE' \n"
				+ "       AND DATA_TYPE IN ( 'char', 'varchar' );";
		resultSet = statement.executeQuery(sqlQuery);
		
		String resultString = null;
		while (resultSet.next()) {
			resultString = resultSet.getString("columns");
			logger.info(resultString);
			executeUpdate(connection,resultString);
		}
		resultSet.close();

	}
	
	void executeTableUpdate(Connection connection) throws SQLException {
		Statement statement = null;
		ResultSet resultSet = null;		
		statement = connection.createStatement();
		
		String sqlQuery = "SELECT CONCAT('ALTER TABLE `', TABLE_NAME, \n"
				+ "              '` CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;') \n"
				+ "       AS 'tables' \n"
				+ "FROM   INFORMATION_SCHEMA.TABLES \n"
				+ "WHERE  TABLE_SCHEMA = 'db000' \n"
				+ "       AND TABLE_TYPE LIKE 'BASE TABLE';";
		resultSet = statement.executeQuery(sqlQuery);
		
		String resultString = null;
		while (resultSet.next()) {
			resultString = resultSet.getString("tables");
			logger.info(resultString);
			executeUpdate(connection,resultString);
		}
		resultSet.close();
	}
	
	void executeDatabaseUpdate(Connection connection) throws SQLException {
		String sqlQuery = "ALTER DATABASE db000 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;";
		executeUpdate(connection, sqlQuery);
	}
	
	void executeUpdate(Connection connection, String sql) throws SQLException {
		Statement statement = null;
		int resultSet = 0;
		statement = connection.createStatement();
		resultSet = statement.executeUpdate(sql);
		logger.info(resultSet);
	}
	
}
