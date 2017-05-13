package com.geowind.is.dao.daoIml;

import java.util.Date;

import com.geowind.is.dao.AdaptorlLabelDAO;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorLabelDAOImpl extends BaseDaoImpl<AdaptorLabel> implements AdaptorlLabelDAO {

	@Override
	public long insertLabelOfImage(AdaptorLabel adaptorLabel) {
		
		String sql = "insert into adaptorlabel(alid,confrimdate,label,pid,vid,valid) values(?,?,?,?,?,?)";
		
		Object[] args = {adaptorLabel.getAlid(),adaptorLabel.getConfirmDate(),adaptorLabel.getLabel(),
						adaptorLabel.getPid(),adaptorLabel.getVid(),adaptorLabel.getValid()};
		long result = insert(sql, args);
		
		return result;
	}

}
