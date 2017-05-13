package com.geowind.is.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.domain.ImageURL;
import com.geowind.is.domain.Picture;
import com.geowind.is.service.serviceIml.InterestServiceImpl;
import com.google.gson.Gson;

public class InterestServlet extends BasicServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1858653679130436118L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		
		switch(method){
		
		case "pushImageByInterest":
			pushImageByInterest(request,response);
		}
		
		
		
		
	}

	private void pushImageByInterest(HttpServletRequest request, HttpServletResponse response) {
		// TO//获得志愿者ID号
		String volunteerId = request.getParameter("username");
		
		//System.out.println("volunteerId is :"+volunteerId);
		
		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();
		
		List<ImageURL>  imageURLList = interestServiceImpl.searchImageByInterest(volunteerId);
		
		//System.out.println(imageURLList.get(0).getPid());
		
		try {
			this.out(response, imageURLList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		PrintWriter out = response.getWriter();
//		Gson gson = new Gson();
//		String msg = gson.toJson(imageURLList);
//
//		out.print(msg);
//		out.flush();
//		out.close();
		
	}
	
	
	

}
