package com.sl.student;

import java.io.FileWriter;
import java.io.IOException;
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
	private static final String DATABASE_URL_BASE = 
			"jdbc:mysql://localhost/%s?serverTimezone=UTC";
	private static final String USERNAME = "root";
	private String username;
	private String password;
	private String db;
	private String charset;
	private String collate;
	
	public JdbcQuery(String db, String username, String password) {
		this.db = db;
		this.username = username;
		this.password = password;
		this.charset = "utf8";
		this.collate = "utf8_unicode_ci";
	}
	
	public void handleDatabase()  
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName(JDBC_DRIVER);

			String database_url = String.format(DATABASE_URL_BASE, this.db);
			connection = DriverManager.getConnection(database_url, username, password);

			executeDatabaseUpdate(connection);
			executeTableUpdate(connection);
			executeColumnUpdate(connection);
			
			
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	void executeColumnUpdate(Connection connection) throws SQLException, IOException {
		Statement statement = null;
		ResultSet resultSet = null;
	    FileWriter script = new FileWriter("db.sql", true);
	    script.write("-- COLUMN UPDATE ---\r\n");
		statement = connection.createStatement();
		String sqlQuery = "SELECT CONCAT('ALTER TABLE `', TABLE_NAME, '` MODIFY COLUMN `', COLUMN_NAME,'` ', \n"
				+ " DATA_TYPE, IF(CHARACTER_MAXIMUM_LENGTH IS NULL \n"
				+ "  OR DATA_TYPE LIKE 'longtext', '', CONCAT('(', CHARACTER_MAXIMUM_LENGTH, \n"
				+ "  ')') \n"
				+ " ), ' COLLATE utf8mb4_unicode_ci ', \n"
				+ " IF(INFORMATION_SCHEMA.COLUMNS.IS_NULLABLE = 'YES', 'DEFAULT NULL;', 'NOT NULL;')) \n"
				+ " AS 'Columns' \n"
				+ "FROM INFORMATION_SCHEMA.COLUMNS \n"
				+ String.format("WHERE  TABLE_SCHEMA = '%s' \n", db)
				+ " AND (SELECT INFORMATION_SCHEMA.TABLES.TABLE_TYPE \n"
				+ "   FROM   INFORMATION_SCHEMA.TABLES \n"
				+ "   WHERE  INFORMATION_SCHEMA.TABLES.TABLE_SCHEMA = \n"
				+ "     INFORMATION_SCHEMA.COLUMNS.TABLE_SCHEMA \n"
				+ "     AND INFORMATION_SCHEMA.TABLES.TABLE_NAME = \n"
				+ "     INFORMATION_SCHEMA.COLUMNS.TABLE_NAME \n"
				+ "     LIMIT  1) LIKE 'BASE TABLE' \n"
				+ "     AND DATA_TYPE IN ( 'char', 'varchar' );";
		resultSet = statement.executeQuery(sqlQuery);
		
		String resultString = null;
		while (resultSet.next()) {
			resultString = resultSet.getString("columns");
			logger.info(resultString);
			//executeUpdate(connection,resultString);
			script.write(resultString + "\r\n");
		}
		script.close();
		resultSet.close();

	}
	
	void executeTableUpdate(Connection connection) throws SQLException, IOException {
		Statement statement = null;
		ResultSet resultSet = null;		
		statement = connection.createStatement();
	    FileWriter script = new FileWriter("db.sql", true);
	    script.write("-- TABLE UPDATE ---\r\n");
		
		String sqlQuery = "SELECT CONCAT('ALTER TABLE `', TABLE_NAME, \n"
				+ "'` CONVERT TO CHARACTER SET " + charset + " COLLATE " + collate + ";') \n"
				+ " AS 'tables' \n"
				+ "FROM   INFORMATION_SCHEMA.TABLES \n"
				+ String.format("WHERE  TABLE_SCHEMA = '%s' \n", db)
				+ " AND TABLE_TYPE LIKE 'BASE TABLE';";
		resultSet = statement.executeQuery(sqlQuery);
		
		String resultString = null;
		while (resultSet.next()) {
			resultString = resultSet.getString("tables");
			logger.info(resultString);
			//executeUpdate(connection,resultString);
			script.write(resultString + "\r\n");
		}
		script.close();
		resultSet.close();
	}
	
	void executeDatabaseUpdate(Connection connection) throws SQLException, IOException {
		FileWriter script = new FileWriter("db.sql");
	    script.write("-- DATABASE UPDATE ---\r\n");
		script.write("USE " + db + ";\r\n");
		String sqlQuery = "ALTER DATABASE db000 CHARACTER SET " + charset + " COLLATE " + collate + ";";
		script.write(sqlQuery + "\r\n");
		script.close();
		
		//executeUpdate(connection, sqlQuery);
	}
	
	void executeUpdate(Connection connection, String sql) throws SQLException {
		Statement statement = null;
		int resultSet = 0;
		statement = connection.createStatement();
		resultSet = statement.executeUpdate(sql);
		logger.info(resultSet);
	}
	
}
