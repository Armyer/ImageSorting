package com.geowind.is.dao;

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
	 * @param username
	 * @param password
	 * @return admin
	 */
	public abstract Admin getAdmin(String username,String password);
}
