package com.geowind.is.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.geowind.is.db.JDBCUtils;

public class JDBCUtilsTest {

	@Test
	public void testGetConnection() {
		System.out.println(JDBCUtils.getConnection());
	}

	@Test
	public void testReleaseConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testReleaseResultSetStatement() {
		fail("Not yet implemented");
	}

}