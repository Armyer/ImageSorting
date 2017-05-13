package com.geowind.is.dao.daoIml;

import java.util.List;


import com.geowind.is.dao.PictureDAO;
import com.geowind.is.domain.Picture;

/**
 * 
 * @author jiang
 * Date:2017-4-30
 *
 */
public class PictureDAOImpl extends BaseDaoImpl<Picture> implements PictureDAO {

	/**
	 * 上传图片集合数据
	 */
	public long insertImages(List<Picture> pictureList) {
		
		long result = 0;
		
		for(int i = 0;i<pictureList.size();i++){
			
			Picture picture = pictureList.get(i);
			
			String sql = "insert into picture(pname,location,valid,status,uploaddate) values (?,?,?,?,?)";
			
			Object[] params ={picture.getPname(),picture.getLocation(),
					picture.getValid(),picture.getStatus(),picture.getDate()};
			
			
			//System.out.println(" "+picture.getPid()+" ,"+picture.getPname());
			
			result = insert(sql,params);
			
			//System.out.println("insert picture result is :"+result);
		}
		return result;
	}

	@Override
	public List<Picture> queryImagesOfRandmon() {
		String sql = "select * from picture order by RAND() limit 9";
		
		List<Picture> pictureList = queryForList(sql,null);
		
		return pictureList;
	}

	@Override
	public String getImageNum() {
		// TODO Auto-generated method stub
		return null;
	}



}
