package com.geowind.is.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.geowind.is.dao.daoIml.AdaptorLabelDAOImpl;
import com.geowind.is.dao.daoIml.NoAdaptorLabelDAOImpl;
import com.geowind.is.domain.AdaptorLabel;
import com.geowind.is.domain.NoAdaptorLabel;

public class NoAdaptorLabelServiceImpl {

	/**
	 * 给图片打标签
	 * @param noAdaptorLabel
	 * @return
	 */
	public long setLabelOfImage(NoAdaptorLabel noAdaptorLabel) {

		NoAdaptorLabelDAOImpl noAdaptorLabelDAOImpl = new NoAdaptorLabelDAOImpl();

		long result = noAdaptorLabelDAOImpl
				.insertLabelOfPicture(noAdaptorLabel);

		return result;
	}
	
	/**
	 * 查看是否有相同标签并收敛标签
	 * @param label
	 * @param pid
	 * @return
	 */
	public int getNumOfSameLabel(String label,int pid, int vid){
		
		NoAdaptorLabelDAOImpl noAdaptorLabelDAOImpl = new NoAdaptorLabelDAOImpl();
		int result= noAdaptorLabelDAOImpl.queryNumOfSameLabel(label, pid);
		if(result==1){
			//插入标签数据
			
			long result2 = setAdaptorLabelOfImage(label, pid, vid);
			if(result > 0){
				return 1;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}
	
	public long setAdaptorLabelOfImage(String label,int pid, int vid){
		AdaptorLabelDAOImpl adaptorLabelDAOImpl = new AdaptorLabelDAOImpl();
		
		AdaptorLabel adaptorLabel = new AdaptorLabel();
		adaptorLabel.setLabel(label);
		adaptorLabel.setPid(String.valueOf(pid));
		adaptorLabel.setValid(1);
		adaptorLabel.setVid(String.valueOf(vid));
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adaptorLabel.setConfirmDate(simpleDateFormat.format(date));
		
		
		long result = adaptorLabelDAOImpl.insertLabelOfImage(adaptorLabel);
		return result;
	}
	
}
