package com.geowind.is.service.serviceIml;

import com.geowind.is.dao.daoIml.AdaptorLabelDAOImpl;
import com.geowind.is.domain.AdaptorLabel;
import com.geowind.is.service.AdaptorLabelService;

public class AdaptorLabelServiceImpl implements AdaptorLabelService {


	//实现设置图片收录标签功能
	public int setLabelOfImage(AdaptorLabel adaptorLabel) {
		
		AdaptorLabelDAOImpl adaptorLabelDAOImpl= new AdaptorLabelDAOImpl();
		
		long result = adaptorLabelDAOImpl.insertLabelOfImage(adaptorLabel);
		if(result != 0){
			return 1;
		}else{
			return 0;
		}
		
	}

}
