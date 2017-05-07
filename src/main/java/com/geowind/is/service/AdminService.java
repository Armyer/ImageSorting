package com.geowind.is.service;

import java.util.List;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.dao.daoIml.AdminDAOImpl;
import com.geowind.is.dao.daoIml.BaseDaoImpl;
import com.geowind.is.domain.Admin;

/**
 * ����Ա��ҵ���
 * 
 * @author Administrator
 *
 */
public class AdminService {
	private AdminDAO adminDAO=new AdminDAOImpl();
	// ��¼
	public boolean adminLogin(String username, String password) {
		Admin admin = adminDAO.getAdmin(username, password);
		if (admin != null) {
			return true;
		}
		return false;
	}
	
	//�õ�admin��list
	public List<Admin> getAdmins(){
		return adminDAO.getAdmin();
	}
}
