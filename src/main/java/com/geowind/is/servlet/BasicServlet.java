package com.geowind.is.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BasicServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8599101185092950487L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	/**
	 * 鎴栭�佷竴涓〃绀虹缁欏鏈嶇
	 * @param response
	 * @param result锛氱粨鏋�
	 * @throws IOException 
	 */
	protected void out(HttpServletResponse response, String result) throws IOException {
		PrintWriter out = response.getWriter();
		out.println(result);
		out.flush();
		out.close();
	}
	
	protected void outJson(HttpServletResponse response, String result) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		out.println(result);
		out.flush();
		out.close();
	}
	
	/**
	 * 閽堝鍒嗛〉鐨刯son鍥為��
	 * @param response
	 * @param list
	 * @param total
	 * @throws IOException 
	 */
	public <T> void out(HttpServletResponse response, List<T> list, int total) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", list);
		map.put("total", total);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
		out.close();
	}
	
	/**
	 * 鍥為�佸崟涓璞�
	 * @param response
	 * @param obj
	 * @throws IOException 
	 */
	public void out(HttpServletResponse response, Object obj) throws IOException {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create(); 
		PrintWriter out = response.getWriter();
//		System.out.println(gson.toJson(obj));
		out.println(gson.toJson(obj));
		out.flush();
		out.close();
	}
	
	/**
	 * 鍥為�佷竴涓泦鍚堝璞�
	 * @param response
	 * @param objs
	 * @throws IOException
	 */
	public void out(HttpServletResponse response, List<Object> objs) throws IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(objs));
		out.flush();
		out.close();
	}
	
	/**
	 * 鍚屾椂鍥為�佸涓笉鍚岀殑闆嗗悎瀵硅薄
	 * @param response
	 * @param map
	 * @throws IOException
	 */
	public void out(HttpServletResponse response, Map<String, Object> map) throws IOException {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(map));
		out.flush();
		out.close();
	}
}
