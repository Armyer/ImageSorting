package com.geowind.is.dao.daoIml;

import java.util.List;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.domain.AdaptorLabel;
import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;

public class AdminDAOImpl extends BaseDaoImpl<Admin> implements AdminDAO {

	private BaseDaoImpl<AdaptorLabel> baseDaoImpl = new BaseDaoImpl<AdaptorLabel>();

	@Override
	public void mergeVolunteer(Volunteer volunteer) {

		String sql = "update volunteer SET password=? " + "WHERE username = ?";
		update(sql, volunteer.getPassword(), volunteer.getUsername());
	}

	public Admin getAdmin(String username, String password) {
		String sql = "select * from admin where username=?" + "and password=?";
		return query(sql, username, password);
	}

	@Override
	public List<Admin> getAdmin() {
		String sql = "select * from admin where 1=?";
		return queryForList(sql, 1);
	}

	@Override
	public void mergeAdmin(String username, String password, String email) {
		String sql = "update admin set username=?,password=?,email=?";
		update(sql, username, password, email);
	}

	@Override
	public boolean deleteUserInfo(int id) {

		String sql = "select * from adaptorlabel where vid=?";
		AdaptorLabel adaptorLabel = baseDaoImpl.query(sql, id);
		if (adaptorLabel != null) {
			return false;
		} else {
			String sql1 = "delete from volunteer where vid=?";
			update(sql1, id);
			return true;
		}

	}
}
