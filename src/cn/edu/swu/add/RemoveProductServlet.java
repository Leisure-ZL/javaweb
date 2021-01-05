package cn.edu.swu.add;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swu.products.Products;
import cn.edu.swu.products.ProductsService;

public class RemoveProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			ProductsService.remove(name, id);
		} catch (ClassNotFoundException | SQLException e) {
			throw new IOException();
		}
		resp.sendRedirect("/seller/sellerweb.jsp");
	}
}
