package com.geowind.is.domain;

/**
 * �û�ģ��ʵ����
 *
 */
public class Volunteer {
	// ��Ӧ���ݿ��
	private String uid;// ����
	private String loginname;// ��¼��
	private String loginpass;// ��¼����
	private String email;// ����

	// ע���
	private String reloginpass;// ȷ������
	private String verifyCode;// ��֤��

	// �޸������
	private String newpass;// ������

	public String getReloginpass() {
		return reloginpass;
	}

	public void setReloginpass(String reloginpass) {
		this.reloginpass = reloginpass;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpass() {
		return loginpass;
	}

	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	@Override
	public String toString() {
		return "Volunteer [uid=" + uid + ", loginname=" + loginname
				+ ", loginpass=" + loginpass + ", email=" + email
				+ ", reloginpass=" + reloginpass + ", verifyCode=" + verifyCode
				+ ", newpass=" + newpass + "]";
	}

}
