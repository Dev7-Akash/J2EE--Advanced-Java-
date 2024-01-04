package com.nit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
public class SelectCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		ResultSet rs =null;
		
      try {
    	  //Load jdbc driver class 
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
    	  
    	  //Establish the connection
    	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
    	  
    	  //create jdbc statement obj
    	  if(con!=null)
    		  st=con.createStatement();
    	  
    	  //prepare sql query
    	  String query="SELECT COUNT(*) FROM EMP";
    	  
    	  //send & execute the sql query
    	  if(st!=null)
    		  rs=st.executeQuery(query);
    	  
    	  //process the Resultset obj
    	  if(rs!=null) {
    		  rs.next();
    		  System.out.println("EMP DB TABLE RECORDS COUNT IS ::"+rs.getInt(1));
    		//  System.out.println("EMP DB TABLE RECORDS COUNT IS ::"+rs.getInt("count(*)"));
    	  }//if
    	  
      }//try
      
      catch (SQLException se) {
    	  se.printStackTrace();
		// TODO: handle exception
	}
      catch (ClassNotFoundException cnf) {
    	  cnf.printStackTrace();
		// TODO: handle exception
	}
      catch (Exception e) {
    	  e.printStackTrace();
		// TODO: handle exception
	}
      
      finally {
    	  try {
    		  if(rs!=null)
    			  rs.close();
    	  }
    	  catch (SQLException se) {
    		  se.printStackTrace();
			// TODO: handle exception
		}
    	  
    	  try {
    		  if(st!=null)
    			  st.close();
    	  }
    	  catch (SQLException se) {
    		  se.printStackTrace();
			// TODO: handle exception
		}
    	  
    	  try {
    		  if(con!=null)
    			  con.close();
    	  }
    	  catch (SQLException se) {
    		  se.printStackTrace();
			// TODO: handle exception
		}
      }//finally
	}//main

}//class
