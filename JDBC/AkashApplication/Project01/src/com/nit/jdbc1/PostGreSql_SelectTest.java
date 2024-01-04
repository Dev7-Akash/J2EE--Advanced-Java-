package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostGreSql_SelectTest {
//	private static final String Select_Query="SELECT * FROM PRODUCT";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/akashpgdb", "postgres", "7597");
				//Connection con=DriverManager.getConnection("jdbc:postgresql:akashpgdb", "postgres", "7597");
				PreparedStatement ps=con.prepareStatement("SELECT * FROM PRODUCTS ");
				ResultSet rs=ps.executeQuery();
				){
			//process Resultset obj
			if(rs!=null) {
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getFloat(4));
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
		

	}

}
