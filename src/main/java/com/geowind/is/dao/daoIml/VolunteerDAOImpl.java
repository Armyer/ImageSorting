package com.geowind.is.dao.daoIml;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.geowind.is.dao.VolunteerDAO;
import com.geowind.is.domain.Volunteer;
import com.geowind.is.utils.Md5Utils;

public class VolunteerDAOImpl extends BaseDaoImpl<Volunteer> implements
		VolunteerDAO {

	private QueryRunner qr = new QueryRunner();

	@Override
	public Volunteer getVolunteer(String loginname, String loginpass) {

		String sql = "select * from volunteer where username=?"
				+ "and password=?";
		return query(sql, loginname, loginpass);
	}

	/**
	 * 按用户名和密码查询
	 * 
	 * @param loginname
	 * @param loginpass
	 * @return Volunteer
	 * @throws SQLException
	 */
	public Volunteer findByLoginnameAndLoginpass(String username,
			String password) throws SQLException {
		String sql = "select * from volunteer where username=? and password=?";
		return query(sql, username, password);
	}

	@Override
	public boolean findByUidAndPassword(String uid, String password)
			throws SQLException {
		Boolean flag = false;
		String sql = "select count(*) from volunteer where vid=? and password=?";
		Volunteer volunteer = query(sql, uid, password);
		if (volunteer != null) {
			flag = true;
			return flag;
		} else {
			return false;
		}
	}

	@Override
	public void updatePassword(String uid, String password) throws SQLException {
		String sql = "update volunteer set password=? where vid=?";
		update(sql, password, uid);
	}

	@Override
	public boolean ValidateLoginname(String loginname) throws SQLException {

		boolean flag = false;
		String sql = "select username from volunteer where username=?";
		Volunteer volunteer = query(sql, loginname);
		if (volunteer != null) {
			flag = true;
			return flag;
		}
		flag = false;
		return flag;
	}

	@Override
	public void add(Volunteer volunteer) throws SQLException {
		String sql = "insert into volunteer values(?,?,?,?,?,?,?,?,?,?,?)";
		/*
		 * Volunteer volunteer = new Volunteer("赵四", "1234", new Date( new
		 * java.util.Date().getTime()), "女", 123, "333@qq.com", new Date( new
		 * java.util.Date().getTime()), "111", 1234, "122");
		 */
		/*
		 * Object[] params = { volunteer.getUsername(), volunteer.getPassword(),
		 * volunteer.getBirthday(), volunteer.getSex(), volunteer.getPhone(),
		 * volunteer.getEmail(), volunteer.getRegistdate(),
		 * volunteer.getImage(), volunteer.getValid(), volunteer.getStatus()};
		 */
		update(sql, volunteer.getVid(), volunteer.getUsername(),
				Md5Utils.md5(volunteer.getPassword()), volunteer.getBirthday(),
				volunteer.getSex(), volunteer.getPhone(), volunteer.getEmail(),
				volunteer.getRegistdate(), volunteer.getImage(),
				volunteer.getValid(), volunteer.getStatus());
	}
}
