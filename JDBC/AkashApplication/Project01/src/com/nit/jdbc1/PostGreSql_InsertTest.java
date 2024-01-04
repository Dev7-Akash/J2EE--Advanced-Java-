package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PostGreSql_InsertTest {
	private static final String Insert_Query="INSERT INTO PRODUCTS VALUES(NEXTVAL('PID_SEQ'),?,?,?)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/akashpgdb", "postgres", "7597");
				PreparedStatement ps=con.prepareStatement(Insert_Query);
				Scanner sc=new Scanner(System.in);
				){
			//read values from end user
			String name=null;
			double price=0.0, qty=0.0;
			if(sc!=null) {
				System.out.println("Enter Product Name::");
				name=sc.next();
				System.out.println("Enter Product's Price::");
				price=sc.nextDouble();
				System.out.println("Enter Product's Quantity::");
				qty=sc.nextDouble();
			}//if
			//set values to query param
			if(ps!=null) {
				ps.setString(1, name);
				ps.setDouble(2,price);
				ps.setDouble(3, qty);
				
				//execute the sql query
				int count=ps.executeUpdate();
				if(count==0)
					System.out.println("Problem In Record Insertion");
				else
					System.out.println("Record Inserted Successfully");
				
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
