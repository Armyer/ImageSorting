package com.geowind.is.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {
	
	private static Connection conn;
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    
    PreparedStatement stmt = null;  
    ResultSet rs = null;  
    
//    @org.junit.Test
//    public void getConnection() {
//        try {
//            conn = ds.getConnection();
//            
//            
//            String sql = "select * from picture";  
//            stmt = (PreparedStatement) conn.prepareStatement(sql);  
//            rs = stmt.executeQuery();  
//            while(rs.next()){  
//                System.out.println(rs.getInt("pid")+"   "+rs.getString("pname"));  
//            }  
//            
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    @org.junit.Test
    public void testTime() throws ParseException{
    	
    	Date date = new Date();
		long d = date.getTime();
		String s = String.valueOf(d);
		System.out.println("long: "+d+" s:"+s+" date "+date);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(simpleDateFormat.format(date));
		
		//System.out.println(simpleDateFormat.format(date));
		
    	
    }

}
