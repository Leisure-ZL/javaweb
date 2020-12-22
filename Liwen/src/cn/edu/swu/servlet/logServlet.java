package cn.edu.swu.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.swu.tool.DBTools;
import cn.edu.swu.tool.ResultSetHandler;
import cn.edu.swu.user.User;

public class logServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user = request.getParameter("userName");
		String pass = request.getParameter("userPassword");
		String role = request.getParameter("role");
	
		
			User u = new User();
			try {
				u=authenticate(role,user, pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			System.out.println("success2");
			if ( u.getRole()=="buyer") {
			    //response.sendRedirect("登陆成功后跳转buyer的页面");
				System.out.println("success3");
			} else if (u.getRole()=="seller") {
				//response.sendRedirect("登陆成功后跳转seller的页面");
				System.out.println("success4");
			}
			else {
				response.sendRedirect("/TMail-Log/skyCat/signIn.html");
			}
		
	}
	
    //用户登录（买家，商家）
	private User authenticate(String role, String name, String pass) throws SQLException {
		
		String sql = String.format(
			"select * from '%s' where userName='%s' and password=md5('%s')",
			role,name, pass
		);		
	    System.out.println(sql);
	    
	    User u1=new User();
	    ResultSet rs=DBTools.query(sql);
	    if(rs!=null)
	    {
	        u1.setRole(rs.getString(role));
	    }
	    return u1;

	
		//final List<User> users = new ArrayList<User>();	
		//bug
		/*DBTools.query(, new ResultSetHandler() {
			@Override
			public void handle(ResultSet ) throws SQLException {	
				System.out.println("success1");
				while(rs.next()) {
					System.out.println("success2");
					User u = new User();
					u.setUserName(rs.getString("userName"));		//将查询的结果放入user
					System.out.println("success3");
					u.setPassword(rs.getString("password"));
					users.add(u);
					System.out.println("name"+u.getName());
				}
			}	
			
	     });*/		
		
	}
		
}
















