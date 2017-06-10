package com.geowind.is.dao;

import java.util.List;

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
	 * 
	 * @param username
	 * @param password
	 * @return admin
	 */
	public abstract Admin getAdmin(String username, String password);

	/**
	 * 得到的admin的list
	 */
	public List<Admin> getAdmin();
	
	/**
	 * 修改管理员的信息
	 * @param username
	 * @param password
	 * @param email
	 * @param sex
	 */
	public void mergeAdmin(String username,String password,String email);
	
	/**
	 * 删除用户
	 * @param id
	 */
	public boolean deleteUserInfo(int id);
}
