package com.geowind.is.dao;

import com.geowind.is.domain.NoAdaptorLabel;

public interface NoAdaptorLabelDAO {
	
	/**
	 * ���ǩ
	 * @param noAdaptorLabel
	 * @return
	 */
	public long insertLabelOfPicture(NoAdaptorLabel noAdaptorLabel);
	
	/**
	 * �鿴ͬһ����Ƭ�Ƿ�����ͬ��ǩ
	 * @param label
	 * @param pid
	 * @return
	 */
	public int queryNumOfSameLabel(String label,int pid);

}
