package com.geowind.is.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.service.serviceIml.NoAdaptorLabelServiceImpl;

public class NoAdaptorLabelServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");
		
		switch(op){
			
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

		NoAdaptorLabelServiceImpl noAdaptorLabelServiceImpl = new NoAdaptorLabelServiceImpl();
		
		request.getParameter("");
		
		
		
		
		
	}
	
	
	
	

}
