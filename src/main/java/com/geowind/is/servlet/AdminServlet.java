package com.geowind.is.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
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
