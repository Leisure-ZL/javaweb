package cn.edu.swu.zl.buyer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.zl.goods.BuyGoodsService;

public class RemoveServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		
		System.out.println(name);
		try {
			BuyGoodsService.remove(name, 1);
		} catch (ClassNotFoundException | SQLException e) {
			throw new IOException();
		}
		resp.sendRedirect("/javawork/buy/cart.jsp");
	}
	
}
