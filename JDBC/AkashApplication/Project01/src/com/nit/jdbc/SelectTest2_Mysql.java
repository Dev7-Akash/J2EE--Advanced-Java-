package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest2_Mysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try(Connection con=DriverManager.getConnection("jdbc:mysql:///akashdb", "root", "7597");
		Statement st=con.createStatement();
		Scanner sc=new Scanner(System.in);
		){
	float startPrice=0.0f;
	float endPrice=0.0f;
	
	//read inputs
	if(sc!=null) {
		System.out.println("ENTER STARTING PRICE RANGE");
		startPrice=sc.nextFloat();
		System.out.println("ENTER ENDING PRICE RANGE");
		endPrice=sc.nextFloat();
	}
	//process the Resultset obj
	
		
		//prepare the sql query
		//query="SELECT * FROM PRODUCT WHERE PRICE>=1000 AND PRICE<=3000";
		String query="SELECT * FROM PRODUCT WHERE PRICE>="+startPrice+"AND PRICE<="+endPrice;
		System.out.println(query);
		try(ResultSet rs=st.executeQuery(query);){
			
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
