package com.geowind.is.test;

import org.junit.Test;

import com.geowind.is.dao.AdaptorLabelDAO;
import com.geowind.is.dao.daoIml.AdaptorLabelDAOImpl;
import com.geowind.is.dao.daoIml.BaseDaoImpl;
import com.geowind.is.domain.AdaptorLabel;

public class AdaptorlabelDAOImplTest extends BaseDaoImpl<AdaptorLabel> {

	private AdaptorLabelDAO adaptorlabelDAOImpl = new AdaptorLabelDAOImpl();

	@Test
	public void testGetPictureLocation() {

		adaptorlabelDAOImpl.getPictureLocation("11");

		String sql = "SELECT * FROM picture JOIN adaptorlabel ON(picture.pid = adaptorlabel.pid)"
				+ "WHERE label LIKE '%½Ö%'||label LIKE '%st%' || label LIKE '%jie%'";

		System.out.println(queryForList(sql, null));
	}

}
