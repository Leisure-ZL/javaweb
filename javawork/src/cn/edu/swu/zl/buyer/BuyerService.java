package cn.edu.swu.zl.buyer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.swu.zl.seller.Seller;
import cn.edu.swu.zl.tools.DBTools;

public class BuyerService {
	
	public static Buyer toBuyer(Integer id,String name,String userName,String pass) {
		Buyer b = new Buyer();
		b.setId(id);
		b.setName(name);
		b.setPassword(pass);
		b.setUserName(userName);
		
		return b;
	}
	
public static Buyer get(String sql) throws ClassNotFoundException, SQLException{
		
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Buyer buyer = new Buyer();
		while(rs.next()) {
		    buyer.setId(rs.getInt("id"));
		    buyer.setName(rs.getString("name"));
		    buyer.setPassword(rs.getString("password"));
		    buyer.setUserName(rs.getString("userName"));
		}
	    return buyer;    
		
	}
	
}
