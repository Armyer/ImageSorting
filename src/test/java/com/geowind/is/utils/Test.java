package com.geowind.is.utils;

import java.util.Date;

public class Test {
	
	  public static void main(String[] args ) {
          // TODO Auto-generated method stub
     System.out.println(new Date());
     System.out.println(toHex(new Date().getTime()));

   }

 /**
  * ��ȡ8λ���ظ�����루ȡ��ǰʱ���ת��Ϊʮ�����ƣ�
  * @author ShelWee
  * @param time
  * @return
  */
    public static String toHex(long time){    
          return Integer.toHexString((int)time);
   }

}
