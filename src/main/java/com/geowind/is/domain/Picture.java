package com.geowind.is.domain;

/**
 * ͼƬ��
 * @author jiang 
 * Date: 2017-5-01
 *
 */
public class Picture {

	//ͼƬid
	public String pid;

	//ͼƬ����
	public String pname;

	//ͼƬλ��
	public String location;

	//�Ƿ���Ч
	public int valid;
	
	public String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	//����
	public String status;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
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
