package com.geowind.is.domain;

/**
 * ͼƬ��
 * 
 * @author jiang Date: 2017-5-01
 *
 */
public class Picture {

	@Override
	public String toString() {
		return "Picture [pid=" + pid + ", pname=" + pname + ", location="
				+ location + ", valid=" + valid + ", status=" + status + "]";
	}

	// ͼƬid
	public int pid;

	// ͼƬ����
	public String pname;

	// ͼƬλ��
	public String location;

	// �Ƿ���Ч
	public int valid;

	// ����
	public String status;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

}
