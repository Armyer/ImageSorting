package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Picture;

public interface PictureDAO {
	
	
	/**
	 * 上传图片集合
	 * @param pictureList
	 * @return
	 */
	public int upLoadImage(List<Picture> pictureList);
	
	
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
