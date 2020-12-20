package cn.edu.swu.add;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.swu.products.ProductsService;


public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "upload";
	 
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		List items = null;
		
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
		    FileItem item = (FileItem) iter.next();
		if (item.isFormField()) {  // 如果是表单域 ，就是非文件上传元素
			
			String name = item.getFieldName(); // 获取name属性的值
		    String value = item.getString(); // 获取value属性的值
			System.out.println(name);
			System.out.println(value);
//			String name = request.getParameter("productname");
//			float price = Float.parseFloat(request.getParameter("price"));
//			String numString = request.getParameter("number");
//			System.out.println(numString);
//			int  number = Integer.parseInt(numString);
//			String detail = request.getParameter("detail");
		}else {
	
			
			 String fieldName = item.getFieldName(); // 文件域中name属性的值
			    String fileName = item.getName(); // 文件的全路径，绝对路径名加文件名
			    String contentType = item.getContentType(); // 文件的类型
			    long size = item.getSize(); // 文件的大小，以字节为单位
			 //   String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
			    File saveFile = new File("../upload/test1.jpg"); // 定义一个file指向一个具体的文件
			try {
				
			    item.write(saveFile);// 把上传的内容写到一个文件中
			  } catch (Exception e) {
			    e.printStackTrace();
			  } 
		
//	        if (!ServletFileUpload.isMultipartContent(request)) {
//	            PrintWriter writer = response.getWriter();
//	            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
//	            writer.flush();
//	            return;
//	        }
//	     //   DiskFileItemFactory factory = new DiskFileItemFactory();
//	        factory.setSizeThreshold(MEMORY_THRESHOLD);
//	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
//	 
//	    //    ServletFileUpload upload = new ServletFileUpload(factory);
//	        upload.setFileSizeMax(MAX_FILE_SIZE);
//	        upload.setSizeMax(MAX_REQUEST_SIZE);
//	        upload.setHeaderEncoding("UTF-8"); 
//	        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
//	       
//	        File uploadDir = new File(uploadPath);
//	        if (!uploadDir.exists()) {
//	            uploadDir.mkdir();
//	        }
//	 
//	        try {
//	            List<FileItem> formItems = upload.parseRequest(request);
//	 
//	            if (formItems != null && formItems.size() > 0) {
//	                // 迭代表单数据
//	                for (FileItem item1 : formItems) {
//	                    // 处理不在表单中的字段
//	                    if (!item.isFormField()) {
//	                        String fileName = new File(item1.getName()).getName();
//	                        String filePath = uploadPath + File.separator + fileName;
//	                        File storeFile = new File(filePath);
//	                        // 在控制台输出文件的上传路径
//	                        System.out.println(filePath);
//	                        // 保存文件到硬盘
//	                        item1.write(storeFile);
//	                    }
//	                }
//	            }	         
//	        } catch (Exception ex) {
//	            throw new IOException(ex);
//	        }
//	    		
//	//	try {
//	//		ProductsService.insertProduct(1,name,uploadPath,price,number,detail);			
//		//	response.sendRedirect("/seller/sellerweb.html");
//		//} catch (SQLException e) {
//		//	throw new IOException(e);
//		//}
//	}
//	}
	
	}}}
		}
