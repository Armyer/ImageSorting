package com.geowind.is.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.domain.ImageURL;
import com.geowind.is.domain.Picture;
import com.geowind.is.service.serviceIml.InterestServiceImpl;
import com.geowind.is.service.serviceIml.VolunteerService;
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
			break;
		default:
			break;
		}
		
		
		
		
	}

	private void pushImageByInterest(HttpServletRequest request, HttpServletResponse response) {
		ServletConfig servletConfig = this.getServletConfig();
		
		//有待测试
//		String username = request.getParameter("username");
//		
//		VolunteerService volunteerService = new VolunteerService();
//		int volunteerId = volunteerService.getIDByUserName(username);
//		String result = String.valueOf(volunteerId);
		
		
		//获得志愿者ID号
		String volunteerId = request.getParameter("username");
		
		
		InterestServiceImpl interestServiceImpl = new InterestServiceImpl();
		
		List<ImageURL>  imageURLList = interestServiceImpl.searchImageByInterest(volunteerId,servletConfig.getServletContext().getRealPath("/")+servletConfig.getInitParameter("indexPath"));
		
		
		PrintWriter out;
		try {
			out = response.getWriter();
			Gson gson = new Gson();
			String msg = gson.toJson(imageURLList);

			out.print(msg);
			out.flush();
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

}
