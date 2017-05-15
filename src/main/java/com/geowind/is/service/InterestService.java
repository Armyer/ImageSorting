package com.geowind.is.service;

import java.util.List;

import com.geowind.is.domain.ImageURL;
import com.geowind.is.domain.Picture;

public interface InterestService {

	/**
	 * “‘–À»§À—Õº
	 * @param vid
	 * @return
	 */
	public List<ImageURL> searchImageByInterest(String vid);
	
}
