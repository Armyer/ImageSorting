package com.geowind.is.service;

import java.util.List;

import org.junit.Test;

import com.geowind.is.domain.Picture;
import com.geowind.is.service.serviceIml.InterestServiceImpl;

public class InterestServiceImplTest {

	@Test
	public void testSeacheImageByInterest() {

		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();

		String vid = "1";

		List<Picture> finalPicture = interestServiceImpl.searchImageByInterest(vid);

		for (int i = 0; i < finalPicture.size(); i++) {

			System.out.println(finalPicture.get(i).getLocation() + ", " + finalPicture.get(i).getPname());

		}

	}
	
	@Test
	public void testSeacheByImageByInterest2(){
		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();

		String vid = "2";

		List<Picture> finalPictureList = interestServiceImpl.searchImageByInterest(vid);

		if(finalPictureList.size()>0){
			System.out.println("查询到了");
			
			
		}else{
			System.out.println("查询不到");
		}
		
	}

}
