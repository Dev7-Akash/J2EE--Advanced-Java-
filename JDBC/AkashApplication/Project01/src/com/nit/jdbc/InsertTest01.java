package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest01 {


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
			String name=null;
			String city=null;
			double avg=0.0;
			
			if(sc!=null) {
				//Reading inputs
				System.out.println("Enter Student's SNO, SNAME, SADD, AVG VALUES ::");
				System.out.println("Enter Student Number :");
				no=sc.nextInt();
				System.out.println("Enter Student Name :");
				name=sc.next();
				System.out.println("Enter Student City :");
				city=sc.next();
				System.out.println("Enter Student Average :");
				avg=sc.nextDouble();
				
				//Prepare input as per sql query syntax
				name="'"+name+"'";
				city="'"+city+"'";
				
			}//if
			
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
			
			//Create Statement obj
			if(con!=null)
				st=con.createStatement();
			
			//prepare sql query
			//INSERT INTO STUDENT VALUES(104, 'HRUSHI', 'NAD', 89.99);
			String query="INSERT INTO STUDENT VALUES("+no+","+name+","+city+","+avg+")";
			System.out.println(query);
			
			//send & execute sql query in db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("Problem In Record Insertion");
			else
				System.out.println(" Record Inserted");
			
			
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
