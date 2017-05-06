package com.geowind.is.domain;

import java.util.Date;


/**
 * 已采纳的标签类
 * @author jiang
 * date:2017-5-03
 *
 */
public class AdaptorLabel {
	
	//标签id
	private String alid;
	
	//志愿者id
	private String vid;
	
	//图片id
	private String pid;
	
	//采纳的标签
	private String label;
	
	//确认标签日期
	private Date confirmDate;
	
	//是否有效
	private int valid;
	
	//备用
	private String status;

	@Override
	public String toString() {
		return "AdaptorLabel [alid=" + alid + ", vid=" + vid + ", pid=" + pid + ", label=" + label + ", confirmDate="
				+ confirmDate + ", valid=" + valid + ", status=" + status + "]";
	}

	public String getAlid() {
		return alid;
	}

	public void setAlid(String alid) {
		this.alid = alid;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
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
