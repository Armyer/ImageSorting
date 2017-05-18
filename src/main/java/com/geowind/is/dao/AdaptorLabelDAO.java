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

	/**
	 * 
	 * @param adaptorLabel
	 * @return
	 */
	public long insertLabelOfImage(AdaptorLabel adaptorLabel);

	/**
	 * 导出标签化的结果
	 * @return
	 */
	public List<AdaptorLabel> getAdaptorLabels();
}
