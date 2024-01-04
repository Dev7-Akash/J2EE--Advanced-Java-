package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest_Mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try(Connection con=DriverManager.getConnection("jdbc:mysql:///akashdb", "root", "7597");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM PRODUCT");
		){
	//process the Resultset obj
	if(rs!=null) {
		boolean isRSEmpty=true;
		while(rs.next()) {
			isRSEmpty=false;
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getFloat(4));
			
		}//while
		if(isRSEmpty)
			System.out.println("No Records Are Found");
		else
			System.out.println("Records Are Found And Displayed");
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
