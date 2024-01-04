package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class CalculateAgeUsingJavaCode_Oracle {
	
	private static final String Get_Age_By_Cno="SELECT DOB FROM CUSTOMER_INFO WHERE CNO=?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Connection con=DriverManager.getConnection("jdbc:mysql:///akashdb","root","7597");
				PreparedStatement ps=con.prepareStatement(Get_Age_By_Cno);
				Scanner sc=new Scanner(System.in);){
			//process the Resultset obj
			//Read input from end user
			int cno=0;
			
			if(sc!=null) {
				System.out.println("Enter Customer Number::");
				cno=sc.nextInt();
				
			}//if
				
			//Set input to the sql query param
			if(ps!=null) {
				ps.setInt(1, cno);
			}//if
			
			//Execute the sql query & get Resultset obj
			try(ResultSet rs=ps.executeQuery()){
				if(rs!=null) {
					if(rs.next()) {
						java.util.Date udob=rs.getDate(1);
						java.util.Date sysdate=new Date();
						long ageInms=sysdate.getTime()-udob.getTime();
						System.out.println("Person Age Is::"+(ageInms/(1000.0f*60.0f*60.0f*24.0f*365.25f)));
					}//if
					else
						System.out.println("Customer Not Found");
				}//if
				
				
			}//try2
			
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
