package com.geowind.is.service.serviceIml;

import com.geowind.is.domain.AdaptorLabel;
import com.geowind.is.service2.AdaptorLabelService;

public class AdaptorLabelServiceImpl implements AdaptorLabelService {


	//实现设置图片收录标签功能
	public int setLabelOfImage(AdaptorLabel adaptorLabel) {
		
		AdaptorLabelServiceImpl adaptorLabelDAOImpl= new AdaptorLabelServiceImpl();
		
		long result = adaptorLabelDAOImpl.setLabelOfImage(adaptorLabel);
		if(result != 0){
			return 1;
		}else{
			return 0;
		}
		
	}

}
