package com.geowind.is.test;


import org.junit.Test;

import com.geowind.is.dao.daoIml.AdaptorlabelDAOImpl;
import com.geowind.is.dao.daoIml.BaseDaoImpl;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorlabelDAOImplTest extends BaseDaoImpl<AdaptorLabel>{

	private AdaptorlabelDAOImpl adaptorlabelDAOImpl=new AdaptorlabelDAOImpl();
	@Test
	public void testGetPictureLocation() {
	
		adaptorlabelDAOImpl.getPictureLocation("11");
		
		String sql="SELECT * FROM picture JOIN adaptorlabel ON(picture.pid = adaptorlabel.pid)"
				+ "WHERE label LIKE '%½Ö%'||label LIKE '%st%' || label LIKE '%jie%'";
		
		System.out.println(queryForList(sql, null));
	}

}
