package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Picture;

public interface InterestDAO {
	
	/**
	 * ����Ȥ��ͼƬ
	 * @return
	 */
	public List<Picture> queryImageByInterest(String vid);

}
