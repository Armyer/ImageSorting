package com.geowind.is.service;

import java.util.List;

import org.junit.Test;

import com.geowind.is.domain.ImageURL;
import com.geowind.is.domain.Picture;
import com.geowind.is.service.*;

public class InterestServiceImplTest {

	@Test
	public void testSeacheImageByInterest() {

		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();

		String vid = "1";
		
		String indexerPath = "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\index";

		List<ImageURL> finalPicture = interestServiceImpl.searchImageByInterest(vid,indexerPath);
		
		
		for (int i = 0; i < finalPicture.size(); i++) {

			System.out.println("imageURL:"+finalPicture.get(i).getImageUrl());

		}

	}
//	
//	@Test
//	public void testSeacheByImageByInterest2(){
//		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();
//
//		String vid = "2";
//
//		List<ImageURL> finalPictureList = interestServiceImpl.searchImageByInterest(vid);
//
//		if(finalPictureList.size()>0){
//			System.out.println("查询到了");
//			
//			
//		}else{
//			System.out.println("查询不到");
//		}
//		
//	}
	
//	@Test
//	public void testGetImageOfURL(){
//		
//		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();
//		
//		String url =  "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\uploads\\c941a17110487.jpg";
//		
//		url = url.substring(47);
//		System.out.println(url);
//		//System.out.println("url :"+interestServiceImpl.getNameOfURL(url));
//	}

}
