package com.geowind.is.service;

import java.util.Iterator;
import java.util.List;

import com.geowind.is.domain.Picture;

public interface PictureService {
	
	
	/**
	 * 上传图片集合
	 * @return
	 */
	public long upLoadPictureList(List<Picture> pictureList);

	public long upLoadImages(Iterator<Picture> i,String path);
	
	
}
