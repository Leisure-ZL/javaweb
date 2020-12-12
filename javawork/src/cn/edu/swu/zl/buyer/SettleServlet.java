package cn.edu.swu.zl.buyer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.zl.goods.BuyGoods;
import cn.edu.swu.zl.goods.BuyGoodsService;

public class SettleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//String userId = req.getParameter("userId");
		String name = "";
		try {
			List<BuyGoods> bGoods = BuyGoodsService.getAllById(1);
			
			for(BuyGoods e:bGoods) {
				name = e.getName();
				BuyGoodsService.remove(name, 1);
				}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new IOException();
		}
		resp.sendRedirect("/javawork/buy/pay.html");
		
	}
	
}
