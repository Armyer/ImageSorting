package com.geowind.is.dao;
import static org.junit.Assert.*;

import java.sql.ResultSet;



import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class JDBCUtilsTest {

	@Test
	public void testGetConnection() {
//		System.out.println(JDBCUtils.getConnection());
		
		   
		        Connection conn = null;  
		        PreparedStatement stmt = null;  
		        ResultSet rs = null;  
		    	ComboPooledDataSource dataSource = new ComboPooledDataSource();		          
		        try{  
		          // 创建连接池  
		            dataSource.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		            dataSource.setJdbcUrl( "jdbc:mysql://localhost:3306/imagesorting" );
		            dataSource.setUser("root");                                  
		            dataSource.setPassword("123456");                                   
		            // 获得连接   
		            conn = (Connection) dataSource.getConnection();  
		            String sql = "select * from picture";  
		            stmt = (PreparedStatement) conn.prepareStatement(sql);  
		            rs = stmt.executeQuery();  
		            while(rs.next()){  
		                System.out.println(rs.getInt("pid")+"   "+rs.getString("pname"));  
		            }  
		        }catch(Exception e){  
		            e.printStackTrace();  
		        }finally{  
		            //JDBCUtils.release(rs, stmt, conn);  
		        	dataSource.close();
		        }  
		
		
	}

	@Test
	public void testReleaseConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testReleaseResultSetStatement() {
		fail("Not yet implemented");
	}

}
