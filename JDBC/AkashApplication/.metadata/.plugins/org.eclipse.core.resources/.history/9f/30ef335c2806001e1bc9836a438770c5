package com.nit.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TxMgmtTest {
	private final static String GET_BALANCE_BY_ACNO="SELECT BALANCE FROM JDBC_ACCOUNT_INFO WHERE ACNO=?";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
    		   Statement st=con.createStatement();
    		   PreparedStatement ps=con.prepareStatement(GET_BALANCE_BY_ACNO);
    		   Scanner sc=new Scanner(System.in);
    		   ){
    	long srcNo=0,destNo=0;
    	   float amount=0.0f;
    	   
    	   if(sc!=null) {
    		   System.out.println("Enter Source Account Number::");
    		   srcNo=sc.nextLong();
    		   System.out.println("Enter Destination Account Number::"); 
    		   destNo=sc.nextLong();
    		   System.out.println("Enter Amount To Transfer::");
    		   amount=sc.nextFloat();
    	   }//if
    	   
    	   //set value to query param
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
    	   
    	   //begin Tx
    	   if(con!=null)
    		   con.setAutoCommit(false);
    	   
    	   if(st!=null) {
    		   //add queries to the batch
    		   //for withdraw
    		   st.addBatch("UPDATE JDBC_ACCOUNT_INFO SET BALANCE=BALANCE-"+amount+"WHERE ACNO="+srcNo);
    		   //for deposite
    		   st.addBatch("UPDATE JDBC_ACCOUNT_INFO SET BALANCE=BALANCE+"+amount+"WHERE ACNO="+destNo);
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
    				   System.out.println("Transaction Commited(Money Transferd)");
    			   }
    			   else {
    				   con.rollback();
    				   System.out.println("Transaction Not Commited(Money Not Transferd)");
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
