package cn.edu.swu.buyer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runner.Request;

import cn.edu.swu.tool.DBTools;
import cn.edu.swu.tool.ResultSetHandler;
import cn.edu.swu.user.User;

@WebServlet("/login")
public class logServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("userName");
		String pass = request.getParameter("userPassword");
		String role = request.getParameter("role");
		
		try {
			User u = this.authenticate(role,user, pass);		
			if ( u.getRole()=="buyer") {
			    response.sendRedirect("登陆成功后跳转buyer的页面");
			} else if (u.getRole()=="seller") {
				response.sendRedirect("登陆成功后跳转seller的页面");
			}
			else {
				response.sendRedirect("登录页面");
			}
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
    //用户登录（买家，商家）
	private User authenticate(String role, String name, String pass) throws SQLException {
		
		String sql = String.format(
			"select * from '%s' where userName='%s' and password=md5('%s')",
			role,name, pass
		);		
	    System.out.println(sql);
	
		final List<User> users = new ArrayList<User>();	
		DBTools.query(sql, new ResultSetHandler() {
			@Override
			public void handle(ResultSet rs) throws SQLException {				
				while(rs.next()) {
					User u = new User();
					u.setUserName(rs.getString("userName"));		
					u.setPassword(rs.getString("password"));
					users.add(u);
				}
			}	
			
	     });		
	return users.size() > 0 ? users.get(0) : null;
	}
		
}
















