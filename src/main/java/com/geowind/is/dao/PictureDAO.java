package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Picture;


/**
 * 
 * @author jiang
 * Date:2017-4-30
 *
 */
public interface PictureDAO {
	
	
	/**
	 * 插入图片集合数据
	 * @param pictureList
	 * @return
	 */
	public long insertImages(List<Picture> pictureList);
	
	
	/**
	 * 随机推送图片
	 * @param id
	 * @return
	 */
	public List<Picture> queryImagesOfRandmon();
	
	/**
	 * 获得图片数量
	 * @return
	 */
	public String getImageNum();
	

	/**
	 * 根据名字获取ID
	 * @param pname
	 * @return
	 */
	public int queryPidByPname(String pname);

	/**
	 * 根据id来获取相应的图片
	 * @return
	 */
	public Picture getPicture(int pid);


}
