package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class SelectTimeDate_Mysql {
	
	private static final String Select_Query_Oracle="SELECT * FROM CUSTOMER_INFO";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///akashdb", "root", "7597");
				PreparedStatement ps=con.prepareStatement(Select_Query_Oracle);
				ResultSet rs=ps.executeQuery();){
			
			//process Resultset obj
			if(rs!=null) {
				while(rs.next()) {
					int cno=rs.getInt(1);
					String cname=rs.getString(2);
					float billamt=rs.getFloat(3);
					java.sql.Date sqdob=rs.getDate(4);
					java.sql.Time sqtop=rs.getTime(5);
					java.sql.Timestamp sqorderdt=rs.getTimestamp(6);
					
					//convert java.sql.Date class obj to string date value in required pattern
					SimpleDateFormat sdf1=new SimpleDateFormat("MMM/yyyy/dd");
					String sdob=sdf1.format(sqdob);
					
					//convert java.sql.Time class obj to string value in required pattern
					long ms1=sqtop.getTime();
					java.util.Date utop=new java.util.Date(ms1);
					SimpleDateFormat sdf2=new SimpleDateFormat("mm:hh:ss");
					String stop=sdf1.format(utop);
					
					//convert java.sql.Timestamp class obj to string date, time value in the required pattern
					long ms2=sqorderdt.getTime();
					java.util.Date uorderdt=new java.util.Date(ms2);
					SimpleDateFormat sdf3=new SimpleDateFormat("mm:hh:ss yyyy/dd/MMM");
					String sorderdt=sdf3.format(uorderdt);
					System.out.println("CNO ::"+cno+"  CNAME ::"+cname+"  BILLAMT ::"+billamt+"  DOB ::"+sdob+"  TOP ::"+stop+"  ORDER_DATE_TIME ::"+sorderdt); 
					
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
