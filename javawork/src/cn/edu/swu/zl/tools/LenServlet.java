package cn.edu.swu.zl.tools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.zl.goods.SellGoods;
import cn.edu.swu.zl.goods.SellGoodsService;

public class LenServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String goodsName = req.getParameter("goodsName");
		
		System.out.println(goodsName);
		
		String sql = "SELECT * FROM sellgoods WHERE name like '%" + goodsName.toString() + "%';"; 
		try {
			List<SellGoods> goods = SellGoodsService.getAll(sql);
			req.setAttribute("goodsNames", goods);
			req.getRequestDispatcher("divLen.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
