package com.geowind.is.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.UserException;

import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;
import com.geowind.is.exception.VolunteerException;
import com.geowind.is.service.AdminService;
import com.geowind.is.service.serviceIml.VolunteerService;

@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminService();
	private VolunteerService volunteerService = new VolunteerService();

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

	// ɾ���û�
	public void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String iddStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(iddStr);
			adminService.delete(id);
		} catch (Exception e) {
		}
		response.getWriter().write("�޸ĳɹ�,2�����ת����¼���������µ�¼...");
		response.setHeader("Refresh", "2;url=" + request.getContextPath()
				+ "/welcome.jsp");
		// request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	// �޸��û�������
	public void updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String newPass = request.getParameter("password");
		String oldPass = request.getParameter("input2");
		String id = request.getParameter("id");
		try {
			volunteerService.updatePassword(id, newPass, oldPass);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VolunteerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write("�޸ĳɹ�,2�����ת����¼���������µ�¼...");
		response.setHeader("Refresh", "2;url=" + request.getContextPath()
				+ "/welcome.jsp");
		// response.sendRedirect(request.getContextPath() + "/user.jsp");
	}

	// ���¹���Ա����Ϣ
	public void updateAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// ��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("input1");
		String password = request.getParameter("input2");
		String email = request.getParameter("input3");
		String sex = request.getParameter("input4");
		adminService.update(username, password, email, sex);
		response.getWriter().write("�޸ĳɹ�,2�����ת����¼���������µ�¼...");
		response.setHeader("Refresh", "2;url=" + request.getContextPath()
				+ "/index.jsp");
	}

	// ��ʾ����ע���û�
	public void userSorting(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Volunteer> volunteers = volunteerService.showNewuser();
		if (volunteers != null) {
			for (Volunteer volunteer : volunteers) {
				System.out.println(volunteer);
				request.setAttribute("volunteers", volunteers);
				request.getRequestDispatcher("/welcome.jsp").forward(request,
						response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.jsp");
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
				request.getRequestDispatcher("/adminInfo.jsp").forward(request,
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
				request.getRequestDispatcher("/user.jsp").forward(request,
						response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	// ����Ա��¼�ķ���
	public void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// ��������
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// ����ͻ��˵�����
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ((!username.equals("") && username != null)
				&& (!password.equals("") && password != null)) {
			// ����ҵ���ķ���
			boolean result = adminService.adminLogin(username, password);
			if (result) {
				Admin admin = adminService.getAdmina(username, password);
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				request.setAttribute("admins", admin);
				request.getRequestDispatcher("/welcome.jsp").forward(request,
						response);
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
