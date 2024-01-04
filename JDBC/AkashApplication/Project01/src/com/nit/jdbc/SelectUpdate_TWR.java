package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUpdate_TWR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("SELECT COUNT(*) FROM EMP")
				){
			//process the Resultset obj
			if(rs!=null) {
				rs.next();
				System.out.println("Emp Db Table Records count is::"+rs.getInt(1));
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
