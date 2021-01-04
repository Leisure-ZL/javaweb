package cn.edu.swu.zl.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import cn.edu.swu.zl.buyer.Buyer;
import cn.edu.swu.zl.seller.Seller;
import cn.edu.swu.zl.tools.DBTools;

public class Auth {

	public int auth(String role, String name, String pass) throws SQLException, ClassNotFoundException {
		if(role.equals("buyer")) {
			return queryBuyer(name, pass).getId();
		}
		if(role.equals("seller")) {
			return querySeller(name, pass).getId();
		}
		return -1;
		   
	}

	 public Buyer queryBuyer(String name, String pass) throws ClassNotFoundException, SQLException {
		String sql = String.format(
				"select * from buyer where userName='%s' and password='%s'",
				name, pass
			);		
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Buyer buyer = new Buyer();
		if(rs.next()) {
			buyer.setId(rs.getInt("id"));
			buyer.setName(rs.getString("name"));
			buyer.setPassword(rs.getString("password"));
			buyer.setUserName(rs.getString("userName"));
			return buyer;
		}else {
			buyer.setId(-1);
			return buyer;
		}
	}
	 
	 public Seller querySeller(String name, String pass) throws ClassNotFoundException, SQLException {
			String sql = String.format(
					"select * from seller where userName='%s' and password='%s'",
					name, pass
				);		
			Connection conn = DBTools.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Seller seller = new Seller();
			if(rs.next()) {
				seller.setId(rs.getInt("id"));
				seller.setName(rs.getString("name"));
				seller.setPassword(rs.getString("password"));
				seller.setUserName(rs.getString("userName"));
				return seller;
			}else {
				seller.setId(-1);
				return seller;
			}
		}
	 
	 
	 public int insertUser(String role,String name,String userName, String userPassword) throws SQLException {
			String sql = String.format(
			"INSERT INTO %s(name,userName,password)"
					+"VALUES('%s','%s','%s')",role,name,userName,userPassword);
			return DBTools.update(sql);
		}
	 
	 public int signOutAuth(String name, String role) throws ClassNotFoundException, SQLException {
		 String sql = String.format(
					"select * from %s where userName='%s'",
					role,name
				);		
		 Connection conn = DBTools.getConnection();
		 Statement stmt = conn.createStatement();
		 ResultSet rs = stmt.executeQuery(sql);
		 if(!rs.next()) {
			 return 1;
		 }else {
			 return 0;
		 }
	 }
		 
		 
	
}
