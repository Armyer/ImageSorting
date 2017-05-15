package com.geowind.is.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.utils.Indexer;
import com.google.gson.Gson;



public class IndexerServlet extends BasicServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4013271911255672606L;
	
	
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
		
		case "makeIndex":
			makeIndex(request,response);
			break;
			
		default:
			break;
		}
	
	}

	
	//制作图库数据
	private void makeIndex(HttpServletRequest request, HttpServletResponse response) {
		ServletConfig servletConfig = this.getServletConfig();
		Indexer indexer = new Indexer();
		//System.out.println(servletConfig.getServletContext().getRealPath("/")+servletConfig.getInitParameter("savePath"));
		try {
			int result = indexer.makeIndex(servletConfig.getServletContext().getRealPath("/")+servletConfig.getInitParameter("savePath"),servletConfig.getServletContext().getRealPath("/")+this.getInitParameter("indexPath"));
			if(result == 1){
				PrintWriter out = response.getWriter();
				String msg = "success make index";
				out.print(msg);
				out.flush();
				out.close();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	

}
