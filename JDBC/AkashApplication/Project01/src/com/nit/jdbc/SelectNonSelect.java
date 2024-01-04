package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Statement st=con.createStatement();){
			//read inputs
			String query=null;
			if(sc!=null) {
				System.out.println("Enter Sql Query");
				query=sc.nextLine();
			}//if
			//send and execute the sql query in db s/w
			if(st!=null) {
				boolean flag=st.execute(query);
				if(flag) {
					System.out.println("SELECT SQL QUERY IS EXECUTED");
					//get the Resultset obj
					try(ResultSet rs=st.getResultSet()){//nested try with resource
						//procrss the Resultset obj
						if(rs!=null) {
							while(rs.next()) {
								System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
								
							}//while
						}//if
						
					}//try2
				}//if
				else {
					System.out.println("NON-SELECT SQL QUERY IS EXECUTED");
					int count=st.getUpdateCount();
					System.out.println("No Of Records That Are Affected::"+count);
				}//else
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
