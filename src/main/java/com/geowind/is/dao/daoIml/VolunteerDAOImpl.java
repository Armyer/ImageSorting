package com.geowind.is.dao.daoIml;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.geowind.is.dao.VolunteerDAO;
import com.geowind.is.domain.Volunteer;

public class VolunteerDAOImpl extends BaseDaoImpl<Volunteer> implements
		VolunteerDAO {

	private QueryRunner qr = new TxQueryRunner();

	@Override
	public Volunteer getVolunteer(String loginname, String loginpass) {

		String sql = "select * from volunteer where loginname=?"
				+ "and loginpass=?";
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
	public Volunteer findByLoginnameAndLoginpass(String loginname,
			String loginpass) throws SQLException {
		String sql = "select * from volunteer where loginname=? and loginpass=?";
		return qr.query(sql, new BeanHandler<Volunteer>(Volunteer.class),
				loginname, loginpass);
	}

	@Override
	public boolean findByUidAndPassword(String uid, String password)
			throws SQLException {
		String sql = "select count(*) from volunteer where uid=? and loginpass=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(), uid,
				password);
		return number.intValue() > 0;
	}

	@Override
	public void updatePassword(String uid, String password) throws SQLException {
		String sql = "update volunteer set loginpass=? where uid=?";
		update(sql, password, uid);
	}

	@Override
	public boolean ValidateLoginname(String loginname) throws SQLException {
		String sql = "select count(1) from volunteer where loginname=?";
		Number number = (Number) qr.query(sql, new ScalarHandler(), loginname);
		return number.intValue() == 0;
	}

	@Override
	public void add(Volunteer volunteer) throws SQLException {
		String sql = "insert into volunteer values(?,?,?,?)";
		Object[] params = { volunteer.getUid(), volunteer.getLoginname(),
				volunteer.getLoginpass(), volunteer.getEmail() };
		update(sql, params);
	}
}
