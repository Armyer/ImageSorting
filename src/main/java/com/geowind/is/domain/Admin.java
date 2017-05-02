package com.geowind.is.domain;

import java.util.Date;

public class Admin {

	private int aid;
	private String username;
	private String password;
	private Date birthday;
	private String sex;
	private String image;
	private Date registdate;
	private int phone;
	private String email;
	private int valid;
	private String status;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getRegistdate() {
		return registdate;
	}

	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Admin(int aid, String username, String password, Date birthday,
			String sex, String image, Date registdate, int phone, String email,
			int valid, String status) {
		super();
		this.aid = aid;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.image = image;
		this.registdate = registdate;
		this.phone = phone;
		this.email = email;
		this.valid = valid;
		this.status = status;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", username=" + username + ", password="
				+ password + ", birthday=" + birthday + ", sex=" + sex
				+ ", image=" + image + ", registdate=" + registdate
				+ ", phone=" + phone + ", email=" + email + ", valid=" + valid
				+ ", status=" + status + "]";
	}

}
