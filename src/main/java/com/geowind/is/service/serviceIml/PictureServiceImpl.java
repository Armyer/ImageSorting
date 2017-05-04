package com.geowind.is.service.serviceIml;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import com.geowind.is.dao.PictureDAO;
import com.geowind.is.dao.daoIml.PictureDAOImpl;
import com.geowind.is.domain.Picture;
import com.geowind.is.service.PictureService;

public class PictureServiceImpl implements PictureService {

	
	private ServletContext sc;
	private String savePath;

	public void init(ServletConfig config) {
		// ��web.xml�����õ�һ����ʼ������
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}
	
	
	PictureDAOImpl pictureDAOImpl = new PictureDAOImpl();
	
	/**
	 * �ϴ�ͼƬ����
	 */
	public long upLoadPictureList(List<Picture> pictureList) {
		
		long result = pictureDAOImpl.insertImages(pictureList);
		
		return result;
	}
	
	
	/**
	 * ������ͼƬ��������
	 * @return
	 */
	public HashSet<Picture> getImagesOfRadmon(){
		
		
		return null;
	}


	/**
	 * �ϴ�ͼƬ����
	 * @throws UnsupportedEncodingException 
	 */
	public long upLoadImages(Iterator<Picture> itr,String realpath)  {
		long result =0;
		List<Picture> pictureList = new ArrayList<>();
		try{
		while (itr.hasNext()) {
			
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
				System.out.println("��������:" + item.getFieldName() + "��������ֵ:" + item.getString("UTF-8"));
			}else {
				if (item.getName() != null && !item.getName().equals("")) {
					
					//ʱ���
					String timeName = toHex(new Date().getTime());
					
					item.setFieldName(timeName);
					
//					System.out.println("�ϴ��ļ��Ĵ�С:" + item.getSize());
//					System.out.println("�ϴ��ļ�������:" + item.getContentType());
//					System.out.println("�ϴ��ļ�������:" + item.getName());
//					System.out.println("�ϴ��ļ�������1:" + item.getFieldName());
					
					File tempFile = new File(item.getFieldName()+getRandomNum()+getSuffixOfImage(item.getName()));
								
					String path = checkExist(realpath);	
					//�ϴ��ļ��ı���·��
					File file = new File(path, tempFile.getName());
					item.write(file);
				
					/*
					 * �������ݿ�ͼƬ����
					 */
					Picture picture = new Picture();
					picture.setPname(tempFile.getName());
					picture.setLocation(path);
					picture.setValid(1);
					pictureList.add(picture);
					
					
				}
			}
		}
		
		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
		result = pictureServiceImpl.upLoadPictureList(pictureList);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
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
	     * ���ͼƬ��׺
	     * @param pictureName
	     * @return
	     */
	    public String getSuffixOfImage(String pictureName){
	    	
	    	
			String a = "\\.(jpg|jpeg|bmp|png|gif|JPG|JPEG|BMP|PNG|GIF)$";
			Pattern p = Pattern.compile(a);
			Matcher m = p.matcher(pictureName);
			String result = "";
			int i = 0 ;
			while(m.find()){
				
				result = m.group(i);	
				i++;
			}
	    	return result;
	    	
	    }
	    
	    /**
	     * ���100000���ڵ������
	     * @return
	     */
	    public String getRandomNum(){
	    	Random random = new Random(1000);//ָ����������
	    	int i = random.nextInt(100000);
	    	String result = String.valueOf(i);
	    	return result;
	    	
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
