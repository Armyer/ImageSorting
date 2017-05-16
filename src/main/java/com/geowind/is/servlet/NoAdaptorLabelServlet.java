package com.geowind.is.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.is.domain.NoAdaptorLabel;
import com.geowind.is.service.*;


public class NoAdaptorLabelServlet  extends BasicServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1664246866789031509L;



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String method = request.getParameter("method");
		
		switch(method){
			
			case "setLabel":
				setLabel(request,response);
				break;
			default:
				break;
			
			
		}
		
		
	}


	
	public String getPnameByURL(String url){
		
		Pattern pattern = Pattern.compile("(\\w{11}\\.*?(jpg|gif|png|bmp))");
		
		Matcher matcher = pattern.matcher(url);

		if(matcher.find()){
			//System.out.println(matcher.group());
			return matcher.group();
		}else{
			return null;
		}
		
	}

	/**
	 *���ǩ
	 */
	private void setLabel(HttpServletRequest request, HttpServletResponse response) {
		
		String volunteerName = request.getParameter("username");
		String url = request.getParameter("url");
		String label = request.getParameter("label");
		
		
		
		//���־Ը��ID
		VolunteerService volunteerServiceImpl= new VolunteerService();
		int vid = volunteerServiceImpl.getIDByUserName(volunteerName);
		
		//���ͼƬ����
		PictureServiceImpl pictureServiceImpl = new PictureServiceImpl();
		//���ͼƬID
		int pid = pictureServiceImpl.getPidByPname(getPnameByURL(url));
		

		NoAdaptorLabel noAdaptorLabel = new NoAdaptorLabel();
		noAdaptorLabel.setLabel(label);
		noAdaptorLabel.setVid( String.valueOf(vid));
		
		Date date = new Date();	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		noAdaptorLabel.setMakerDate(simpleDateFormat.format(date));
		
		noAdaptorLabel.setPid(String.valueOf(pid));
		noAdaptorLabel.setValid(1);
		
		NoAdaptorLabelServiceImpl noAdaptorLabelServiceImpl = new NoAdaptorLabelServiceImpl();
		
		long result = noAdaptorLabelServiceImpl.setLabelOfImage(noAdaptorLabel);
		
		if(result != 0){
			try {
				this.out(response,"1");
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				countLabel(label, pid, vid);
			}
		}else{
			try {
				this.out(response,"0");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}



	private void countLabel(String label, int pid,int vid) {

		NoAdaptorLabelServiceImpl noAdaptorLabelServiceImpl = new NoAdaptorLabelServiceImpl();
		int result = noAdaptorLabelServiceImpl.getNumOfSameLabel(label, pid, vid);
		if(result == 1){
			//�ɹ���¼
		}else{
			//δ����
		}
		
	}
	
	
	
	

}
