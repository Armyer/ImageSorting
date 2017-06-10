package com.geowind.is.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.geowind.is.dao.daoIml.AdaptorLabelDAOImpl;
import com.geowind.is.dao.daoIml.VolunteerDAOImpl;
import com.geowind.is.domain.Volunteer;

public class BaseDaoImplTest {

	private VolunteerDAOImpl volunteerDao = new VolunteerDAOImpl();
	private AdaptorLabelDAOImpl adaptor = new AdaptorLabelDAOImpl();

	@Test
	public void testInsert() {
		String sql = "insert into volunteer(username,password) values(?,?)";
		long id = volunteerDao.insert(sql, "333", "345");
		System.out.println(id);
	}

	@Test
	public void testUpdate() {
		String sql = "update volunteer set username=? where username=?";
		volunteerDao.update(sql, "едЫФ", "333");
	}

	@Test
	public void testQuery() {
		String sql = "select * from volunteer where vid=?";
		System.out.println(volunteerDao.query(sql, 2));
	}

	@Test
	public void testQueryForList() {
		String sql = "select * from volunteer where 1=?";
		List<Volunteer> volunteers = volunteerDao.queryForList(sql, 1);
		for (int i = 0; i < volunteers.size(); i++) {
			System.out.println(volunteers);
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetSingleVal() {

		/*
		 * String sql = "select count(*) from volunteer";
		 * System.out.println(volunteerDao.getSingleVal(sql,null));
		 */

		List<String> list = new ArrayList<String>();

		String sql1 = "select count(*) from adaptorlabel";
		long count = adaptor.getSingleVal(sql1);

		for (int i = 0; i < count; i++) {
			String sql = "SELECT pname AS 'picture_name' FROM AdaptorLabel a "
					+ "JOIN picture p ON a.pid=p.pid";
			String result = adaptor.getSingleVal(sql);
			list.add(result);
		}

		for (int i = 0; i < count; i++) {
			String sql = "SELECT label FROM AdaptorLabel";
			String result1 = adaptor.getSingleVal(sql);
			list.add(result1);
		}

		for (int i = 0; i < count; i++) {
			String sql = "SELECT confirmdate FROM AdaptorLabel";
			String result2 = adaptor.getSingleVal(sql);
			list.add(result2);
		}
		System.out.println(list);
	}

	@Test
	public void testBatch() {
		String sqlString = "update volunteer set username = ?,password = ?"
				+ "where vid = ?";
		volunteerDao.batch(sqlString, new Object[] { 1, "1111", 2 },
				new Object[] { 4, "111", 4 });
	}

}
