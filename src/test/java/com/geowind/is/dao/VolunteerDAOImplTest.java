package com.geowind.is.dao;

import org.junit.Test;

import com.geowind.is.dao.daoIml.VolunteerDAOImpl;
import com.geowind.is.domain.Volunteer;

public class VolunteerDAOImplTest {
	
	@Test
	public void testGetIdByName(){
		String username = "zhangsan";
		VolunteerDAOImpl volunteerDAOImpl = new VolunteerDAOImpl();
		
		int id  = volunteerDAOImpl.queryIdByName(username);
		System.out.println(id);
	}

}
