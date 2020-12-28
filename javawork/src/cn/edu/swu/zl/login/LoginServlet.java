package cn.edu.swu.zl.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.swu.zl.buyer.Buyer;
import cn.edu.swu.zl.seller.Seller;


public class LoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("userName");
		String pass = req.getParameter("userPassword");
		String role = req.getParameter("role");
		Auth auth = new Auth();
		
		try {
			if (role.equals("buyer") && auth.auth(role,name,pass) != 0) {
				Buyer buyer = auth.queryBuyer(name, pass);//通过传入的参数查询数据库，返回数据库buyer对象
				HttpSession session = req.getSession(true);
				session.setAttribute("buyer", buyer);
				resp.sendRedirect("/javawork/index/index.jsp");
			}else {
				Seller seller = auth.querySeller(name, pass);//通过传入的参数查询数据库，返回数据库seller对象
				HttpSession session = req.getSession(true);
				session.setAttribute("seller", seller);
				resp.sendRedirect("/javawork/index/index.jsp");
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		
		
	}
}
