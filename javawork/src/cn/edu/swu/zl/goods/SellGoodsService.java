package cn.edu.swu.zl.goods;

import java.util.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.edu.swu.zl.tools.DBTools;

public class SellGoodsService {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		add();
	}
	
	
	
	//从数据库获取全部sellgood表，逆序返回
	public static List<SellGoods> getAll(String sql) throws SQLException, ClassNotFoundException, IOException {
		
		List<SellGoods> sGoods = new ArrayList<SellGoods>();
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
	    while(rs.next()) {
	    	SellGoods sGood = new SellGoods();
	    	sGood.setId(rs.getInt("id"));
	    	sGood.setSellerId(rs.getInt("sellerId"));
	    	sGood.setName(rs.getString("name"));
	    	sGood.setImg(rs.getString("img"));
	    	sGood.setDscp(rs.getString("dscp"));
	    	sGood.setPrice(rs.getFloat("price"));
	    	sGood.setCount(rs.getInt("count"));
	    	sGoods.add(sGood);
	    }
	    Collections.reverse(sGoods);
	    return sGoods;    
	}
	//执行特定sql语句返回一个sGood对象
	public static SellGoods get(String sql) throws ClassNotFoundException, SQLException {
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		SellGoods sGood = new SellGoods();
		while(rs.next()) {
	    	sGood.setId(rs.getInt("id"));
	    	sGood.setSellerId(rs.getInt("sellerId"));
	    	sGood.setName(rs.getString("name"));
	    	sGood.setImg(rs.getString("img"));
	    	sGood.setDscp(rs.getString("dscp"));
	    	sGood.setPrice(rs.getInt("price"));
	    	sGood.setCount(rs.getInt("count"));
	    }
		return sGood;
	}
	
	//临时调用添加商品
	public static void add() throws ClassNotFoundException, SQLException, IOException {
		
		String sql = "INSERT INTO sellgoods(sellerId,name,img,dscp,price,count)VALUES"
				+ "(?,?,?,?,?,?);";
		
		String name = "纸巾3";
		String url = "mark-twogrid2.jpg";
		String desp = "水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片水果麦片";
		Float price = (float) 39.9;
		int count = 12;
		
		Connection conn = DBTools.getConnection();
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
	
	//添加商品
	public static int insert(int sellerId,String name,String img,Float price,int count,String detail) throws SQLException, ClassNotFoundException {
		String sql = String.format(
			"insert into sellgoods(sellerId,name,img,price,count,dscp) "
			+ "values('%d','%s','%s','%f','%d','%s')",sellerId,name,img,price,count, detail);
		Connection conn = DBTools.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		return 1;
	}
	
	public static int remove(String name,int sellerId) throws ClassNotFoundException, SQLException {
		String sql = "delete from sellgoods where name=? and sellerId=?";
		Connection conn = DBTools.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, name);
		ptmt.setInt(2, sellerId);
		ptmt.execute();
		return 1;
	}

	
	
	
}
