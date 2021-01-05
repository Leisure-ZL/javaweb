package cn.edu.swu.zl.goods;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.edu.swu.zl.tools.DBTools;

public class AllService {
	public static BuyGoods sGoodTobGood(SellGoods sGood,int buyerId) {
		BuyGoods bGood = new BuyGoods();
		
		bGood.setbuyerId(buyerId);
		bGood.setSellerId(sGood.getSellerId());
		bGood.setCount(sGood.getCount());
		bGood.setDscp(sGood.getDscp());
		bGood.setImg(sGood.getImg());
		bGood.setName(sGood.getName());
		bGood.setPrice(sGood.getPrice());
		
		return bGood;
	}
	
	public static void add(BuyGoods bGood) throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "INSERT INTO allgoods(sellerId,buyerId,name,img,dscp,price,count)VALUES"
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
	
	
}
