package com.geowind.is.service;

import java.util.ArrayList;
import java.util.List;

import com.geowind.is.dao.AdaptorLabelDAO;
import com.geowind.is.dao.daoIml.AdaptorlabelDAOImpl;
import com.geowind.is.domain.AdaptorLabel;
import com.geowind.is.domain.Picture;

public class AdaptorLabelService {

	private AdaptorLabelDAO adaptorLabelDAO = new AdaptorlabelDAOImpl();

	/**
	 * 根据标签名来获得标签的信息
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