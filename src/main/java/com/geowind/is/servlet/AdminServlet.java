package com.geowind.is.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.dao.daoIml.AdminDAOImpl;
import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;
import com.geowind.is.service.AdminService;
import com.geowind.is.service.serviceIml.VolunteerService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminService();
	private VolunteerService volunteerService = new VolunteerService();
	private AdminDAO adminDAO = new AdminDAOImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String methodStr = request.getParameter("method");
		try {
			Method method = getClass().getMethod(methodStr,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 管理员的信息
	public void adminInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Admin> admins = adminService.getAdmins();
		if (admins != null) {
			for (Admin admin : admins) {
				System.out.println(admin);
				request.setAttribute("admins", admins);
				// 转发
				request.getRequestDispatcher("adminInfo.jsp").forward(request,
						response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	// 用户信息的方法
	public void user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 通过volunteerService业务层的方法拿到volunteers的集合
		List<Volunteer> volunteers = volunteerService.getVolunteers();
		// 遍历并判断
		if (volunteers != null) {
			for (Volunteer volunteer : volunteers) {
				System.out.println(volunteer);
				request.setAttribute("volunteers", volunteers);
				request.getRequestDispatcher("user.jsp").forward(request,
						response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	// 管理员登录的方法
	public void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 处理客户端的请求
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ((!username.equals("") && username != null)
				&& (!password.equals("") && password != null)) {
			// 调用业务层的方法
			boolean result = adminService.adminLogin(username, password);
			if (result) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.sendRedirect(request.getContextPath() + "/welcome.jsp");
				return;
			} else {
				List<String> messageList = new ArrayList<String>();
				messageList.add("用户名或密码不正确");
				request.setAttribute("errors", messageList);
				request.getRequestDispatcher("/adminLogin.jsp").forward(
						request, response);
			}
		} else {
			List<String> messageList = new ArrayList<String>();
			messageList.add("用户名和密码不能为空！");
			request.setAttribute("errors", messageList);
			request.getRequestDispatcher("/adminLogin.jsp").forward(request,
					response);
		}
	}
}
