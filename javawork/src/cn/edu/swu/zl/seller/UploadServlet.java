package cn.edu.swu.zl.seller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mysql.cj.Session;

import cn.edu.swu.zl.goods.SellGoodsService;

public class UploadServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	 
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("ISO8859_1");
		List items = null;
		
		Map<String, String> params =new HashMap<String, String>();
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
		    FileItem item = (FileItem) iter.next();
		if (item.isFormField()) {  // 如果是表单域 ，就是非文件上传元素
			
			String name = new String(item.getFieldName().getBytes("ISO8859_1"),"UTF-8"); // 获取name属性的值
		    String value = new String(item.getString().getBytes("ISO8859_1"),"UTF-8"); // 获取value属性的值
		   params.put(name, value);
		}else {
			 //String fieldName = item.getFieldName(); // 文件域中name属性的值
			
			 String fileName = item.getName();
			  
			   // String contentType = item.getContentType(); // 文件的类型

				String suffix = fileName.substring(fileName.lastIndexOf('.'));
			    long size = item.getSize(); // 文件的大小，以字节为单位

				String newFileName = new Date().getTime() + suffix;
			   String uploadPath = req.getServletContext().getRealPath("./img/goods") + File.separator +newFileName ;
			   File saveFile = new File(uploadPath); // 定义一个file指向一个具体的文件
			try {
				
			    item.write(saveFile);// 把上传的内容写到一个文件中
			  } catch (Exception e) {
			    e.printStackTrace();
			  } 
		String name =params.get("productname");	
		float price =Float.parseFloat(params.get("price"));	
		int number =Integer.parseInt(params.get("number"));	
		String detail =params.get("detail");	
		HttpSession session = req.getSession();
		Seller seller = (Seller) session.getAttribute("seller");
		try {
		SellGoodsService.insert(seller.getId(),name,newFileName,price,number,detail);			
		resp.sendRedirect("/javawork/sell/sellerweb.jsp");
		} catch (SQLException e) {
			throw new IOException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
	
			}
		
		
	}
	
}
