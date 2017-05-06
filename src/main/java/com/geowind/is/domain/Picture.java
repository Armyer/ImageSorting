package com.geowind.is.domain;

/**
 * 图片类
 * @author jiang 
 * Date: 2017-5-01
 *
 */
public class Picture {

	//图片id
	public String pid;

	//图片名字
	public String pname;

	//图片位置
	public String location;

	//是否有效
	public int valid;

	//备用
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
