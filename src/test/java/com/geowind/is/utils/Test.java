package com.geowind.is.utils;

import java.util.Date;

public class Test {
	
	  public static void main(String[] args ) {
          // TODO Auto-generated method stub
     System.out.println(new Date());
     System.out.println(toHex(new Date().getTime()));

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
