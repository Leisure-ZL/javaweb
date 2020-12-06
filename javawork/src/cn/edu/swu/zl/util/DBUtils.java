package cn.edu.swu.zl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String JDBC_URL = "jdbc:mysql://localhost:3306/javawork?serverTimezone=UTC";
	private final static String JDBC_USER = "root";
	private final static String JDBC_PASSWORD = "ZLzhouliang0.";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	public static int setInfo(String sql) throws ClassNotFoundException, SQLException {
		try(Connection conn = getConnection()) {
			try(Statement stmt = conn.createStatement()){
				return stmt.executeUpdate(sql);
			}
		}
	}
	
	
	public static void getInfo(String sql,Handler handler) throws ClassNotFoundException, SQLException{
		
		try(Connection conn = getConnection()) {
			try(Statement stmt = conn.createStatement()){
				try(ResultSet rs = stmt.executeQuery(sql)){
					handler.handle(rs);
				}
			}
		}
	}
	
	
	
	
	
	
}
