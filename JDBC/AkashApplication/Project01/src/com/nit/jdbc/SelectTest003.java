package com.nit.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectTest003 {
	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// Load jdbc driver class obj
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Establish the connection with db s/w
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");

			// Create jdbc Statement obj
			if (con != null)
				st = con.createStatement();

			// Prepare sql query
			String query = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN('CLERK','MANAGER','SALESMAN') ORDER BY JOB";

			// Execute sql query
			if (st != null)
				rs = st.executeQuery(query);

			// Process the Resultset
			if (rs != null) {
				while (rs.next() != false) {
					System.out.println(
							rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getFloat(4));
				} // while
			} // if

		} // try
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle known exception
		} catch (ClassNotFoundException cnf) {

			// System.err.println("classnotfound"); 
			cnf.printStackTrace();
			// TODO: handle known exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle Unknown exception
		}

		finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
				// TODO: handle exception
			}
		} // finally
	}// main

}// class
