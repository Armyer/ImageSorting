package com.geowind.is.utils;

import java.io.IOException;

import org.junit.Test;
public class IndexerTest {
	
	
//	@Test
//	public void testMakeIndex0() throws IOException{
//		
//		Indexer index = new Indexer();
//		
//		String path = "E:\\env\\test-pic\\��վ";
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
		
		String path = "E:\\env\\test-pic\\��վ\\��վ1.jpg";
		
		int result = index.makeIndex(path);
		
		if(result == 0){
			System.out.println("success");
		}else{
			System.out.println("failure");
		}
		
		
	}
	
}
