package com.geowind.is.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.domain.NoAdaptorLabel;
import com.geowind.is.service.serviceIml.NoAdaptorLabelServiceImpl;
import com.geowind.is.service.serviceIml.VolunteerService;

public class NoAdaptorLabelServlet  extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	/**
	 * 
	 */
	private static final long serialVersionUID = 1664246866789031509L;



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String method = request.getParameter("method");
		
		switch(method){
			
			case "setLabel":
				setLabel(request,response);
				break;
			default:
				break;
			
			
		}
		
		
	}



	/**
	 *¥Ú±Í«©
	 */
	private void setLabel(HttpServletRequest request, HttpServletResponse response) {
		
		String volunteerName = request.getParameter("username");
		String pName = request.getParameter("pname");
		String label = request.getParameter("label");
		
		
		System.out.println("aa:"+volunteerName+", "+pName+", "+label);
		
		VolunteerService volunteerServiceImpl= new VolunteerService();
		int vid = volunteerServiceImpl.getIDByUserName(volunteerName);
		
		

		NoAdaptorLabel noAdaptorLabel = new NoAdaptorLabel();
		noAdaptorLabel.setLabel(label);
		noAdaptorLabel.setVid( String.valueOf(vid));
		
		Date date = new Date();	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		noAdaptorLabel.setMakerDate(simpleDateFormat.format(date));
		

		NoAdaptorLabelServiceImpl noAdaptorLabelServiceImpl = new NoAdaptorLabelServiceImpl();
		
		//request.getParameter("");
		
		
		
		
		
	}
	
	
	
	

}
