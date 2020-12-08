package cn.edu.swu.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools {

	private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final static String JDBC_URL = "jdbc:mysql://172.18.5.74:3306/mydb?useUnicode=true&characterEncoding=UTF-8";
	private final static String JDBC_USER = "buyer";
	private final static String JDBC_PASS = "qwer1234";
	
	private static Connection getConnection() throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}		
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}
	
	public static void query(String sql, ResultSetHandler handler) throws SQLException {
		try(Connection conn = getConnection()) {
			try(Statement stmt = conn.createStatement()){
				try(ResultSet rs = stmt.executeQuery(sql)){
					handler.handle(rs);
				}
			}
		}
	}
	
	public static int update(String sql) throws SQLException {
		try(Connection conn = getConnection()) {
			try(Statement stmt = conn.createStatement()){
				return stmt.executeUpdate(sql);
			}
		}
	}

	
}






