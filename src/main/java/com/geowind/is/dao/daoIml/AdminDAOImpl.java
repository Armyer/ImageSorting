package com.geowind.is.dao.daoIml;

import com.geowind.is.dao.AdminDAO;
import com.geowind.is.domain.Admin;
import com.geowind.is.domain.Volunteer;

public class AdminDAOImpl extends BaseDaoImpl<Volunteer> implements AdminDAO {

	@Override
	public Volunteer mergeVolunteer(Volunteer volunteer) {

		String sql = "update volunteer SET * = (?,?,?,?,?,?,?,?,?,?) "
				+ "WHERE usernsme = ?";
		return query(sql, volunteer.getBirthday(), volunteer.getEmail(),
				volunteer.getImage(), volunteer.getPassword(),
				volunteer.getPhone(), volunteer.getRegistdate(),
				volunteer.getSex(), volunteer.getStatus(),
				volunteer.getUsername(), volunteer.getValid(),
				volunteer.getUsername());
	}

}
