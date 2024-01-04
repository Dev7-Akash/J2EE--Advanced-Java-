package com.nit.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class Cs_ProcedureCallTest_chars{

	 private final static String CALL_PROCEDURE="{call P_GET_EMP_DETAILS_ENAME_CHARS(?,?)}";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
    	CallableStatement cs=con.prepareCall(CALL_PROCEDURE);	  
    		  Scanner sc=new Scanner(System.in);){
    	  
    	  //read inputs
    	  String initChar=null;
    	  if(sc!=null) {
    		  System.out.println("Enter Initial Character::");
    		  initChar=sc.next();
    	  }
    	  
    	  if(cs!=null) {
    		  //register OUT param with jdbc types
              cs.registerOutParameter(1, OracleTypes.CURSOR);    		  
    		  //set values to IN param
    		  cs.setString(1,initChar+"%");
    		  
    		  //call pl/sql procedure
    		  cs.execute();
    		  
    		  try(ResultSet rs=(ResultSet)cs.getObject(2)){
    			  if(rs!=null) {
    				  boolean isRSEmpty=false;
    				  while(rs.next()) {
    					  System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
    					  isRSEmpty=true;
    				  }//while
    				  if(!isRSEmpty) 
    				  System.out.println("Records Not Found");
    				  
    				  
    				  else 
    					  System.out.println("Records Found And Displyed");
    				  
    				  }//if
    			  }//try2
    			  
    		  }//if
    		  
    		      	  
      }//try
      catch (SQLException se) {
    	  if(se.getErrorCode()==1403)
    		  System.out.println("Student Number Not Found");
    	  
    	  else if(se.getErrorCode()==1017)
    		  System.out.println("Invalid Credentials");
    	  
    	  else
    		  System.out.println("Some DB Problem");
    		  
		// TODO: handle exception
	}
      
      catch (Exception e) {
    	  e.printStackTrace();
    	  
		// TODO: handle exception
	}
	}// main

}/// class
