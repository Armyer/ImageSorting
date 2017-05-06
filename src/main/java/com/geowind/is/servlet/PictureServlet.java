package com.geowind.is.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.geowind.is.domain.Picture;
import com.geowind.is.service.serviceIml.PictureServiceImpl;

public class PictureServlet extends HttpServlet {

	private static final long serialVersionUID = -7744625344830285257L;
	private ServletContext sc;
	private String savePath;

	public void init(ServletConfig config) {
		// ��web.xml�����õ�һ����ʼ������
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
		case "getImageOfRadmon":
			getImageOfRadmon(req,resp);
			break;
		default:
			break;

		}

	}
	
	/**
	 * ������ͼƬ��ַ
	 * @param req
	 * @param resp
	 */
	  private void getImageOfRadmon(HttpServletRequest req, HttpServletResponse resp) {
		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
		
		
	}


	/**
	 * �ϴ�ͼƬ��
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void uploadImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<Picture> pictureList = new ArrayList<>();
		try {
			List items = upload.parseRequest(req);
			Iterator itr = items.iterator();
			
			PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
			long result = pictureServiceImpl.upLoadImages(itr,sc.getRealPath("/")+savePath);
			
			if(result == 0){
				throw new Exception();
			}else{
				req.setAttribute("upload.message", "�ϴ��ļ��ɹ���");
			}
			
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("upload.message", "�ϴ��ļ�ʧ�ܣ�");
		}
		req.getRequestDispatcher("/uploadImageResult.jsp").forward(req, resp);
	}
	
	


}