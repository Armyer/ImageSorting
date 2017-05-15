package com.geowind.is.utils;

import java.io.IOException;

import org.junit.Test;
public class IndexerTest {
	
	
//	@Test
//	public void testMakeIndex0() throws IOException{
//		
//		Indexer index = new Indexer();
//		
//		String path = "E:\\env\\test-pic\\³µÕ¾";
//		
//		int result = index.makeIndex(path);
//		
//		if(result == 1){
//			System.out.println("success");
//		}else{
//			System.out.println("failure");
//		}
//		
//		
//	}

	
	@Test
	public void testMakeIndex1() throws IOException{
		
		Indexer index = new Indexer();
		
		String path = "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\uploads";
		
		String path2 = "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\index";
		
		int result = index.makeIndex(path,path2);
		
		if(result != 0){
			System.out.println("success");
		}else{
			System.out.println("failure");
		}
		
		
	}
	
}
