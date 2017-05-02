package com.geowind.is.test;

import static org.junit.Assert.*;

import org.junit.Test;
import com.geowind.is.dao.daoIml.VolunteerDAOImpl;

public class BaseDaoImplTest {

	private VolunteerDAOImpl volunteerDao = new VolunteerDAOImpl();

	@Test
	public void testInsert() {
		String sql = "insert into volunteer(username,password) values(?,?)";
		long id = volunteerDao.insert(sql, "333", "345");
		System.out.println(id);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryForList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSingleVal() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatch() {
		fail("Not yet implemented");
	}

}
