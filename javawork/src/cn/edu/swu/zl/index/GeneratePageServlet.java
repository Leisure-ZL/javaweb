package cn.edu.swu.zl.index;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;

public class GeneratePageServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		this.doPost(request, response);
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");	
			
		System.out.println("1");
		response.sendRedirect("/javawork/index/index.jsp"); 
		
	}
	
}
