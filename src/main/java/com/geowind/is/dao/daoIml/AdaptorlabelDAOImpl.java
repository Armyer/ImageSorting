package com.geowind.is.dao.daoIml;

import java.util.List;

import com.geowind.is.dao.AdaptorLabelDAO;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorlabelDAOImpl extends BaseDaoImpl<AdaptorLabel> implements
		AdaptorLabelDAO {

	@Override
	public AdaptorLabel getAdaptorLabel(String label) {
		String sql = "select * from adaptorlabel where label=?";
		return query(sql, label);
	}


	@Override
	public List<AdaptorLabel> getPictureLocation(String lableName) {
		String sql="SELECT *  FROM adaptorlabel WHERE label LIKE ?||label LIKE ? || label LIKE ? limit 0,9";
		return queryForList(sql, lableName,lableName,lableName);
	}

}
