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
	private ServletContext sc;
	private String savePath;
	private String indexerPath;

	public void init(ServletConfig config) {
		// 在web.xml中设置的一个初始化参数
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
		indexerPath=config.getInitParameter("indexerPath");
	}
	
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
		Indexer indexer = new Indexer();
		
		
		
		try {
			//System.out.println("sc path is :"+sc.getRealPath("/"));
			int result = indexer.makeIndex(sc.getRealPath("/")+savePath,sc.getRealPath("/")+indexerPath);
			//System.out.println("sc path is :"+sc.getRealPath("/")+savePath);
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
