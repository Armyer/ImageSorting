package com.geowind.is.dao;

import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;

/**
 * 管理员
 * 
 * @author Administrator
 *
 */
public interface AdminDAO {

	/**
	 * 修改用户的信息s
	 * 
	 * @param volunteer
	 */
	public abstract void mergeVolunteer(Volunteer volunteer);

	/**
	 * 根据用户名和密码来获取Admin
	 * @param username
	 * @param password
	 * @return admin
	 */
	public abstract Admin getAdmin(String username,String password);
}
