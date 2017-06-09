package com.geowind.is.service;

import org.junit.Test;

public class NoAdaptorLabelTest {

	@Test
	public void testGetLabelOfSameOfImage(){
		
		NoAdaptorLabelServiceImpl noAdaptorLabelServiceImpl = new NoAdaptorLabelServiceImpl();
		String label= "atm";
		int vid = 1;
		int pid = 83;
		long result = noAdaptorLabelServiceImpl.getNumOfSameLabel(label, pid, vid);
		System.out.println(result);
				
				
	}
	
	
}
