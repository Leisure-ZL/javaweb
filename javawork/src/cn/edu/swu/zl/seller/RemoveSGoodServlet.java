package cn.edu.swu.zl.seller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swu.zl.buyer.Buyer;
import cn.edu.swu.zl.goods.BuyGoodsService;
import cn.edu.swu.zl.goods.SellGoodsService;

public class RemoveSGoodServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		Seller seller = (Seller)session.getAttribute("seller");
		try {
			SellGoodsService.remove(name, seller.getId());
		} catch (ClassNotFoundException | SQLException e) {
			throw new IOException();
		}
		resp.sendRedirect("/javawork/sell/sellerweb.jsp");
	}
		
	}
	
	

