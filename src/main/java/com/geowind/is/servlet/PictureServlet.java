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
		default:
			break;

		}

	}
	
	
	  /**
	  * ��ȡ8λ���ظ�����루ȡ��ǰʱ���ת��Ϊʮ�����ƣ�
	  * @author ShelWee
	  * @param time
	  * @return
	  */
	    public static String toHex(long time){    
	          return Integer.toHexString((int)time);
	   }

	

	/**
	 * �ϴ�ͼƬ
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
					System.out.println("��������:" + item.getFieldName() + "��������ֵ:" + item.getString("UTF-8"));
				}else {
					if (item.getName() != null && !item.getName().equals("")) {
						
						//ʱ���
						String timeName = toHex(new Date().getTime());
						
						item.setFieldName(timeName);
						
//						System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
//						System.out.println("�ϴ��ļ�������:" + item.getContentType());
//						System.out.println("�ϴ��ļ�������:" + item.getName());
//						System.out.println("�ϴ��ļ�������1:" + item.getFieldName());
						
						File tempFile = new File(item.getFieldName()+item.getName());
									
						String path = checkExist(sc.getRealPath("/")+savePath);	
						//�ϴ��ļ��ı���·��
						File file = new File(path, tempFile.getName());
						item.write(file);
					
						/*
						 * �������ݿ�ͼƬ����
						 */
						
						req.setAttribute("upload.message", "�ϴ��ļ��ɹ���");
					} else {
						req.setAttribute("upload.message", "û��ѡ���ϴ��ļ���");
					}
				}
			}
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("upload.message", "�ϴ��ļ�ʧ�ܣ�");
		}
		req.getRequestDispatcher("/uploadImageResult.jsp").forward(req, resp);
	}
	
	
	/**
	 * �ж��ļ�·���Ƿ����
	 */
	public static String checkExist(String filepath) throws Exception{
	       File file=new File(filepath);
	      
	       if (file.exists()) {
	    	   //�ж��ļ�Ŀ¼�Ĵ��� 
	           //System.out.println("�ļ��д��ڣ�");
	           
	       }else{
	    	   
	           //System.out.println("�ļ��в����ڣ�");
	                
	           File newFile=new File(file.getPath());          
	           newFile.mkdirs();
	           
	           //System.out.println("�����ļ��гɹ���");
	       }
	       
	      return file.getPath(); 
	      
	    }

}