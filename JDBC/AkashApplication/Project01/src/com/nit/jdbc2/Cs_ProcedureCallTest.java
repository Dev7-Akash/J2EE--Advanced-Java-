package com.nit.jdbc2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Cs_ProcedureCallTest {
	private final static String Call_Procedure="{call P1_SUM_DATA(?,?,?)}";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				Scanner sc=new Scanner(System.in);
				CallableStatement cs=con.prepareCall(Call_Procedure);
				){
			//Read inputs from end user
			int val1=0,val2=0;
			if(sc!=null) {
				System.out.println("Enter First Number::");
				val1=sc.nextInt();
				System.out.println("Enter Second Number::");
				val2=sc.nextInt();
			}//if
			
			
			if(cs!=null) {
				//register out param to jdbc type
				cs.registerOutParameter(3, Types.INTEGER);
				//set Values to the In param
				cs.setInt(1, val1);
				cs.setInt(2, val2);
				//call pl/sql procedure
				cs.execute();
				//gather results from out param
				int result=cs.getInt(3);
				//Display result
				System.out.println("Result Is::"+result);
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
