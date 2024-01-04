package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest02 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		
		try {
			//Creating scanner obj
			sc= new Scanner(System.in);
			String city=null;
			if(sc!=null) {
				//Reading inputs
				System.out.println("Enter Student's CITY NAME ::");
				city=sc.next();
				
				//Prepare input as per sql query syntax
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
			//DELETE FROM STUDENT WHERE SNO=101;
			String query="DELETE FROM STUDENT WHERE SADD="+city;
			System.out.println(query);
			
			//send & execute sql query in db s/w
			int count=0;
			if(st!=null)
				count=st.executeUpdate(query);
			
			//process the result
			if(count==0)
				System.out.println("No Records Are Found For Deletion");
			else
				System.out.println(count+ "No Of Records Are Found And Deleted");
			
			
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
