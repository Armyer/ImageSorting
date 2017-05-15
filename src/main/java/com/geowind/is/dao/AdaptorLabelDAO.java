package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.AdaptorLabel;
import com.geowind.is.domain.Picture;

public interface AdaptorLabelDAO {

	/**
	 * ���ݱ�ǩ���õ���ǩ����Ϣ
	 * @param label
	 * @return
	 */
	public AdaptorLabel getAdaptorLabel(String label);
	
	/**
	 * �������pid����ȡpicture
	 * @param pid
	 * @return
	 */
	public List<AdaptorLabel> getPictureLocation(String lableName);
}
