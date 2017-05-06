package com.geowind.is.dao;

import java.util.List;

import org.junit.Test;

import com.geowind.is.dao.daoIml.PictureDAOImpl;
import com.geowind.is.domain.Picture;

public class PictureDaoImplTest {
	
	
	/**
	 *  ≤‚ ‘Õ∆ÀÕÕº∆¨∫Ø ˝
	 */
	@Test
	public void testGetImagesOfRandom(){
		
		PictureDAOImpl pictureDaoImpl = new PictureDAOImpl();
		List<Picture> pictureList = pictureDaoImpl.queryImagesOfRandmon();
		for(int i = 0;i<pictureList.size();i++){
			System.out.println(pictureList.get(i).getPname());
		}
		
	}

}
