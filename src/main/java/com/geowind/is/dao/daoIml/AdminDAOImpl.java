package com.geowind.is.dao.daoIml;

import java.util.List;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;

public  class AdminDAOImpl extends BaseDaoImpl<Admin> implements AdminDAO {

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


}
