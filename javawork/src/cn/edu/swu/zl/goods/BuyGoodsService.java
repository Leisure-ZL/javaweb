package cn.edu.swu.zl.goods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.edu.swu.zl.tools.DBTools;

public class BuyGoodsService {
	
	
		//添加bGood到数据库
		public static void add(BuyGoods bGood) throws ClassNotFoundException, SQLException, IOException {
			
			String sql = "INSERT INTO buygoods(sellerId,buyerId,name,img,dscp,price,count)VALUES"
					+ "(?,?,?,?,?,?,?);";
			Connection conn = DBTools.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bGood.getSellerId());
			pstmt.setInt(2, bGood.getbuyerId());
			pstmt.setString(3, bGood.getName());
			pstmt.setString(4, bGood.getImg());
			pstmt.setString(5, bGood.getDscp());
			pstmt.setFloat(6, bGood.getPrice());
			pstmt.setInt(7, bGood.getCount());
			pstmt.executeUpdate();
			conn.close();
			pstmt.close();
		}
		
		//通过从数据库获取全部bGood
		public static List<BuyGoods> getAll(String sql) throws SQLException, ClassNotFoundException, IOException {
			List<BuyGoods> bGoods = new ArrayList<BuyGoods>();
			Connection conn = DBTools.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
		    while(rs.next()) {
		    	BuyGoods bGood = new BuyGoods();
		    	bGood.setSellerId(rs.getInt("sellerId"));
		    	bGood.setbuyerId(rs.getInt("buyerId"));
		    	bGood.setName(rs.getString("name"));
		    	bGood.setImg(rs.getString("img"));
		    	bGood.setDscp(rs.getString("dscp"));
		    	bGood.setPrice(rs.getInt("price"));
		    	bGood.setCount(rs.getInt("count"));
		    	bGoods.add(bGood);
		    }
		    Collections.reverse(bGoods);
		    return bGoods;    
		}
		
		//通过name删除数据库一个bGood
		public static int remove(String name,int buyerId) throws ClassNotFoundException, SQLException {
			String sql = "delete from buygoods where name=? and buyerId=?";
			Connection conn = DBTools.getConnection();
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, name);
			ptmt.setInt(2, buyerId);
			ptmt.execute();
			return 1;
		}
		
		//传一个购买品，数据库对应商品数量--
		public static void decCount(BuyGoods bGood) throws ClassNotFoundException, SQLException {
			String sql = "update sellgoods set count=? where name=?";
			
			int count = bGood.getCount() - 1;
			
			Connection conn = DBTools.getConnection();
			PreparedStatement ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, count);
			ptmt.setString(2, bGood.getName());
			ptmt.execute();
			
		}
		
	
}
