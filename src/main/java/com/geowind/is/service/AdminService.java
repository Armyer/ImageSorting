package com.geowind.is.service;

import java.util.List;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.dao.daoIml.AdminDAOImpl;
import com.geowind.is.dao.daoIml.BaseDaoImpl;
import com.geowind.is.domain.Admin;

/**
 * 管理员的业务层
 * 
 * @author Administrator
 *
 */
public class AdminService {
	private AdminDAO adminDAO=new AdminDAOImpl();
	// 登录
	public boolean adminLogin(String username, String password) {
		Admin admin = adminDAO.getAdmin(username, password);
		if (admin != null) {
			return true;
		}
		return false;
	}
	
	//得到admin的list
	public List<Admin> getAdmins(){
		return adminDAO.getAdmin();
	}
}
