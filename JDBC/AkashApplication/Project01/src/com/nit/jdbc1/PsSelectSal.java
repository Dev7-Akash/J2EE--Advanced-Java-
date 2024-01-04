package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsSelectSal {
	//For nth Salary
	//private static final String NTH_SAL_QUERY=" SELECT * FROM (SELECT EMPNO,ENAME,JOB,SAL, DEPTNO, DENSE_RANK() OVER (ORDER BY SAL DESC)R FROM EMP) WHERE R=?";

	//For Top nth Salary
	private static final String NTH_SAL_QUERY=" SELECT * FROM (SELECT EMPNO,ENAME,JOB,SAL, DEPTNO, DENSE_RANK() OVER (ORDER BY SAL DESC)R FROM EMP) WHERE R<=?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
				PreparedStatement ps=con.prepareStatement(NTH_SAL_QUERY);){
			
			//Read input
			int rank=0;
			
			if(sc!=null) {
				System.out.println("Enter Rank Whose Salary You Want To Know:: ");
				rank=sc.nextInt();
			}//if
			
			//Set Value To The Sql Query
			if(ps!=null) {
				ps.setInt(1, rank);
			}//if
			
			//Send & Execute The Sql Query
			try(ResultSet rs=ps.executeQuery()){
				if(rs!=null) {
					boolean isRSEmpty=true;
					while(rs.next()) {
						isRSEmpty=false;
						System.out.println("EMPNO:"+rs.getInt(1)+" "+"ENAME:"+rs.getString(2)+" "+"JOB:"+rs.getString(3)+" "+"SAL:"+rs.getFloat(4)+" "+"DEPTNO:"+rs.getInt(5)+" "+"DENSE_RANK:"+rs.getInt(6));
						System.out.println();
					}//while
					if(isRSEmpty)
						System.out.println("INVALID RANK INSERTED ");
					else
						System.out.println("EMPLOYEE DETAILS OF GIVEN SALARY_RANK");
				}//if
				
							
			}//try2
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}//maim

}//class
