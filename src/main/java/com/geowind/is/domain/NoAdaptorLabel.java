package com.geowind.is.domain;

import java.util.Date;
/**
 * δ���ɵı�ǩ��
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

	//id��
	private String alid;
	
	//־Ը��id��
	private String vid;
	
	//ͼƬid��
	private String pid;
	
	//��ǩ
	private String label;
	
	//�������
	private String makerDate;
	
	//�Ƿ���Ч
	private int valid;
	
	//����
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
