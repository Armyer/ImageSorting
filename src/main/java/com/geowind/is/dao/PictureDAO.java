package com.geowind.is.dao;

import java.util.List;

import com.geowind.is.domain.Picture;


/**
 * 
 * @author jiang
 * Date:2017-4-30
 *
 */
public interface PictureDAO {
	
	
	/**
	 * ����ͼƬ��������
	 * @param pictureList
	 * @return
	 */
	public long insertImages(List<Picture> pictureList);
	
	
	/**
	 * �������ͼƬ
	 * @param id
	 * @return
	 */
	public List<Picture> queryImagesOfRandmon();
	
	/**
	 * ���ͼƬ����
	 * @return
	 */
	public String getImageNum();
	

	/**
	 * �������ֻ�ȡID
	 * @param pname
	 * @return
	 */
	public int queryPidByPname(String pname);

	/**
	 * ����id����ȡ��Ӧ��ͼƬ
	 * @return
	 */
	public Picture getPicture(int pid);


}
