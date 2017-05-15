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
	 * 上传图片集合
	 * @return
	 */
	public long upLoadPictureList(List<Picture> pictureList);

	
	public long upLoadImages(Iterator<Picture> i,String path);
	
	//随机推图
	public List<Picture> pushImagesOfRandom();
	
	
	public String getPidByPname(String pname);
}
