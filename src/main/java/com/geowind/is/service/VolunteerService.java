package com.geowind.is.service;

import java.sql.SQLException;
import java.util.List;

import org.omg.CORBA.UserException;

import com.geowind.is.dao.VolunteerDAO;
import com.geowind.is.dao.daoIml.VolunteerDAOImpl;
import com.geowind.is.domain.Volunteer;
import com.geowind.is.exception.VolunteerException;

import cn.itcast.commons.CommonUtils;

/**
 * �û�ģ��ҵ���
 *
 */
public class VolunteerService {
	private VolunteerDAO volunteerDAO = new VolunteerDAOImpl();

	/*
	 * ����һ��volunteer��list
	 */
	public List<Volunteer> getVolunteers() {

		return volunteerDAO.getVolunteer();
	}

	/**
	 * �޸�����
	 * 
	 * @param uid
	 * @param newPass
	 * @param oldPass
	 * @throws VolunteerException
	 */
	public void updatePassword(String uid, String newPass, String oldPass)
			throws UserException, VolunteerException {

		try {
			/*
			 * 1. У��������
			 */
			boolean bool = volunteerDAO.findByUidAndPassword(uid, oldPass);
			if (!bool) {// ������������
				throw new VolunteerException("���������");
			}

			/*
			 * 2. �޸�����
			 */
			volunteerDAO.updatePassword(uid, newPass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ��¼����
	 * 
	 * @param
	 * @return volunteer
	 */
	public Volunteer login(Volunteer volunteer) {
		try {
			return volunteerDAO.findByLoginnameAndLoginpass(
					volunteer.getUsername(), volunteer.getPassword());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * �û���ע��У��
	 * 
	 * @param loginname
	 * @return
	 */
	public boolean ValidateLoginname(String loginname) {
		try {
			return volunteerDAO.ValidateLoginname(loginname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * ע�Ṧ��
	 * 
	 * @param user
	 */
	public void regist(Volunteer volunteer) {
		// 1. ���ݵĲ���
		// volunteer.setValid(CommonUtils.uuid());
		// 2. �����ݿ����
		try {
			volunteerDAO.add(volunteer);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Volunteer> showNewuser() {
		return volunteerDAO.getVolunteers();
	}

	/**
	 * ��ʾʱ���
	 * 
	 * @return
	 */
	public int getTime() {
		return volunteerDAO.time();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void mergePassword(String username, String password) {
		volunteerDAO.mergePwd(username, password);
	}

	
	/**
	 * ͨ���û�����ȡID
	 * @param username
	 * @return
	 */
	public int getIDByUserName(String username){
		//System.out.println("username:"+username);
		VolunteerDAOImpl volunteerDAOImpl = new VolunteerDAOImpl();
		int id = volunteerDAOImpl.queryIdByName(username);
		return id;
	}
}
