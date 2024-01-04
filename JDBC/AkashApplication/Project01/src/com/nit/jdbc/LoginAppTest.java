package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Statement st=con.createStatement();
				){
			//variable declaration
			String user=null;
			String pass=null;
			
			//read inputs
			if(sc!=null) {
				System.out.println("Enter UserId::");
			user=sc.next();
			System.out.println("Enter Password::");
			pass=sc.next();
			}//if
			//convert the input values as required for the sql query
			user="'"+user+"'";
			pass="'"+pass+"'";
			
			//prepare sql query
			//"SELECT COUNT(*) FROM USERINFO WHERE USERID=raja AND PASSWORD=rani";
			String query="SELECT COUNT(*) FROM USERINFO WHERE USERID="+user+"AND PASSWORD="+pass;
			System.out.println(query);
			
			//send & execute the sql query
			try(ResultSet rs=st.executeQuery(query)){
				//process the ResultSet obj
				if(rs!=null) {
					rs.next();
					int count=rs.getInt(1);
					if(count==0)
						System.out.println("Invalid Credentials");
					else
						System.out.println("Valid Credentials");
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
