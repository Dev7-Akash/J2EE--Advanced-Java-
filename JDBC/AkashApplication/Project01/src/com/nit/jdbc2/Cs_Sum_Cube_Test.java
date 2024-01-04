package com.nit.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Cs_Sum_Cube_Test {
	private final static String Call_Procedure="{call P_SUM_CUBE(?,?,?)}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Scanner sc=new Scanner(System.in);
				CallableStatement cs=con.prepareCall(Call_Procedure);
				){
			//Read inputs from end user
			int val1=0;
			if(sc!=null) {
				System.out.println("Enter First Number::");
				val1=sc.nextInt();
			}//if
			
			
			if(cs!=null) {
				//register out param to jdbc type
				cs.registerOutParameter(2,Types.INTEGER);
				cs.registerOutParameter(3, Types.INTEGER);
				//set Values to the In param
				cs.setInt(1, val1);
				
				//call pl/sql procedure
				cs.execute();
				//gather results from out param
				int Square_result=cs.getInt(2);
				int Cube_result=cs.getInt(3);
				//Display result
				System.out.println("Square Result Is::"+Square_result+" Cube Result Is::"+Cube_result);
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
