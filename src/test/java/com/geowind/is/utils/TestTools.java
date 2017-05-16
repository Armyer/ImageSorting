package com.geowind.is.utils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestTools {
	
	
	@Test
	public void testZhengZe(){
		
		Pattern pattern = Pattern.compile("(\\w{11}.*?(jpg|gif|png|bmp|JPG|GIF|PNG|BMP))");
//		String s = "E:\\env\\apache-tomcat-9.0.0.M19\\webapps\\uploads\\1494937237094_5278.jpg.JPG";
		String s = "../uploads/1494853239609_115.jpg";
		Matcher matcher = pattern.matcher(s);

		if(matcher.find()){
			System.out.println(matcher.group());
		}

	}

 /**
  * 获取8位不重复随机码（取当前时间戳转化为十六进制）
  * @author ShelWee
  * @param time
  * @return
  */
    public static String toHex(long time){    
          return Integer.toHexString((int)time);
   }

}
