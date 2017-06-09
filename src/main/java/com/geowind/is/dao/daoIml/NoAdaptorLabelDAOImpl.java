package com.geowind.is.dao.daoIml;

import java.util.List;

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

	@Override
	public int queryNumOfSameLabel(String label, int pid) {

		String sql = "SELECT * FROM imagesorting.noadaptorlabel where label=? and pid=?";
		Object[] args = {label,pid};
		
		List<NoAdaptorLabel> noAdaptorLabelList = queryForList(sql, args);
		
		if(noAdaptorLabelList.size()>=2){
			return 1;
		}else{
			return 0;
		}
		
	}

}
