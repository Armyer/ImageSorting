package com.geowind.is.service;

import java.util.Iterator;
import java.util.List;

import com.geowind.is.domain.Picture;

/**
 * 
 * @author jiang
 * Date:2017-5-02
 *
 */
public interface PictureService {
	
	
	/**
	 * �ϴ�ͼƬ����
	 * @return
	 */
	public long upLoadPictureList(List<Picture> pictureList);

	public long upLoadImages(Iterator<Picture> i,String path);
	
}
