package com.geowind.is.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.geowind.is.domain.Picture;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class FileUploadUtil {
	public static String PATH="../uploads";//�ļ��ϴ���·��  ����Ŀ���� ����Ŀ����ʱ�������  /��ʾ��server����Ŀ��
	private static final String ALLOWED="gif,jpg,jpeg,png,doc,txt,xls,json";//�����ϴ��ļ�����
	private static final String DENIED="exe,bat,jsp,html,com";//�������ϴ����ļ�����
	private static final int SINGLEFILESIZE=10*1024*1024;//�����ļ�����С
	private static final int TOTALMAXSIZE=40*1024*1024;//ÿ���ϴ����ļ���С
	
	public Map<String,String> upload(PageContext pagecontent) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		//ʵ����һ��SmartUpload����
		SmartUpload su = new SmartUpload();//�ļ��ϴ�����ʹ��
		//��ʼ��SmartUpload
		su.initialize(pagecontent);
		//���ò���
		su.setAllowedFilesList(ALLOWED);
		su.setDeniedFilesList(DENIED);
		su.setMaxFileSize(SINGLEFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setCharset("utf-8");
		
		//��ʼ�ϴ�
		su.upload();
		//��ȡת���������
		Request request = su.getRequest();
		Enumeration<String> enums = request.getParameterNames();//ʹ�ü�����װ��ȡ������ͨ��Ԫ����
		
		//ѭ��ȡ��ÿһ����Ԫ�����Ѷ�һ��ֵ �嵽map��
		String name=null;
		while(enums.hasMoreElements()){
			name=enums.nextElement();
			map.put(name,request.getParameter(name));
		}
		
		//���ϴ��ļ��浽������·����
		Files files = su.getFiles();
		String path = null;//�ļ�����·��
		String fileName =null;//�ļ���
		String temp="";
		String filedName = null;
		
		if(files!=null && files.getCount()>0){//˵���û��ļ��Ѵ�����
			Collection<File> collection = files.getCollection();
			path=pagecontent.getServletContext().getRealPath("/") + PATH;
//			System.out.println(path);
			
			java.io.File f = new java.io.File(path);
			if(!f.exists()){
				f.mkdir();//�����������
			}
			
			for(File f1:collection){//ѭ��ȡ��ÿһ���ϴ��ļ�
				if(!f1.isMissing()){//�ļ�û�ж�ʧ
					filedName = f1.getFieldName();
					fileName = new Date().getTime()+"_"+new Random().nextInt(10000)+"."+f1.getFileExt();
//					System.out.println(fileName);
					//�������ݵ�ָ���ļ�
					f1.saveAs(path+"/"+fileName);
					
					if(!"".equals(temp)){
						temp+=",";
					}
					temp+=PATH+"/"+fileName;
				}
			}
			map.put(filedName, temp);
		}
//		System.out.println(map);
		return map;
	}
	
	
	
	public List<Picture> upload(ServletConfig servletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		List<Picture> pictureList = new ArrayList<>();
		Map<String,String> map = new HashMap<String, String>();
		//ʵ����һ��SmartUpload����
		SmartUpload su = new SmartUpload();//�ļ��ϴ�����ʹ��
		//��ʼ��SmartUpload
		
		su.initialize(servletConfig, httpServletRequest, httpServletResponse);
		//���ò���
		su.setAllowedFilesList(ALLOWED);
		su.setDeniedFilesList(DENIED);
		su.setMaxFileSize(SINGLEFILESIZE);
		su.setTotalMaxFileSize(TOTALMAXSIZE);
		su.setCharset("utf-8");
		
		//��ʼ�ϴ�
		su.upload();
		//��ȡת���������
		Request request = su.getRequest();
		Enumeration<String> enums = request.getParameterNames();//ʹ�ü�����װ��ȡ������ͨ��Ԫ����
		
		//ѭ��ȡ��ÿһ����Ԫ�����Ѷ�һ��ֵ �嵽map��
		String name=null;
		while(enums.hasMoreElements()){
			name=enums.nextElement();
			map.put(name,request.getParameter(name));
		}
		
		//���ϴ��ļ��浽������·����
		Files files = su.getFiles();
		String path = null;//�ļ�����·��
		String fileName =null;//�ļ���
		String temp="";
		String filedName = null;
		
		if(files!=null && files.getCount()>0){//˵���û��ļ��Ѵ�����
			Collection<File> collection = files.getCollection();
			path=servletConfig.getServletContext().getRealPath("/") + PATH;
//			System.out.println(path);
			
			java.io.File f = new java.io.File(path);
			if(!f.exists()){
				f.mkdir();//�����������
			}
			
			for(File f1:collection){//ѭ��ȡ��ÿһ���ϴ��ļ�
				if(!f1.isMissing()){//�ļ�û�ж�ʧ
					Picture picture = new Picture();
					
					filedName = f1.getFieldName();
					fileName = new Date().getTime()+"_"+new Random().nextInt(10000)+"."+f1.getFileExt();
					
					//�������ݵ�ָ���ļ�
					f1.saveAs(path+"/"+fileName);
					
					if(!"".equals(temp)){
						//temp+=",";
						temp = "";
					}
					temp+=PATH+"/"+fileName;
					
					//����ʱ��
					Date date = new Date();	
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
					picture.setDate(simpleDateFormat.format(date));
					picture.setValid(1);
					picture.setLocation(temp);
					picture.setPname(fileName);
					
					pictureList.add(picture);
				}
			}
			//map.put(filedName, temp);
		}
//		System.out.println(map);
		
		System.out.println(pictureList.size());
		return pictureList;
	}
	
	
	public Map<String,String> uploadFromForm(ServletConfig servletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		//ʵ����һ��SmartUpload����
		SmartUpload su = new SmartUpload();//�ļ��ϴ�����ʹ��
		//��ʼ��SmartUpload
		su.initialize(servletConfig, httpServletRequest, httpServletResponse);
		//���ò���
		su.setCharset("utf-8");
		
		//��ʼ�ϴ�
		su.upload();
		//��ȡת���������
		Request request = su.getRequest();
		Enumeration<String> enums = request.getParameterNames();//ʹ�ü�����װ��ȡ������ͨ��Ԫ����
		
		//ѭ��ȡ��ÿһ����Ԫ�����Ѷ�һ��ֵ �嵽map��
		String name=null;
		while(enums.hasMoreElements()){
			name=enums.nextElement();
			map.put(name,request.getParameter(name));
//			System.out.println(name);
		}
		
//		System.out.println(map);
		return map;
	}


}