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

	// 删除用户
	public void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String iddStr = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(iddStr);
			adminService.delete(id);
		} catch (Exception e) {
		}
		response.getWriter().write("修改成功,2秒后将跳转到登录界面请重新登录...");
		response.setHeader("Refresh", "2;url=" + request.getContextPath()
				+ "/welcome.jsp");
		// request.getRequestDispatcher("/user.jsp").forward(request, response);
	}

	// 修改用户的密码
	public void updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 处理乱码
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
		response.getWriter().write("修改成功,2秒后将跳转到登录界面请重新登录...");
		response.setHeader("Refresh", "2;url=" + request.getContextPath()
				+ "/welcome.jsp");
		// response.sendRedirect(request.getContextPath() + "/user.jsp");
	}

	// 更新管理员的信息
	public void updateAdmin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("input1");
		String password = request.getParameter("input2");
		String email = request.getParameter("input3");
		String sex = request.getParameter("input4");
		adminService.update(username, password, email, sex);
		response.getWriter().write("修改成功,2秒后将跳转到登录界面请重新登录...");
		response.setHeader("Refresh", "2;url=" + request.getContextPath()
				+ "/index.jsp");
	}

	// 显示最新注册用户
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

	// 管理员的信息
	public void adminInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Admin> admins = adminService.getAdmins();
		if (admins != null) {
			for (Admin admin : admins) {
				System.out.println(admin);
				request.setAttribute("admins", admins);
				// 转发
				request.getRequestDispatcher("/adminInfo.jsp").forward(request,
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
				request.getRequestDispatcher("/user.jsp").forward(request,
						response);
				return;
			}
		}
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	// 管理员登录的方法
	public void adminLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 处理乱码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 处理客户端的请求
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ((!username.equals("") && username != null)
				&& (!password.equals("") && password != null)) {
			// 调用业务层的方法
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
