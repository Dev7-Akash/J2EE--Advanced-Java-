package com.nit.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class ScannerTest
{
	public static void main(String[] args) 
	{
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try{

			//Read inputs

			sc=new Scanner(System.in);

            String initChars=null;

			if(sc!=null){
				System.out.println("Enter Initial Chars Of Employee Name:");

				initChars=sc.nextLine();//Gives S

				//Convert input values as required for the SQL Query

				initChars="'"+initChars+"%'";  //Gives 'S%'

			}
			//Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//Establish Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");

			//Create the Statement obj
			if(con!=null)
				st=con.createStatement();

			//Prepare sql query

			//SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE 'S%' ORDER BY ENAME;

			String query="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE "+initChars+" ORDER BY ENAME";

            System.out.println(query);

			//Send and Execute the sql qurey
			if(st!=null)
				rs=st.executeQuery(query);

			//Process the ResultSet obj
			if(rs!=null){
				boolean isRSEmpty=true;

				while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));

					 isRSEmpty=false;
				}//while

				if(isRSEmpty)
					System.out.println("Records Not Found");
				else
            	System.out.println("Records Found And Displayed");

			}//if

		}//try

		catch(SQLException se){
			se.printStackTrace();
		}//catch

		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}//catch

		catch(Exception e){
			e.printStackTrace();
		}//catch

		finally{

			try{
				if(rs!=null)
					rs.close();
			}//try

			catch(SQLException se){
				se.printStackTrace();
			}
          
			try{
				if(st!=null)
					st.close();
			}//try

			catch(SQLException se){
				se.printStackTrace();
			}

				try{
				if(con!=null)
					con.close();
			}//try

			catch(SQLException se){
				se.printStackTrace();
			}

			try{
				if(sc!=null)
					sc.close();
			}//try

			catch(Exception e){
				e.printStackTrace();
			}
		}//finally



	}//main
}//class
