package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertEmpTest {
	
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
			String job=null;
			double sal=0.0;
			
			if(sc!=null) {
				//Reading inputs
				System.out.println("Enter Employees's EMPNO, ENAME, JOB, SAL VALUES ::");
				System.out.println("Enter Employee Number :");
				no=sc.nextInt();
				System.out.println("Enter Employee Name :");
				name=sc.next();
				System.out.println("Enter Employee Job :");
				job=sc.next();
				System.out.println("Enter Employee Salary :");
				sal=sc.nextDouble();
				
				//Prepare input as per sql query syntax
				name="'"+name+"'";
				job="'"+job+"'";
				
			}//if
			
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
			
			//Create Statement obj
			if(con!=null)
				st=con.createStatement();
			
			//prepare sql query
			//INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(7999, 'AKASH', 'MANAGER', 4500);
			String query="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES("+no+","+name+","+job+","+sal+")";
			System.out.println(query);
			
			//send & execute sql query in db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("Problem In Record Insertion");
			else
				System.out.println(" Employee Record Inserted");
			
			
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
