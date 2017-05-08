package com.geowind.is.dao.daoIml;

import java.util.List;

import com.geowind.is.dao.InterestDAO;
import com.geowind.is.domain.Picture;

public class InterestDAOImpl extends BaseDaoImpl<Picture> implements InterestDAO{


	/**
	 * “‘–À»§Õ∆ÀÕÕº∆¨
	 */
	public List<Picture> queryImageByInterest(String vid) {

		
		
		String sql = "SELECT picture.pid,pname,picture.location from interest inner "
				+ "join adaptorlabel on  adaptorlabel.label=interest.label"
				+ "	 join picture on picture.pid = adaptorlabel.pid where interest.vid="+vid;
		
		List<Picture> pictureList = queryForList(sql, null);
		
		
		
		
		return pictureList;
	}

}
