package com.geowind.is.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.geowind.is.utils.FileUploadUtil;
import com.geowind.is.domain.Picture;
import com.geowind.is.service.*;

public class PictureServlet extends BasicServlet {

	private static final long serialVersionUID = -7744625344830285257L;
	
	private static long fileSizeMax = 1024*1024*5;	
	private static long sizeMax = 1024 * 1024 *100;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String method = request.getParameter("method");

		switch (method) {

		case "uploadImage":
			uploadImage(request, response);
			break;
		case "getImageOfRadmon":
			getImageOfRadmon(request,response);
			break;
		case "pushImagesByImage":
			pushImagesByImage(request,response);
			break;
		case "uploadImages":
			uploadImages(request,response);
			break;
		default:
			break;

		}

	}
	
	
	
	/**
	 * 上传图片集合测试
	 * @param req
	 * @param resp
	 */
	private void uploadImages(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		ServletConfig servletConfig = this.getServletConfig();
		
		//System.out.println("aa"+servletConfig.getInitParameter("uploadPath"));
		FileUploadUtil uploadUtil = new FileUploadUtil();
		Map<String, String> map = null;
		try {
			List<Picture> pictureList =  uploadUtil.upload(servletConfig, request, response);
//			for(int i= 0 ;i<pictureList.size();i++){
//				System.out.println("location:"+pictureList.get(i).getLocation()+","+pictureList.get(i).getDate());
//			}

			PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
			long result = pictureServiceImpl.upLoadPictureList(pictureList);
			if(result == 0){
				this.out(response, "0");
				//throw new Exception();
			}else{
				response.sendRedirect("pictureIndex.jsp");
				//this.out(response, "<script>alert(\"上传成功!\");</script>");
				//request.getRequestDispatcher("pictureIndex.jsp").forward(request, response);
				//this.out(response, "1");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据兴趣以图搜图
	 * @param req
	 * @param resp
	 */
	private void pushImagesByImage(HttpServletRequest req, HttpServletResponse resp) {

		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
		
		
	}

	/**
	 * 第一次推送随机图片
	 * 获得随机图片地址
	 * @param req
	 * @param resp
	 */
	  private void getImageOfRadmon(HttpServletRequest requset, HttpServletResponse response) {
		
		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
		
		List<Picture> pictureList = pictureServiceImpl.pushImagesOfRandom();
		
		try {
			this.out(response, pictureList);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}


	/**
	 * 上传图片集
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void uploadImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
	
		upload.setFileSizeMax(fileSizeMax);

		upload.setSizeMax(sizeMax);
		
		//List<Picture> pictureList = new ArrayList<>();
		try {
			List items = upload.parseRequest(req);
			Iterator itr = items.iterator();
			
			PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
			long result = pictureServiceImpl.upLoadImages(itr,servletConfig.getServletContext().getRealPath("/")+servletConfig.getInitParameter("savePath"));
			
			if(result == 0){
				throw new Exception();
			}else{
				req.setAttribute("upload.message", "上传文件成功！");
			}
			
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("upload.message", "上传文件失败！");
		}
		req.getRequestDispatcher("/uploadImageResult.jsp").forward(req, resp);
	}
	
	


}