package com.nit.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Cs_ProcedureTest_Student{

	 private final static String CALL_PROCEDURE="{call P_GET_STUDENT_DETAILS_BY_SNO(?,?,?)}";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
    	CallableStatement cs=con.prepareCall(CALL_PROCEDURE);	  
    		  Scanner sc=new Scanner(System.in);){
    	  
    	  //read inputs
    	  int no=0;
    	  if(sc!=null) {
    		  System.out.println("Enter Student Number::");
    		  no=sc.nextInt();
    	  }
    	  
    	  if(cs!=null) {
    		  //register OUT param with jdbc types
    		  cs.registerOutParameter(2, Types.VARCHAR);
    		  cs.registerOutParameter(3, Types.FLOAT);
    		  
    		  //set values to IN param
    		  cs.setInt(1, no);
    		  
    		  //call pl/sql procedure
    		  cs.execute();
    		  
    		  //gather results from out params
    		  System.out.println("Emp Name ::"+cs.getString(2));
    		  System.out.println("Emp Average ::"+cs.getFloat(3));
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
	}//main

}///class
