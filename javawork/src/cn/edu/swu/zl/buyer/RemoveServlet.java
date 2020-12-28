package cn.edu.swu.zl.buyer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.cj.Session;

import cn.edu.swu.zl.goods.BuyGoodsService;
import cn.edu.swu.zl.goods.SellGoods;

public class RemoveServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		Buyer buyer = (Buyer)session.getAttribute("buyer");
		System.out.println(buyer.getId());
		try {
			BuyGoodsService.remove(name, buyer.getId());
		} catch (ClassNotFoundException | SQLException e) {
			throw new IOException();
		}
		resp.sendRedirect("/javawork/buy/cart.jsp");
	}
	
}
