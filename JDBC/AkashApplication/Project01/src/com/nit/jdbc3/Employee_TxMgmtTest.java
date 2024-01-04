package com.nit.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_TxMgmtTest {
	//private final static String GET_BALANCE_BY_ACNO="SELECT BALANCE FROM JDBC_ACCOUNT_INFO WHERE ACNO=?";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
    	   Statement st=con.createStatement();
    		//   PreparedStatement ps=con.prepareStatement();
    		   Scanner sc=new Scanner(System.in);
    		   ){
    	int empno=0;
    	String name=null;
    	String dept=null;
    	   float salary=0.0f;
    	   dept="'"+dept+"'";
    	   name="'"+name+"'";
    	   if(sc!=null) {
    		   System.out.println("Enter Employee Number::");
    		   empno=sc.nextInt();
    		   System.out.println("Enter Employee Name::"); 
    		   name=sc.next();
    		   System.out.println("Enter Employee Dept Name::");
    		   dept=sc.next();
    		   System.out.println("Enter Employee Salary::");
    		   salary=sc.nextFloat();
    		   
    	   }//if
    	//  String details= "("+empno+","+name+","+dept+","+salary+")";
    	   
    	/*   //set value to query param
    	   if(ps!=null) {
    		   ps.setLong(1, srcNo);
    	   }
    	   
    	   try(ResultSet rs=ps.executeQuery()){
    		   float balance=0.0f;
    		   if(rs.next()) {
    			   balance=rs.getFloat(1);
    			   if(amount>balance) {
    				   System.out.println("Insufficient Funds In The Source Account (Tx Aborted)");
    				   return;
    			   }//if
    		   }//if
    		   else {
    			   System.out.println("Source Account Not Found");
    		   }//else
    	   }//try2
    	  */ 
    	   //begin Tx
    	   if(con!=null) 
    		   con.setAutoCommit(false);
    	   
    	   if(st!=null) {
    		   //add queries to the batch
    		   //for withdraw
    		   st.addBatch("INSERT INTO HR_INFO VALUES ("+ empno+","+name+","+dept+","+salary+")");
    		   //for deposite
    		   st.addBatch("INSERT INTO FINANCE_INFO VALUES ("+ empno+","+name+","+dept+","+salary+")");
    		   //execute batch
    		   int result[]=st.executeBatch();
    		   
    		   //process the result by applying TxMgmt
    		   if(result!=null) {
    			   boolean taskFlag=true;
    			   
    			   for(int i=0;i<result.length;++i) {
    				   if(result[i]==0) {
    					   taskFlag=false;
    					   break;
    					   
    				   }//if
    			   }//for
    			   
    			   if(taskFlag) {
    				   con.commit();
    				   System.out.println("Employee Details Are Inserted Into Both Tables By TxMgmt");
    			   }
    			   else {
    				   con.rollback();
    				   System.out.println("Insertion Failed");
    			   }//else
    		   }//if
    	   }//if
       }//try
       
       catch(SQLException se) {
    	   se.printStackTrace();
       }
       catch (Exception e) {
    	   e.printStackTrace();
		// TODO: handle exception
	}
      
	}//main

}//class
