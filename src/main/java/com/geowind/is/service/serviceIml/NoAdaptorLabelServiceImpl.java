package com.geowind.is.service.serviceIml;

import com.geowind.is.dao.daoIml.NoAdaptorLabelDAOImpl;
import com.geowind.is.domain.NoAdaptorLabel;
import com.geowind.is.service.NoAdaptorLabelService;

public class NoAdaptorLabelServiceImpl implements NoAdaptorLabelService{

	@Override
	public long setLabelOfImage(NoAdaptorLabel noAdaptorLabel) {

		NoAdaptorLabelDAOImpl noAdaptorLabelDAOImpl = new NoAdaptorLabelDAOImpl();
		
		long result = noAdaptorLabelDAOImpl.insertLabelOfPicture(noAdaptorLabel);
		
		return result;
	}

	
}
