package cn.edu.swu.zl.goods;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.management.loading.PrivateClassLoader;

import com.mysql.cj.exceptions.UnsupportedConnectionStringException;

import cn.edu.swu.zl.util.DBUtils;

public class SellGoodsService {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
	}
	
	//添加sellgood到数据库
	public static void add() throws ClassNotFoundException, SQLException, IOException {
		
		String path = "C:\\Users\\86182\\Desktop\\javawork\\index\\img\\mark\\4.jpg";
		String sql = "INSERT INTO sellGoods(sellerId,name,imgUrl,dscp,price,count)VALUES"
				+ "(?,?,?,?,?,?);";
		Connection conn = DBUtils.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, 2);
		pstmt.setString(2, "ddd");
		pstmt.setString(3, path);
		pstmt.setString(4, "abcdef");
		pstmt.setFloat(5, (float) 39.9);
		pstmt.setInt(6, 10);
		pstmt.executeUpdate();
		conn.close();
		pstmt.close();
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
	
}
