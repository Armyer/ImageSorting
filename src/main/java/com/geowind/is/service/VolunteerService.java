package com.geowind.is.service;

import java.sql.SQLException;

import org.omg.CORBA.UserException;

import com.geowind.is.dao.VolunteerDAO;
import com.geowind.is.dao.daoIml.VolunteerDAOImpl;
import com.geowind.is.domain.Volunteer;
import com.geowind.is.exception.VolunteerException;

/**
 * 用户模块业务层
 *
 */
public class VolunteerService {
	private VolunteerDAO volunteerDAO = new VolunteerDAOImpl();

	/**
	 * 修改密码
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
			 * 1. 校验老密码
			 */
			boolean bool = volunteerDAO.findByUidAndPassword(vid, oldPass);
			if (!bool) {// 如果老密码错误
				throw new VolunteerException("老密码错误！");
			}

			/*
			 * 2. 修改密码
			 */
			volunteerDAO.updatePassword(vid, newPass);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 登录功能
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
	 * 用户名注册校验
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
	 * 注册功能
	 * 
	 * @param user
	 */
	public void regist(Volunteer volunteer) {

		// 1. 数据的补齐 CommonUtils.uuid()返回一个不重复的字符串
		// volunteer.setValid(Integer.parseInt(CommonUtils.uuid()));
		if (volunteer != null) {
			// 2. 向数据库插入
			try {
				volunteerDAO.add(volunteer);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}
}
