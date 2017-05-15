package com.geowind.is.service;

import java.util.List;

import org.junit.Test;

import com.geowind.is.domain.Picture;
import com.geowind.is.service.serviceIml.PictureServiceImpl;

public class PictureServiceImplTest {
	
	
	/**
	 * ²âÊÔÍ¼Æ¬Ëæ»úÍÆËÍº¯Êý
	 */
//	@Test
//	public void testPushImagesOfRandmon(){
//		
//		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
//		List<Picture> pictureList = pictureServiceImpl.pushImagesOfRandom();
//		for(int index = 0;index <pictureList.size();index++){
//			System.out.println(pictureList.get(index).getPid());
//		}
//	
//	}

	@Test
	public void testGetPidByPname(){
		String pname = "de38be10487.jpg";
		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
		System.out.println(pictureServiceImpl.getPidByPname(pname));
	}
}
