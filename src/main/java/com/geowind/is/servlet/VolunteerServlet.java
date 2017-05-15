package com.geowind.is.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.domain.Volunteer;
import com.geowind.is.service.serviceIml.VolunteerService;

public class VolunteerServlet extends BasicServlet {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1482447605034620586L;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	@Override

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名：" + name + " 密码：" + password);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.println("1");
		out.flush();
		out.close();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method = request.getParameter("method");
		
		switch(method){
		
			case "login":
				login(request,response);
		
		}
		    
		   

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    System.out.println("用户名："+username+" 密码："+password);
	    Volunteer volunteer = new Volunteer();
	    volunteer.setUsername(username);
	    volunteer.setPassword(password);
	    
	    VolunteerService volunteerService = new VolunteerService();
	    //登陆
	    Volunteer volunteer2 = volunteerService.login(volunteer);
	    if(volunteer2.getUsername()!=null){
	    	try {
				this.out(response,"1");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else{
	    	try {
				this.out(response, "0");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    
	}

}
