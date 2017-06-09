package com.geowind.is.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.geowind.is.dao.daoIml.InterestDAOImpl;
import com.geowind.is.domain.ImageURL;
import com.geowind.is.domain.Picture;
import com.geowind.is.utils.Searcher;

public class InterestServiceImpl  {
	/**
	 * ������Ȥ��ͼ��ͼ
	 */
	public List<ImageURL> searchImageByInterest(String vid,String indexPath) {

		
		InterestDAOImpl interestDAOImpl = new InterestDAOImpl();
		
		//��ѯ־Ը������ȷ���ı�ǩ������������ͼƬ
		List<Picture> pictureList = interestDAOImpl.queryImageByInterest(vid);
		
		
		//��ͼ��ͼ���õ�ͼƬ
		List<Picture> finalPictureList = new ArrayList<>();
		
		List<ImageURL> imageUrlList = new ArrayList<>();
		
		if(pictureList.size()>0){
			
			Searcher searcher = new Searcher();

			try {
				
				System.out.println("PATH:"+pictureList.get(0).getLocation()+"\\"+pictureList.get(0).getPname());
				 finalPictureList = searcher.searcherByPic(pictureList.get(0).getLocation()+"\\"+pictureList.get(0).getPname(),indexPath);
				 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//System.out.println("fianlList:"+finalPictureList.size());

		for(int i = 0;i< 12;i++){
			
			
			ImageURL imageURL = new ImageURL();
			
			String url = "http://192.168.0.116:8080/uploads/"+getNameOfURL(finalPictureList.get(i).getLocation());
			
			imageURL.setImageUrl(url);
			//imageURL.setPid(finalPictureList.get(i).getPid());
			
			imageUrlList.add(imageURL);
			
		}
		
		
		
		return imageUrlList;
	}

	
	
	/**
	 * ����URL���ͼƬ����
	 * @param url
	 * @return
	 */
	public String getNameOfURL(String url){
		
//		String result = url.substring(47);
		
		Pattern pattern = Pattern.compile("(\\w{11}.*?(jpg|gif|png|bmp|JPG|GIF|PNG|BMP))");
		String s = "../uploads/1494853239609_115.jpg";
		Matcher matcher = pattern.matcher(s);
		String result = "";
		if(matcher.find()){
			result=matcher.group();
		}

		return result;
		
		
	}
	
	
}
