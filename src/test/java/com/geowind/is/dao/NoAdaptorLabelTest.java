package com.geowind.is.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.geowind.is.dao.daoIml.NoAdaptorLabelDAOImpl;
import com.geowind.is.domain.NoAdaptorLabel;

public class NoAdaptorLabelTest {
	
	@org.junit.Test
	public void testSetLabel() throws ParseException{
		
		NoAdaptorLabelDAOImpl noAdaptorLabelDAOImpl = new NoAdaptorLabelDAOImpl();
		
		NoAdaptorLabel noAdaptorLabel = new NoAdaptorLabel();
		
		noAdaptorLabel.setLabel("»ú³¡");
		
		Date date = new Date();	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");		
		
		
		//noAdaptorLabel.setMakerDate(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").parse(date.toString()));
		
		
		
		noAdaptorLabel.setMakerDate(simpleDateFormat.format(date));
		
		noAdaptorLabel.setPid("18");
		noAdaptorLabel.setValid(1);
		noAdaptorLabel.setVid("1");
		
		noAdaptorLabelDAOImpl.insertLabelOfPicture(noAdaptorLabel);
		
	}

}
