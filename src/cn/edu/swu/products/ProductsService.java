package cn.edu.swu.products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.sql.PreparedStatement;
import cn.edu.swu.tool.DBTool;

public class ProductsService {

	public static int insertProduct(int sellerId,String name,String img,Float price,int count,String detail) throws SQLException, ClassNotFoundException {
		String sql = String.format(
			"insert into products(sellerId,name,img,price,count,dscp) "
			+ "values('%d','%s','%s','%f','%d','%s')",sellerId,name,img,price,count, detail);
		
		Connection conn = DBTool.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		return 1;
	}
	
	public  static List<Products> getAll() throws SQLException, ClassNotFoundException{
		String sql = "select * from products;";
		Connection conn = DBTool.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Products> products = new ArrayList<Products>();
	    while(rs.next()) {
	    	Products product = new Products();
	    	product.setId(rs.getInt("id"));
	    	product.setProductname(rs.getString("name"));
	    	product.setImgUrl(rs.getString("img"));
	    	product.setDetail(rs.getString("dscp"));
	    	product.setPrice(rs.getFloat("price"));
	    	product.setNumber(rs.getInt("count"));
	    	products.add(product);
	    }
	    Collections.reverse(products);
	    return products;    
	}

		public static int remove(String name,int id) throws ClassNotFoundException, SQLException {
			String sql = "delete from products where name=? and id=?";
			Connection conn = DBTool.getConnection();
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setInt(2, id);
			ptmt.execute();
			return 1;
		}
		
	
}
