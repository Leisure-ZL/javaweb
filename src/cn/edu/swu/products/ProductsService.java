package cn.edu.swu.products;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.edu.swu.tool.DBTool;

public class ProductsService {

	public static int insertProduct(int sellerId,String name,String img,Float price,int count,String detail) throws SQLException {
		String sql = String.format(
			"insert into products(sellerId,name,img,price,count,dscp) "
			+ "values('%d','%s','%s','%f','%d','%s')",sellerId,name,img,price,count, detail);
		
		Connection conn = DBTool.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		return 1;
	}
	
}
