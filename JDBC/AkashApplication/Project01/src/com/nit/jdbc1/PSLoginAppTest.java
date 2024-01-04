package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PSLoginAppTest {
	private static final String AUTH_QUERY = "SELECT COUNT(*) FROM USERINFO WHERE USERID=? AND PASSWORD=?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				PreparedStatement ps = con.prepareStatement(AUTH_QUERY);

		) {
			// variable declaration
			String user = null;
			String pass = null;

			// read inputs
			if (sc != null) {
				System.out.println("Enter Username::");
				user = sc.nextLine();
				System.out.println("Enter Password::");
				pass = sc.nextLine();
			} // if

			// Set Values To Sql Query Param
			if (ps != null) {
				ps.setString(1, user);
				ps.setString(2, pass);
			}

			// send & execute the sql query
			try (ResultSet rs = ps.executeQuery()) {
				// process the ResultSet obj
				if (rs != null) {
					rs.next();
					int count = rs.getInt(1);
					if (count == 0)
						System.out.println("Invalid Credentials");
					else
						System.out.println("Valid Credentials");
				} // if
			} // try2

		} // try
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}// main

}
