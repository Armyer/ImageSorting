package com.geowind.is.dao.daoIml;

import java.util.List;

import com.geowind.is.dao.BaseDAO;
import com.geowind.is.dao.PictureDAO;
import com.geowind.is.domain.Picture;

public class PictureDAOImpl extends BaseDAO<Picture> implements PictureDAO {

	/**
	 * 上传图片集合数据
	 */
	public int upLoadImage(List<Picture> pictureList) {
		
		for(int i = 0;i<pictureList.size();i++){
			
			Picture picture = pictureList.get(i);
			
			String sql = "insert into picture(pid,pname,location,valid,status) values (?,?,?,?,?)";
			
			Object[] params ={picture.getPid(),picture.getPname(),picture.getLocation(),picture.getValid(),picture.getStatus()};
			System.out.println(" "+picture.getPid()+" ,"+picture.getPname());
			
			long result = insert(sql,params);
			System.out.println("insert picture result is :"+result);
		}
		return 0;
	}

	@Override
	public List<Picture> pushImageByRadmon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImageNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
