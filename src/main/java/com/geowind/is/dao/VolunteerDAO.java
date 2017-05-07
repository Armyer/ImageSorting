package com.geowind.is.dao;

import java.sql.SQLException;
import java.util.List;

import com.geowind.is.domain.Volunteer;

public interface VolunteerDAO {

	/**
	 * ��uid��password��ѯ
	 * 
	 * @param uid
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean findByUidAndPassword(String vid, String password)throws SQLException ;
			
	/**
	 * �����û�������������ѯVolunteer
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public abstract Volunteer getVolunteer(String username, String password);

	/**
	 * �޸�����
	 * 
	 * @param uid
	 * @param password
	 * @throws SQLException
	 */
	public void updatePassword(String uid, String password) throws SQLException;
	
	/**
	 * ���û����������ѯ
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException 
	 */
	public Volunteer findByLoginnameAndLoginpass(String username, String password) throws SQLException;

	/**
	 * У���û����Ƿ�ע��
	 * 
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	public boolean ValidateLoginname(String loginname) throws SQLException ;


	/**
	 * ����û�
	 * 
	 * @param volunteer
	 * @throws SQLException
	 */
	public void add(Volunteer volunteer) throws SQLException ;
	
	/**
	 * ����volunteer���е����е�volunteer
	 * @return volunteer
	 */
	public List<Volunteer> getVolunteer();
}
