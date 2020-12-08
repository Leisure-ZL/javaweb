package cn.edu.swu.zl.buyer;

import java.io.IOException;
import java.sql.SQLException;

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
		SellGoods sGood = (SellGoods)session.getAttribute("searchSGood");
		BuyGoods bGood = AllService.sGoodTobGood(sGood, 1);//默认(用户id)
		try {
			BuyGoodsService.add(bGood);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new IOException();
		}
		resp.sendRedirect("/javawork/index");
	}
}
