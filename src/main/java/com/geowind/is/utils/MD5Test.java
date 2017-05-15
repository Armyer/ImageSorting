package com.geowind.is.utils;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MD5Test {

	@Test
	public void testGetMD5() throws NoSuchAlgorithmException {
		System.out.println(MD5.getMD5("123"));
	}
	
	@Test
	public void testGetM5() throws NoSuchAlgorithmException {
		System.out.println(MD5.getMD5("123"));
	}

}
