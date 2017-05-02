package com.geowind.is.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class PictureServlet extends HttpServlet {

	private static final long serialVersionUID = -7744625344830285257L;
	private ServletContext sc;
	private String savePath;

	public void init(ServletConfig config) {
		// 在web.xml中设置的一个初始化参数
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String op = req.getParameter("op");

		switch (op) {

		case "uploadImage":
			uploadImage(req, resp);
			break;
		default:
			break;

		}

	}
	
	
	  /**
	  * 获取8位不重复随机码（取当前时间戳转化为十六进制）
	  * @author ShelWee
	  * @param time
	  * @return
	  */
	    public static String toHex(long time){    
	          return Integer.toHexString((int)time);
	   }

	

	/**
	 * 上传图片
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void uploadImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(req);
			Iterator itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
				}else {
					if (item.getName() != null && !item.getName().equals("")) {
						
						//时间戳
						String timeName = toHex(new Date().getTime());
						
						item.setFieldName(timeName);
						
//						System.out.println("上传文件的大小:" + item.getSize());
//						System.out.println("上传文件的类型:" + item.getContentType());
//						System.out.println("上传文件的名称:" + item.getName());
//						System.out.println("上传文件的名称1:" + item.getFieldName());
						
						File tempFile = new File(item.getFieldName()+item.getName());
									
						String path = checkExist(sc.getRealPath("/")+savePath);	
						//上传文件的保存路径
						File file = new File(path, tempFile.getName());
						item.write(file);
					
						/*
						 * 插入数据库图片数据
						 */
						
						req.setAttribute("upload.message", "上传文件成功！");
					} else {
						req.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
			}
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("upload.message", "上传文件失败！");
		}
		req.getRequestDispatcher("/uploadImageResult.jsp").forward(req, resp);
	}
	
	
	/**
	 * 判断文件路径是否存在
	 */
	public static String checkExist(String filepath) throws Exception{
	       File file=new File(filepath);
	      
	       if (file.exists()) {
	    	   //判断文件目录的存在 
	           //System.out.println("文件夹存在！");
	           
	       }else{
	    	   
	           //System.out.println("文件夹不存在！");
	                
	           File newFile=new File(file.getPath());          
	           newFile.mkdirs();
	           
	           //System.out.println("创建文件夹成功！");
	       }
	       
	      return file.getPath(); 
	      
	    }

}