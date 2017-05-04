package com.geowind.is.test;

import java.sql.Date;

import org.junit.Test;

import com.geowind.is.domain.Admin;
import com.geowind.is.service.AdminService;

public class AdminServiceTest {

	private AdminService adminService = new AdminService();

	@Test
	public void testAdminLogin() {
		Admin admin = null;
		admin = new Admin(1, "едЫФ", "1234", new Date(
				new java.util.Date().getTime()), "ХЎ", 123, "333@qq.com",
				new Date(new java.util.Date().getTime()), "111", 1234, "122");
		boolean flag=adminService.adminLogin(admin.getUsername(), admin.getPassword());
		System.out.println(flag);
	}

}
