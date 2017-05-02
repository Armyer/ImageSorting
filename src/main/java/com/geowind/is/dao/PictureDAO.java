package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Picture;

public interface PictureDAO {
	
	
	/**
	 * �ϴ�ͼƬ����
	 * @param pictureList
	 * @return
	 */
	public int upLoadImage(List<Picture> pictureList);
	
	
	/**
	 * �������ͼƬ
	 * @param id
	 * @return
	 */
	public List<Picture> pushImageByRadmon();
	
	/**
	 * ���ͼƬ����
	 * @return
	 */
	public String getImageNum();

}
