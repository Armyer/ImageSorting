package com.geowind.is.dao.daoIml;

import java.util.List;

import com.geowind.is.dao.AdaptorLabelDAO;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorLabelDAOImpl extends BaseDaoImpl<AdaptorLabel> implements AdaptorLabelDAO {

	@Override
	public long insertLabelOfImage(AdaptorLabel adaptorLabel) {
		
		String sql = "insert into adaptorlabel(alid,confirmdate,label,pid,vid,valid) values(?,?,?,?,?,?)";
		
		Object[] args = {adaptorLabel.getAlid(),adaptorLabel.getConfirmDate(),adaptorLabel.getLabel(),
						adaptorLabel.getPid(),adaptorLabel.getVid(),adaptorLabel.getValid()};
		long result = insert(sql, args);
		
		return result;
	}

	@Override
	public AdaptorLabel getAdaptorLabel(String label) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdaptorLabel> getPictureLocation(String lableName) {
		String sql="select * from AdaptorLabel where label=?";
		return queryForList(sql, lableName);
	}

}
