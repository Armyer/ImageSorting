package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.AdaptorLabel;

public interface AdaptorLabelDAO {

	/**
	 * 根据标签来得到标签的信息
	 * 
	 * @param label
	 * @return
	 */
	public AdaptorLabel getAdaptorLabel(String label);

	/**
	 * 根据外键pid来获取picture
	 * 
	 * @param pid
	 * @return
	 */
	public List<AdaptorLabel> getPictureLocation(String lableName);

	// DAO层插入数据
	public long insertLabelOfImage(AdaptorLabel adaptorLabel);
}
