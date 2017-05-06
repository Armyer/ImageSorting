package com.geowind.is.domain;

import java.sql.Date;

/**
 * �û�ģ��ʵ����
 *
 */
public class Volunteer {
	// ��Ӧ���ݿ��
	private int vid;// ����
	private String username;// ��¼��
	private String password;// ��¼����
	private Date birthday;// ����
	private String sex;// ��¼����
	private int phone;// �绰
	private String email;// ����
	private Date registdate;// ע������
	private String image;// ͼƬ
	private int valid;// �Ƿ���Ч
	private String status;// ״̬

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
