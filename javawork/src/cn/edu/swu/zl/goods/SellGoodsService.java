package cn.edu.swu.zl.goods;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.edu.swu.zl.util.DBUtils;

public class SellGoodsService {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		add();
	}
	
	
	
	//从数据库获取全部sellgood表，逆序返回
	public static List<SellGoods> getAll() throws SQLException, ClassNotFoundException, IOException {
		String sql = "select * from sellgoods;";
		List<SellGoods> sGoods = new ArrayList<SellGoods>();
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
	    while(rs.next()) {
	    	SellGoods sGood = new SellGoods();
	    	sGood.setId(rs.getInt("id"));
	    	sGood.setSellerId(rs.getInt("sellerId"));
	    	sGood.setName(rs.getString("name"));
	    	sGood.setImgUrl(rs.getString("imgUrl"));
	    	sGood.setDscp(rs.getString("dscp"));
	    	sGood.setPrice(rs.getInt("price"));
	    	sGood.setCount(rs.getInt("count"));
	    	sGoods.add(sGood);
	    }
	    Collections.reverse(sGoods);
	    return sGoods;    
	}
	//执行特定sql语句返回一个sGood对象
	public static SellGoods get(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtils.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		SellGoods sGood = new SellGoods();
		while(rs.next()) {
	    	sGood.setId(rs.getInt("id"));
	    	sGood.setSellerId(rs.getInt("sellerId"));
	    	sGood.setName(rs.getString("name"));
	    	sGood.setImgUrl(rs.getString("imgUrl"));
	    	sGood.setDscp(rs.getString("dscp"));
	    	sGood.setPrice(rs.getInt("price"));
	    	sGood.setCount(rs.getInt("count"));
	    }
		return sGood;
	}
	
	//临时调用添加商品
	public static void add() throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "INSERT INTO sellGoods(sellerId,name,imgUrl,dscp,price,count)VALUES"
				+ "(?,?,?,?,?,?);";
		
		String name = "纸巾";
		String url = "../img/goods/6.jpg";
		String desp = "纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾纸巾";
		Float price = (float) 39.9;
		int count = 10;
		
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setString(2, name);
		pstmt.setString(3, url);
		pstmt.setString(4, desp);
		pstmt.setFloat(5, price);
		pstmt.setInt(6, count);
		pstmt.executeUpdate();
		System.out.println("已加入");
		conn.close();
		pstmt.close();
	}
	
	
}
