package cn.edu.swu.zl.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");//字符集设置
		
		String name=req.getParameter("name");//表单传入参数
		String userName = req.getParameter("userName");
		String password = req.getParameter("userPassword");
		String role = req.getParameter("role");
		Auth a = new Auth();
	
			try {
				if(a.insertUser(role,name,userName, password) !=0 ){		
				resp.sendRedirect("/javawork/login/toLogin.html");
				//注册成功后跳转到登录页面
				}
				else {
					System.out.println("fail to insert a user");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
	}
	
}
