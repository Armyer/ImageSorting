package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.AdaptorLabel;

public interface AdaptorLabelDAO {

	/**
	 * ���ݱ�ǩ���õ���ǩ����Ϣ
	 * 
	 * @param label
	 * @return
	 */
	public AdaptorLabel getAdaptorLabel(String label);

	/**
	 * �������pid����ȡpicture
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
	 * ������ǩ���Ľ��
	 * @return
	 */
	public List<AdaptorLabel> getAdaptorLabels();
}
