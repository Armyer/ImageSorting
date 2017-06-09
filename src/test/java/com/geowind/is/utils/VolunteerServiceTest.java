package com.geowind.is.utils;

import java.sql.Date;

import org.junit.Test;
import org.omg.CORBA.UserException;

import com.geowind.is.domain.Volunteer;
import com.geowind.is.exception.VolunteerException;
import com.geowind.is.service.VolunteerService;

public class VolunteerServiceTest {

	private VolunteerService volunteerservice = new VolunteerService();

	@Test
	public void testUpdatePassword() throws UserException, VolunteerException {

		volunteerservice.updatePassword("2", "11", "1113");
	}

	@Test
	public void testLogin() {

		Volunteer volunteer = new Volunteer(7, "赵四", "1234", new Date(
				new java.util.Date().getTime()), "女", 123, "333@qq.com",
				new Date(new java.util.Date().getTime()), "111", 1234, "122");
		volunteer = volunteerservice.login(volunteer);
		System.out.println(volunteer);
	}

	@Test
	public void testValidateLoginusername() {
		Volunteer volunteer = new Volunteer(7, "赵四", "1234", new Date(
				new java.util.Date().getTime()), "女", 123, "333@qq.com",
				new Date(new java.util.Date().getTime()), "111", 1234, "122");
		//boolean flag = volunteerservice.ValidateLoginusername(volunteer.getUsername());
		//System.out.println(flag);
	}

	@Test
	public void testRegist() {
		Volunteer volunteer = new Volunteer(9, "赵四", "1234", new Date(
				new java.util.Date().getTime()), "女", 1235, "343@qq.com",
				new Date(new java.util.Date().getTime()), "111", 12, "122");
		volunteerservice.regist(volunteer);
	}

}
