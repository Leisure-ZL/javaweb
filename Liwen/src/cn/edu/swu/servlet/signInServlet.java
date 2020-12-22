package cn.edu.swu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.swu.tool.DBTools;

//注册
public class signInServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");//字符集设置
		
		String name=request.getParameter("name");//表单传入参数
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String role = request.getParameter("role");
	

		
			try {
				if(this.insertUser(role,name,userName, userPassword)!=0){		
				response.sendRedirect("/TMail_Log/skyCat/loadPage.html");
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
	private int insertUser(String role,String name,String userName, String userPassword) throws SQLException {
		String sql = String.format(
		"INSERT INTO %s(name,userName,password)"
				+"VALUES('%s','%s',md5('%s'))",role,name,userName,userPassword);
		
		System.out.println(sql);
		
		return DBTools.update(sql);
	}
}





