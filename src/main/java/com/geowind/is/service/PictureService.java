package com.geowind.is.service;

import java.util.Iterator;
import java.util.List;

import com.geowind.is.domain.Picture;

public interface PictureService {
	
	
	/**
	 * �ϴ�ͼƬ����
	 * @return
	 */
	public long upLoadPictureList(List<Picture> pictureList);

	public long upLoadImages(Iterator<Picture> i,String path);
	
	
}
