package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PSUpdateTest {
	private static final String UPDATE_QUERY = "UPDATE STUDENT SET AVG=AVG+2 WHERE SADD IN (?,?)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);

		) {
			// variable declaration
			String city1 = null;
			String city2 = null;

			// read inputs
			if (sc != null) {
				System.out.println("Enter First City Name::");
				city1 = sc.nextLine();
				System.out.println("Enter Second City Name::");
				city2= sc.nextLine();
			} // if

			// Set Values To Sql Query Param
			if (ps != null) {
				ps.setString(1, city1);
				ps.setString(2, city2);
			}

			// send & execute the sql query
			
				int count=0;
				if (ps != null) {
					count = ps.executeUpdate();
					if (count == 0)
						System.out.println("INVALID DATA PROBLEM IN UPDATION");
					else
						System.out.println(count+"STUDENT AVERAGE INCREMENTED AND UPDATED");
				} // if
		

		} // try
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}// main


}//class
