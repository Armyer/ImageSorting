package com.geowind.is.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.geowind.is.dao.daoIml.BaseDaoImpl;
import com.geowind.is.dao.daoIml.PictureDAOImpl;
import com.geowind.is.domain.Picture;

public class PictureDaoTest {

	/**
	 * 测试插入图片集数据
	 */
	@Test
	public void testInsertPicture(){
		
		List<Picture> pictureList = new ArrayList<>();
		
		for(int i = 10;i<15;i++){
			Picture picture = new Picture();
			String s = String.valueOf(i);
			picture.setPid(s);
			picture.setLocation("5"+s);
			picture.setPname(s);
			picture.setStatus(s);
			picture.setValid(i);
			pictureList.add(picture);
		}
		PictureDAOImpl pictureDao = new PictureDAOImpl();
		long result = pictureDao.insertImages(pictureList);
		
		
		
	}
	
//	@Test
//	public void test(){
//		BaseDaoImpl b = new BaseDaoImpl();
//		
//		String sql = "insert into picture(pid,pname,location,valid,status) values (?,?,?,?,?)";
//		Object[] args = {1001,"ss","lol","1",null};
//		long result = b.insert(sql, args);
//		System.out.println(result);
//		
//	}
	
}
