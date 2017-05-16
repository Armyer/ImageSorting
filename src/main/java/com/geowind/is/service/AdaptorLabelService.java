package com.geowind.is.service;

import java.util.List;

import com.geowind.is.dao.daoIml.AdaptorLabelDAOImpl;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorLabelService {

	private AdaptorLabelDAOImpl adaptorLabelDAO = new AdaptorLabelDAOImpl();

	/**
	 * ���ݱ�ǩ������ñ�ǩ����Ϣ
	 * 
	 * @param labelName
	 * @return
	 */
	public AdaptorLabel getAdaptorLabel(String labelName) {

		AdaptorLabel adaptorLabel = null;

		adaptorLabel = adaptorLabelDAO.getAdaptorLabel(labelName);
		if (adaptorLabel != null) {
			return adaptorLabel;
		}
		return null;
	}

	public List<AdaptorLabel> getPictureLoaction(String label) {

		return adaptorLabelDAO.getPictureLocation(label);
	}

}