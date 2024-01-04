//SelectDeptno.java

package com.nit.jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;




public class SelectDeptno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Read inputs
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		

		try {
			sc=new Scanner(System.in);
			int dno=0;
			if(sc!=null) {
				System.out.println("Enter Department Number");
				dno=sc.nextInt();
				
			}
			//LOad jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the coneection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
			
			//Create the jdbc statement
			if(con!=null)
			st=con.createStatement();
			
			//Create sql query
			String query="SELECT * FROM DEPT WHERE DEPTNO="+dno;
			System.out.println(query);
			
			//Send & execute the sql query
			if(st!=null)
				rs=st.executeQuery(query);
			
			//process the Resultset
			if(rs!=null) {
				if(rs.next()) {
					System.out.println("The Dept Details Are::");
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
					
				}//if
				else {
					System.out.println("Department Not Found");
				}//else
			}//if
			
					
		}//try
		catch (SQLException se) {//For known exception
			se.getStackTrace();
			// TODO: handle exception
		}
		catch (ClassNotFoundException cnf) {//For known exception
			cnf.getStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {//For Unknown exception
			e.getStackTrace();
			// TODO: handle exception
		}
		
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch (SQLException se) {
				se.getStackTrace();
				// TODO: handle exception
			}
			try {
				if(st!=null)
					st.close();
			}
			catch (SQLException se) {
				se.getStackTrace();
				// TODO: handle exception
			}
			try {
				if(con!=null)
					con.close();
			}
			catch (SQLException se) {
				se.getStackTrace();
				// TODO: handle exception
			}
		}//finally

	}//main

}//class
