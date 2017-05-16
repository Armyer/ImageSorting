package com.geowind.is.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.geowind.is.dao.daoIml.NoAdaptorLabelDAOImpl;
import com.geowind.is.domain.NoAdaptorLabel;

public class NoAdaptorLabelTest {
	
//	@org.junit.Test
//	public void testSetLabel() throws ParseException{
//		
//		NoAdaptorLabelDAOImpl noAdaptorLabelDAOImpl = new NoAdaptorLabelDAOImpl();
//		
//		NoAdaptorLabel noAdaptorLabel = new NoAdaptorLabel();
//		
//		noAdaptorLabel.setLabel("»ú³¡");
//		
//		Date date = new Date();	
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");		
//		
//		
//		//noAdaptorLabel.setMakerDate(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(date.toString()));
//		
//		
//		
//		noAdaptorLabel.setMakerDate(simpleDateFormat.format(date));
//		
//		noAdaptorLabel.setPid("18");
//		noAdaptorLabel.setValid(1);
//		noAdaptorLabel.setVid("1");
//		
//		noAdaptorLabelDAOImpl.insertLabelOfPicture(noAdaptorLabel);
//		
//	}
	
	@org.junit.Test
	public void test(){
		NoAdaptorLabelDAOImpl noAdaptorLabelDAOImpl = new NoAdaptorLabelDAOImpl();
		String label = "atm";
		int pid = 83;
		int result = noAdaptorLabelDAOImpl.queryNumOfSameLabel(label, pid);
		System.out.println(result);
	
	}

}
