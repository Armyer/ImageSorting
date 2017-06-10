package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;

/**
 * ����Ա
 * 
 * @author Administrator
 *
 */
public interface AdminDAO {

	/**
	 * �޸��û�����Ϣs
	 * 
	 * @param volunteer
	 */
	public abstract void mergeVolunteer(Volunteer volunteer);

	/**
	 * �����û�������������ȡAdmin
	 * 
	 * @param username
	 * @param password
	 * @return admin
	 */
	public abstract Admin getAdmin(String username, String password);

	/**
	 * �õ���admin��list
	 */
	public List<Admin> getAdmin();
	
	/**
	 * �޸Ĺ���Ա����Ϣ
	 * @param username
	 * @param password
	 * @param email
	 * @param sex
	 */
	public void mergeAdmin(String username,String password,String email);
	
	/**
	 * ɾ���û�
	 * @param id
	 */
	public boolean deleteUserInfo(int id);
}
