package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2_TWR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Statement st=con.createStatement()){
			//read from end user
			String degn1=null, degn2=null, degn3=null;
			if(sc!=null) {
			System.out.println("Enter First Designation::");
			degn1=sc.next().toUpperCase();
			System.out.println("Enter Second Designation::");
			degn2=sc.next().toUpperCase();
			System.out.println("Enter Third Designation::");
			degn3=sc.next().toUpperCase();
			}//if
			//convert input
			String cond="('"+degn1+"','"+degn2+"','"+degn3+"')";
			
			//prepare SQl query
			//SELECT EMPNO, ENAME,JOB,SAL FROM EMP WHERE JOB IN('CLERK', 'MANAGER', 'ANALYST') ORDER BY JOB;
			String query="SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB IN"+cond+"ORDER BY JOB";
			System.out.println(query);
			
			//send & execute the query
			try(ResultSet rs=st.executeQuery(query)){
				//process the Resultset obj
				if(rs!=null) {
					boolean isRSEmpty=true;
					while(rs.next()) {
						isRSEmpty=false;
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
						
						
					}//while
					if(isRSEmpty)
						System.out.println("No Records Found");
					else
						System.out.println("Records Are Found And Displayed");
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


