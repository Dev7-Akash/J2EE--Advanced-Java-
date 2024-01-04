package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsertTest {

	private final static String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?)";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(//Establish Connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","AKKI", "7597");
				//Creating Scanner obj
				Scanner sc=new Scanner(System.in);
				//Create PreparedStatement having pre-compiled sql query
				PreparedStatement ps=con.prepareStatement(STUDENT_INSERT_QUERY);
				){
			int count=0;
			if(sc!=null) {
				System.out.println("Enter Student Count::");
				count=sc.nextInt();
			}//if
			
			if(sc!=null && ps!=null) {
				for(int i=1; i<=count; ++i) {
					//Read Each Student details
					System.out.println("Enter"+i+"Student Details::");
					System.out.println();
					System.out.println("Enter Student Number::");
					int no=sc.nextInt();
					System.out.println("Enter Student Name::");
					String name=sc.next();
					System.out.println("Enter Student Address::");
					String add=sc.next();
					System.out.println("Enter Student Average::");
					float avg=sc.nextFloat();
					
					//Set Each Student Deatils to Pre-Compiled sql query param values(?)
					ps.setInt(1, no);
					ps.setString(2,name);
					ps.setString(3,add);
					ps.setFloat(4,avg);
					
					//Execute the query
					int result=ps.executeUpdate();
					
					//process result
					if(result==0)
						System.out.println(i+"Student Record Is Not Inserted");
					else
						System.out.println(i+"Student Record Is Inserted");
					
				}//for
			}//if
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
