package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/akashpgdb", "postgres", "7597");
				){
			if(con!=null) {
				System.out.println("success"); 
				
			}
			else {
				System.out.println("problem");
			}
		}
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
