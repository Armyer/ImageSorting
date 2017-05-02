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
		// 在web.xml中设置的一个初始化参数
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}
	
	
	PictureDAOImpl pictureDAOImpl = new PictureDAOImpl();
	
	/**
	 * 上传图片集合
	 */
	public long upLoadPictureList(List<Picture> pictureList) {
		
		long result = pictureDAOImpl.insertImages(pictureList);
		
		return result;
	}
	
	
	/**
	 * 获得随机图片进行推送
	 * @return
	 */
	public HashSet<Picture> getImagesOfRadmon(){
		
		
		return null;
	}


	/**
	 * 上传图片集合
	 * @throws UnsupportedEncodingException 
	 */
	public long upLoadImages(Iterator<Picture> itr,String realpath)  {
		long result =0;
		List<Picture> pictureList = new ArrayList<>();
		try{
		while (itr.hasNext()) {
			
			FileItem item = (FileItem) itr.next();
			if (item.isFormField()) {
				System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
			}else {
				if (item.getName() != null && !item.getName().equals("")) {
					
					//时间戳
					String timeName = toHex(new Date().getTime());
					
					item.setFieldName(timeName);
					
//					System.out.println("上传文件的大小:" + item.getSize());
//					System.out.println("上传文件的类型:" + item.getContentType());
//					System.out.println("上传文件的名称:" + item.getName());
//					System.out.println("上传文件的名称1:" + item.getFieldName());
					
					File tempFile = new File(item.getFieldName()+getRandomNum()+getSuffixOfImage(item.getName()));
								
					String path = checkExist(realpath);	
					//上传文件的保存路径
					File file = new File(path, tempFile.getName());
					item.write(file);
				
					/*
					 * 插入数据库图片数据
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
	  * 获取8位不重复随机码（取当前时间戳转化为十六进制）
	  * @author ShelWee
	  * @param time
	  * @return
	  */
	    public static String toHex(long time){    
	          return Integer.toHexString((int)time);
	   }

	
	    /**
	     * 获得图片后缀
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
	     * 获得100000以内的随机数
	     * @return
	     */
	    public String getRandomNum(){
	    	Random random = new Random(1000);//指定种子数字
	    	int i = random.nextInt(100000);
	    	String result = String.valueOf(i);
	    	return result;
	    	
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
