package com.geowind.is.service.serviceIml;

import java.io.IOException;
import java.util.List;

import com.geowind.is.dao.daoIml.InterestDAOImpl;
import com.geowind.is.domain.Picture;
import com.geowind.is.service.InterestService;
import com.geowind.is.utils.Searcher;

public class InterestServiceImpl implements InterestService {
	/**
	 * 根据兴趣搜图推图
	 */
	@Override
	public List<Picture> searchImageByInterest(String vid) {

		InterestDAOImpl interestDAOImpl = new InterestDAOImpl();

		List<Picture> pictureList = interestDAOImpl.queryImageByInterest(vid);

		List<Picture> finalPictureList = null;

		if (pictureList.size() > 0) {

			Searcher searcher = new Searcher();

			try {

				System.out.println("PATH:" + pictureList.get(0).getLocation()
						+ "\\" + pictureList.get(0).getPname());
				finalPictureList = searcher.searcherByPic(pictureList.get(0)
						.getLocation() + "\\" + pictureList.get(0).getPname());

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return finalPictureList;
	}

}
