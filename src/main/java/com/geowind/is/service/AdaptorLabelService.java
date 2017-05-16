package com.geowind.is.service;

import java.util.List;

import com.geowind.is.dao.daoIml.AdaptorLabelDAOImpl;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorLabelService {

	private AdaptorLabelDAOImpl adaptorLabelDAO = new AdaptorLabelDAOImpl();

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
	
//	//实现设置图片收录标签功能
//		public int setLabelOfImage(AdaptorLabel adaptorLabel) {
//			
//			AdaptorLabelServiceImpl adaptorLabelDAOImpl= new AdaptorLabelServiceImpl();
//			
//			long result = adaptorLabelDAOImpl.setLabelOfImage(adaptorLabel);
//			if(result != 0){
//				return 1;
//			}else{
//				return 0;
//			}
			
		//}

}