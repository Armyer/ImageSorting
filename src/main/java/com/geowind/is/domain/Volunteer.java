package com.geowind.is.domain;

import java.sql.Date;

/**
 * 用户模块实体类
 *
 */
public class Volunteer {
	// 对应数据库表
	private int vid;// 主键
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

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
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

	public Date getRegistdate() {
		return registdate;
	}

	public void setRegistdate(Date registdate) {
		this.registdate = registdate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Volunteer(int vid, String username, String password, Date birthday,
			String sex, int phone, String email, Date registdate, String image,
			int valid, String status) {
		super();
		this.vid=vid;
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

	public Volunteer() {
	}

	@Override
	public String toString() {
		return "Volunteer [vid=" + vid + ", username=" + username
				+ ", password=" + password + ", sex=" + sex + ", birthday="
				+ birthday + ", email=" + email + ", phone=" + phone
				+ ", registdate=" + registdate + ", image=" + image
				+ ", valid=" + valid + ", status=" + status + "]";
	}

}
