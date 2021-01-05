package cn.edu.swu.zl.seller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.swu.zl.goods.BuyGoods;
import cn.edu.swu.zl.tools.DBTools;

public class SellerService {

	public static List<Seller> getAll(String sql) throws ClassNotFoundException, SQLException{
		
		List<Seller> sellers = new ArrayList<Seller>();
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
	    while(rs.next()) {
	    	Seller seller = new Seller();
	    	seller.setId(rs.getInt("id"));
	    	seller.setName(rs.getString("name"));
	    	seller.setPassword(rs.getString("password"));
	    	seller.setUserName(rs.getString("userName"));
	    	sellers.add(seller);
	    }
	    return sellers;    
		
	}
	
public static Seller get(String sql) throws ClassNotFoundException, SQLException{
		
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Seller seller = new Seller();
		while(rs.next()) {
		    seller.setId(rs.getInt("id"));
		    seller.setName(rs.getString("name"));
		    seller.setPassword(rs.getString("password"));
		    seller.setUserName(rs.getString("userName"));
		}
	    return seller;    
		
	}
	
	
}
