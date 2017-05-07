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

	// ����Ա����Ϣ
	public void adminInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Admin> admins = adminService.getAdmins();
		if (admins != null) {
			for (Admin admin : admins) {
				System.out.println(admin);
				request.setAttribute("admins", admins);
				// ת��
				request.getRequestDispatcher("adminInfo.jsp").forward(request,
						response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	// �û���Ϣ�ķ���
	public void user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ͨ��volunteerServiceҵ���ķ����õ�volunteers�ļ���
		List<Volunteer> volunteers = volunteerService.getVolunteers();
		// �������ж�
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

	// ����Ա��¼�ķ���
	public void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ����ͻ��˵�����
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ((!username.equals("") && username != null)
				&& (!password.equals("") && password != null)) {
			// ����ҵ���ķ���
			boolean result = adminService.adminLogin(username, password);
			if (result) {
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.sendRedirect(request.getContextPath() + "/welcome.jsp");
				return;
			} else {
				List<String> messageList = new ArrayList<String>();
				messageList.add("�û��������벻��ȷ");
				request.setAttribute("errors", messageList);
				request.getRequestDispatcher("/adminLogin.jsp").forward(
						request, response);
			}
		} else {
			List<String> messageList = new ArrayList<String>();
			messageList.add("�û��������벻��Ϊ�գ�");
			request.setAttribute("errors", messageList);
			request.getRequestDispatcher("/adminLogin.jsp").forward(request,
					response);
		}
	}
}
