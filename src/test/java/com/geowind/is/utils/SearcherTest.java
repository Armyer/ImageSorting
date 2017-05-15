package com.geowind.is.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.geowind.is.domain.Picture;

public class SearcherTest {
	
	@Test
	public void testSearcherByPic() throws IOException{
		
		//String path = "E:\\env\\test-pic\\³µÕ¾\\³µÕ¾1.jpg";
		
		String path = "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\ImageSorting\\..\\uploads\\de9a5a10487.jpg";
		
		String indexerPath = "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\index";
		
		Searcher searcher = new Searcher();
		
		List<Picture> pictureList = searcher.searcherByPic(path,indexerPath);
				
		System.out.println("length is£º"+pictureList.size());
		
		for(int i = 0;i<pictureList.size();i++){
			
			System.out.println("location "+pictureList.get(i).getLocation()+", score: "+pictureList.get(i).getStatus());
			
		}
		
	}

}
