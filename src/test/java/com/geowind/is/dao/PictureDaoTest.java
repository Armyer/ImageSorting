package com.geowind.is.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.geowind.is.dao.daoIml.PictureDAOImpl;
import com.geowind.is.domain.Picture;

public class PictureDaoTest {

	
//	@Test
//	public void testInsertPicture(){
//		
//		List<Picture> pictureList = new ArrayList<>();
//		
//		for(int i = 10;i<15;i++){
//			Picture picture = new Picture();
//			String s = String.valueOf(i);
//			picture.setPid(s);
//			picture.setLocation("5"+s);
//			picture.setPname(s);
//			picture.setStatus(s);
//			picture.setValid(i);
//			pictureList.add(picture);
//		}
//		PictureDAOImpl pictureDao = new PictureDAOImpl();
//		int result = pictureDao.upLoadImage(pictureList);
//		
//		
//		
//	}
	
	@Test
	public void test(){
		BaseDAO b = new BaseDAO<Picture>();
		
		String sql = "insert into picture(pid,pname,location,valid,status) values (?,?,?,?,?)";
		Object[] args = {1001,"s","location","1",null};
		long result = b.insert(sql, args);
		System.out.println(result);
		
	}
	
}
