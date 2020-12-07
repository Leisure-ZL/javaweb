package cn.edu.swu.zl.index;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import cn.edu.swu.zl.goods.SellGoods;
import cn.edu.swu.zl.goods.SellGoodsService;

public class SearchServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String content = req.getParameter("search");
		String sql = "SELECT * FROM sellGoods WHERE name like '%" + content.toString() + "%';"; 
		SellGoods sGood;
		try {
			sGood = SellGoodsService.get(sql);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("SQLError");
			throw new IOException();
		}
		
		HttpSession session = req.getSession(true);
		session.setAttribute("searchSGood",sGood);
		resp.sendRedirect("/javawork/buy-page/buy.jsp");
		
	}
	
	
}
