package com.nit.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest02_TWR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(  Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Statement st=con.createStatement(); ){
			int no=0;
			String newName=null;
			String newAddrs=null;
			double newAvg=0.0;
			
			
			if(sc!=null) {
				//Reading inputs

				System.out.println("Enter Existing Student Number :");
				no=sc.nextInt();
				System.out.println("Enter Student Name :");
				newName=sc.next().toUpperCase();
				System.out.println("Enter Student Address :");
				newAddrs=sc.next().toUpperCase();
				System.out.println("Enter Student Average :");
				newAvg=sc.nextDouble();
				
				//Prepare input as per sql query syntax
				newName="'"+newName+"'";
				newAddrs="'"+newAddrs+"'";
				
			}//if
			
			
			//prepare sql query
			//UPDATE STUDENT SET  SNAME='RASHMI', SADD='MUM', AVG=90.44 WHERE SNO=102;
			String query="UPDATE STUDENT SET SNAME="+newName+",SADD="+newAddrs+",AVG="+newAvg+"WHERE SNO="+no;
			System.out.println(query);
			
			//send & execute sql query in db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("Problem In Record Updation");
			else
				System.out.println(" Student Record Updated");
			
			
		}//try
		
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		}
		
		
		
		catch (Exception e) {
		    e.printStackTrace();
			// TODO: handle exception
		}
		
		}//main

	}//class


