package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateTimeInsertTest_Oracle {

	private static final String Insert_Query_Mysql = "INSERT INTO CUSTOMER_INFO VALUES(CNO_SEQ.NEXTVAL,?,?,?,?,?)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				PreparedStatement ps = con.prepareStatement(Insert_Query_Mysql);) {
			// Read Input
			String name = null, dob = null, top = null, orderdt = null;
			float billamt = 0.0f;
			if (sc != null) {
				System.out.println("Enter Customer Name::");
				name = sc.next();
				System.out.println("Enter Customer BillAmount::");
				billamt = sc.nextFloat();
				System.out.println("Enter Customer Date Of Birth (dd/mm/yyyy) ::");
				dob = sc.next();
				System.out.println("Enter Time Of Purchase (hh:mm:ss)::");
				top = sc.next();
				System.out.println("Enter Order_Date_Time (dd/MM/yyyy hh:mm:ss)::");
				sc.nextLine();
				orderdt = sc.nextLine();

			} // if
				// Convert String DOB To java.sql.Date class obj
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			java.util.Date udob = sdf.parse(dob);// string date to util date
			java.sql.Date sqdob = new java.sql.Date(udob.getTime());// util date to sql date

			// convert string TOP(Time Of Purchase) to java.sql.Time obj
			java.sql.Time sqtop = java.sql.Time.valueOf(top);

			// convert string order_date_time to java.sql.Timestamp obj
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			java.util.Date uorderdt = sdf1.parse(orderdt);// string date to util date
			java.sql.Timestamp sqorderdt = new java.sql.Timestamp(uorderdt.getTime());// util date to sql Timestamp obj

			// set values to sql query params
			if (ps != null) {
				ps.setString(1, name);
				ps.setFloat(2, billamt);
				ps.setDate(3, sqdob);
				ps.setTime(4, sqtop);
				ps.setTimestamp(5, sqorderdt);

				// execute the sql query
				int count = ps.executeUpdate();

				if (count == 0)
					System.out.println("Records Not Inserted");
				else
					System.out.println("Records Inserted");

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

}// class
