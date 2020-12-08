package cn.edu.swu.buyer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.conf.DatabaseUrlContainer;

import cn.edu.swu.tool.DBTools;

//注册
@WebServlet("/admin/adduser")
public class signInServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");//字符集设置
		
		String name=request.getParameter("name");//表单传入参数
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
	
//		前端验证

		try {
			this.insertUser(name,userName, userPassword);			
			response.sendRedirect("登陆成功后跳转的页面");
		} catch (SQLException e) {
			throw new IOException(e);
		}
		
	

	//插入操作
	private int insertUser(String name,String userName, String userPassword) throws SQLException {
		String sql = String.format(
//			"insert into user(user, pass, name, role) "
//			+ "values('%s', md5('%s'), '%s', '%s')", user, pass, name, role);
		"INSERT INTO buyer(name,userName,password)"
				+"VALUES('%s','%s',md5('%s'))",name,userName,userPassword);
		
		System.out.println(sql);
		
		return DBTools.update(sql);
	}
}





