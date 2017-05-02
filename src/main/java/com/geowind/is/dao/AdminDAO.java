package com.geowind.is.dao;

import com.geowind.is.domain.Volunteer;

/**
 * 管理员
 * @author Administrator
 *
 */
public interface AdminDAO {

	/**
	 * 修改用户的信息s
	 * @param volunteer
	 */
	public abstract Volunteer mergeVolunteer(Volunteer volunteer);
	
	 
}
