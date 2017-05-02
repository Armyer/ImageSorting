package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Picture;

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
	public List<Picture> pushImageByRadmon();
	
	/**
	 * 获得图片数量
	 * @return
	 */
	public String getImageNum();

}
