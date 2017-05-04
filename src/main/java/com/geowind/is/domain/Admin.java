package com.geowind.is.domain;

import java.util.Date;

public class Admin {

	// 对应数据库表
	private int aid;// 主键
	private String username;// 登录名
	private String password;// 登录密码
	private Date birthday;// 生日
	private String sex;// 登录密码
	private int phone;// 电话
	private String email;// 邮箱
	private Date registdate;// 注册日期
	private String image;// 图片
	private int valid;// 是否有效
	private String status;// 状态

	
	//引入关联类
	private Volunteer volunteer;
	
	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

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
			String sex, int phone, String email, Date registdate, String image,
			int valid, String status) {
		super();
		this.aid = aid;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.registdate = registdate;
		this.image = image;
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
