package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class UpdateTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		
		try {
			//Creating scanner obj
			sc= new Scanner(System.in);
			//Input variables
			
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
			
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
			
			//Create Statement obj
			if(con!=null)
				st=con.createStatement();
			
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
				System.out.println(" Employee Record Updated");
			
			
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
			
			try {
				if(sc!=null)
					sc.close();
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			}//finally
		}//main

}
