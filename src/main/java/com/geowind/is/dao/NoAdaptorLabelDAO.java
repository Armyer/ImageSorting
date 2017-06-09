package com.geowind.is.dao;

import com.geowind.is.domain.NoAdaptorLabel;

public interface NoAdaptorLabelDAO {
	
	/**
	 * 打标签
	 * @param noAdaptorLabel
	 * @return
	 */
	public long insertLabelOfPicture(NoAdaptorLabel noAdaptorLabel);
	
	/**
	 * 查看同一张照片是否有相同标签
	 * @param label
	 * @param pid
	 * @return
	 */
	public int queryNumOfSameLabel(String label,int pid);

}
