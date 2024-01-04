package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TranferRecordsFromOracleToMysqlTest {

	private final static String Mysql_Insert_Product_Query = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
	private final static String Oracle_Select_Product_Query = "SELECT * FROM PRODUCT";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection oraCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Connection mysqlCon = DriverManager.getConnection("jdbc:mysql:///akashdb", "root", "7597");
				Statement oraSt = oraCon.createStatement();
				PreparedStatement mysqlPs = mysqlCon.prepareStatement(Mysql_Insert_Product_Query);

		) {
			// Execute select sql query in oracle db s/w
			try (ResultSet rs = oraSt.executeQuery(Oracle_Select_Product_Query)) {
				int count=0;

				// process resultset obj & also insert records to mysql db
				if (rs != null && mysqlPs != null) {
					while (rs.next()) {
						// get each record from oracle table
						int PID = rs.getInt(1);
						String PNAME = rs.getString(2);
						float PRICE = rs.getFloat(3);
						float QTY = rs.getFloat(4);

						// set values to insert sql query params
						mysqlPs.setInt(1, PID);
						mysqlPs.setString(2, PNAME);
						mysqlPs.setFloat(3, QTY);
						mysqlPs.setFloat(4, QTY);

						// Execute Insert Query
						int result = mysqlPs.executeUpdate();
						
						if (result == 0)
							
							System.out.println("Problems In Copying");
						else
							System.out.println("Records Are copied To Mysql Db");
						count++;

					} // while
					System.out.println(count+"::No Of Records Are Inserted Into Mysql Product Table");

				} // if

			}//try2

		} // try
		
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}// main

}// class
