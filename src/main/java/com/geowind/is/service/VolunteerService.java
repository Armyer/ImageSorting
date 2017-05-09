package com.geowind.is.service;

import java.sql.SQLException;

import org.omg.CORBA.UserException;

import com.geowind.is.dao.VolunteerDAO;
import com.geowind.is.dao.daoIml.VolunteerDAOImpl;
import com.geowind.is.domain.Volunteer;
import com.geowind.is.exception.VolunteerException;

/**
 * �û�ģ��ҵ���
 *
 */
public class VolunteerService {
	private VolunteerDAO volunteerDAO = new VolunteerDAOImpl();

	/**
	 * �޸�����
	 * 
	 * @param uid
	 * @param newPass
	 * @param oldPass
	 * @throws VolunteerException
	 */
	public void updatePassword(String vid, String newPass, String oldPass)
			throws UserException, VolunteerException {
		try {
			/*
			 * 1. У��������
			 */
			boolean bool = volunteerDAO.findByUidAndPassword(vid, oldPass);
			if (!bool) {// ������������
				throw new VolunteerException("���������");
			}

			/*
			 * 2. �޸�����
			 */
			volunteerDAO.updatePassword(vid, newPass);
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
	public boolean ValidateLoginusername(String loginname) {
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

		// 1. ���ݵĲ��� CommonUtils.uuid()����һ�����ظ����ַ���
		// volunteer.setValid(Integer.parseInt(CommonUtils.uuid()));
		if (volunteer != null) {
			// 2. �����ݿ����
			try {
				volunteerDAO.add(volunteer);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}
}
