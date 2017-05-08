package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.dao.daoIml.InterestDAOImpl;
import com.geowind.is.domain.Picture;

public class InterestDAOImplTest {
	
	@org.junit.Test
	public void testQueryImageByInterest(){
		
		InterestDAOImpl interestDAOImpl = new InterestDAOImpl();
		
		
		String vid = "1";
		List<Picture> pictureList = interestDAOImpl.queryImageByInterest(vid);
		for(int i =0;i<pictureList.size();i++){
			
			System.out.println(pictureList.get(i).getLocation()+", "+pictureList.get(i).getPname());
			
		}
		
		
	}

}
