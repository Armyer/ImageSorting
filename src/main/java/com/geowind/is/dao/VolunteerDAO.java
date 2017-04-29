package com.geowind.is.dao;

import java.sql.SQLException;

import com.geowind.is.domain.Volunteer;

public interface VolunteerDAO {

	/**
	 * 按uid和password查询
	 * 
	 * @param uid
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean findByUidAndPassword(String uid, String password)throws SQLException ;
			
	/**
	 * 根据用户名和密码来查询Volunteer
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Volunteer getVolunteer(String username, String password);

	/**
	 * 修改密码
	 * 
	 * @param uid
	 * @param password
	 * @throws SQLException
	 */
	public void updatePassword(String uid, String password) throws SQLException;
	
	/**
	 * 按用户名和密码查询
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException 
	 */
	public Volunteer findByLoginnameAndLoginpass(String loginname, String loginpass) throws SQLException;

	/**
	 * 校验用户名是否注册
	 * 
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	public boolean ValidateLoginname(String loginname) throws SQLException ;


	/**
	 * 添加用户
	 * 
	 * @param volunteer
	 * @throws SQLException
	 */
	public void add(Volunteer volunteer) throws SQLException ;
}
