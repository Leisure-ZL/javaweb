package cn.edu.swu.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTool {
	
	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String JDBC_URL = "jdbc:mysql://localhost:3306/products?useUnicode=true&characterEncoding=UTF-8";
	private final static String JDBC_USER = "root";
	private final static String JDBC_PASS = "root";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}		
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}

	
}

