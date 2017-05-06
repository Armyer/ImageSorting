package com.geowind.is.test;

import org.junit.Test;

import com.geowind.is.utils.Md5Utils;

public class Md5UtilsTest {

	@Test
	public void testMd5() {
		System.out.println(Md5Utils.md5("123"));
	}

}
