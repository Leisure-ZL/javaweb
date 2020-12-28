package cn.edu.swu.zl.buyer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swu.zl.goods.AllService;
import cn.edu.swu.zl.goods.BuyGoods;
import cn.edu.swu.zl.goods.BuyGoodsService;
import cn.edu.swu.zl.goods.SellGoods;

//取出商品加入buyGoods数据库
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Buyer buyer = (Buyer)session.getAttribute("buyer");
		
		if(buyer != null) {
			SellGoods sGood = (SellGoods)session.getAttribute("buyGood");
			BuyGoods bGood = AllService.sGoodTobGood(sGood, buyer.getId());
			try {
				BuyGoodsService.add(bGood);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				throw new IOException();
			}
			resp.sendRedirect("/javawork/index");
		}else {
			resp.sendRedirect("/javawork/buy/noLogin.html");
		}
			
		
		
	}		
}
