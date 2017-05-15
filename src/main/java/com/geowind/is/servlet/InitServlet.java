package com.geowind.is.servlet;

import javax.servlet.http.HttpServlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import com.geowind.is.utils.FileUploadUtil;
import javax.servlet.ServletException;

public class InitServlet extends HttpServlet {

	private String filePath = "uploads";

	@Override
	public void init() throws ServletException {
		String temp = this.getInitParameter("uploadPath");

		if (temp != null) {
			filePath = temp;
		}

		
		String path = this.getServletContext().getRealPath("/") + filePath;
		System.out.println("path is:"+path);
		
		
		File file = new File(path);
		if (!file.exists()) {
			 System.out.println(path + "路径创建成功");
			file.mkdirs();
		}

		path = this.getServletContext().getRealPath("/") + filePath ;
		file = new File(path);
		if (!file.exists()) {
			 System.out.println(path + "图片文件夹创建成功");
			file.mkdirs();
		}

		path = this.getServletContext().getRealPath("/") + filePath ;
		file = new File(path);
		if (!file.exists()) {
			 System.out.println(path + "虫库创建成功");
			file.mkdirs();
		}

		FileUploadUtil.PATH = filePath;
		// System.out.println(filePath);
		// System.out.println(path);

		/*
		 * ---------------------------------------------------------------------
		 * ----
		 */

		// Lib_PictureURL = this.getServletContext().getRealPath("/") + filePath
		// + Lib_PictureURL;

	}
}