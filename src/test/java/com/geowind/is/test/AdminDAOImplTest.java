package com.geowind.is.test;

import java.sql.Date;

import org.junit.Test;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.dao.daoIml.AdminDAOImpl;
import com.geowind.is.domain.Volunteer;

public class AdminDAOImplTest {

	private AdminDAO admindao = new AdminDAOImpl();

	@Test
	public void testMergeVolunteer() {
		Volunteer volunteer = null;
		volunteer = new Volunteer(7,"едЫФ", "1324", new Date(
				new java.util.Date().getTime()), "ХЎ", 123, "333@qq.com",
				new Date(new java.util.Date().getTime()), "111", 1234, "122");
		admindao.mergeVolunteer(volunteer);
		System.out.println(volunteer);
	}

}
