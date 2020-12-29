package cn.edu.swu.zl.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools {
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
	
	//更新
		public static int update(String sql) throws SQLException {
			try(Connection conn = getConnection()) {
				try(Statement stmt = conn.createStatement()){
					return stmt.executeUpdate(sql);//返回的是更新的条数
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return 0;
		}

		
		
}
	
	
	
	
	
	
