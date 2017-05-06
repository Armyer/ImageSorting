package com.geowind.is.dao.daoIml;

import com.geowind.is.dao.NoAdaptorLabelDAO;
import com.geowind.is.domain.NoAdaptorLabel;

public class NoAdaptorLabelDAOImpl extends BaseDaoImpl<NoAdaptorLabel> implements NoAdaptorLabelDAO{

	/**
	 * ¥Ú±Í«©
	 */
	public long insertLabelOfPicture(NoAdaptorLabel noAdaptorLabel) {
		
		String sql = "insert into noadaptorlabel(pid,vid,label,markdate,valid,status) value(?,?,?,?,?,?)";
		
		Object[] args = {noAdaptorLabel.getPid(),noAdaptorLabel.getVid(),noAdaptorLabel.getLabel(),noAdaptorLabel.getMakerDate(),noAdaptorLabel.getValid(),noAdaptorLabel.getStatus()};
		
		long result = insert(sql,args);
		
		return result;
	}

}
