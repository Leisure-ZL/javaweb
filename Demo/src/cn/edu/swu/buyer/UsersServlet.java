package cn.edu.swu.buyer;

import java.io.IOException;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.tool.DBTools;
import cn.edu.swu.tool.ResultSetHandler;
import cn.edu.swu.user.User;

@WebServlet("/admin/users")
public class UsersServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		this.doPost(request, response);
	}
	
	//查看所有的用户
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			List<User> users = this.getUsers();
			String userTable = this.toHtml(users);
			
			String html = "<html>\r\n" + 
					"<head>\r\n" + 
					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
					"<style type=\"text/css\">\r\n" + 
					".banner {\r\n" + 
					"	background-color:rgba(200, 200, 200, 0.5); \r\n" + 
					"	margin-top:1em;\r\n" + 
					"	padding:0.2em;\r\n" + 
					"	padding-left:1em;\r\n" + 
					"	letter-spacing:0.3em;\r\n" + 
					"}\r\n" + 
					".link {\r\n" + 
					"	display:inner-block;\r\n" + 
					"	padding-left:2em;\r\n" + 
					"}\r\n" + 
					"</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<div class=\"banner\">\r\n" + 
					"	<h2>西南大学网上书城 -- 管理后台</h2>\r\n" + 
					"</div>\r\n" + 
					"<div style=\"display:flex\">\r\n" + 
					"	<div class=\"link\"><a href=\"/demo/admin/users\">浏览用户</a></div>\r\n" + 
					"	<div class=\"link\"><a href=\"/demo/admin/adduser.html\">添加用户</a></div>\r\n" + 
					"</div><br><br>\r\n<center>" + 
					userTable +					
					"</center></body>\r\n" + 
					"</html>";			
			
			response.setCharacterEncoding("UTF-8");
			try(Writer writer = response.getWriter()) {
				writer.write(html);
				writer.flush();
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		
	}
	
	private List<User> getUsers() throws SQLException {
		String sql = "select * from user";		
		final List<User> users = new ArrayList<User>();	
		DBTools.query(sql, new ResultSetHandler() {
			@Override
			public void handle(ResultSet rs) throws SQLException {				
				while(rs.next()) {
					User u = new User();
					u.setId(rs.getInt("id"));
					u.setUser(rs.getString("user"));
					u.setName(rs.getString("name"));
					u.setPass(rs.getString("pass"));
					u.setRole(rs.getString("role"));					
					users.add(u);
				}
			}			
		});		
		return users;
	}
	
	private String toHtml(List<User> users) {
		StringBuilder sb = new StringBuilder();
		sb.append("<table style='broder:1' width='70%'>");		
		for(User user : users) {
			sb.append("<tr>");
			sb.append("<td>").append(user.getId()).append("</td>");
			sb.append("<td>").append(user.getUser()).append("</td>");
			sb.append("<td>").append(user.getName()).append("</td>");
			sb.append("<td>").append(user.getRole()).append("</td>");
			sb.append("</tr>");			
		}		
		sb.append("</table>");		
		return sb.toString();
	}
	
}







