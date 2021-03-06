package com.geowind.is.domain;

import java.util.Date;
/**
 * 未采纳的标签类
 * @author jiang
 * date:2017-5-03
 *
 */
public class NoAdaptorLabel {

	
	@Override
	public String toString() {
		return "NoAdaptorLabel [alid=" + alid + ", vid=" + vid + ", pid=" + pid + ", label=" + label + ", makerDate="
				+ makerDate + ", valid=" + valid + ", status=" + status + "]";
	}

	//id号
	private String alid;
	
	//志愿者id号
	private String vid;
	
	//图片id号
	private String pid;
	
	//标签
	private String label;
	
	//标记日期
	private String makerDate;
	
	//是否有效
	private int valid;
	
	//备用
	private String status;
	
	
	public String getlid() {
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

	public String getMakerDate() {
		return makerDate;
	}

	public void setMakerDate(String makerDate) {
		this.makerDate = makerDate;
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
