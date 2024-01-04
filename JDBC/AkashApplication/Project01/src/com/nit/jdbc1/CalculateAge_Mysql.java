package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

public class CalculateAge_Mysql {
	
	private final static String Calculate_Age_Oracle="SELECT CNAME, date_format(FROM_DAYS(DATEDIFF(NOW(),DOB)),'%Y') FROM akashdb.customer_info";
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///akashdb", "root", "7597");
				PreparedStatement ps=con.prepareStatement(Calculate_Age_Oracle);
				ResultSet rs=ps.executeQuery();
				){
			//Process The Resultset obj
			if(rs!=null) {

				while(rs.next()) {
                    
					System.out.println("Age Of "+rs.getString(1)+" Is "+rs.getFloat(2));
				
				}//while
				
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
