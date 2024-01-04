package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/empurl")
public class EmployeeDBServlet extends HttpServlet {
   public static final String GET_EMP_DETAILS_BY_ENO="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
   
   @Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		try (PrintWriter pw=resp.getWriter();
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","AKKI","7597");
				PreparedStatement ps=con.prepareStatement(GET_EMP_DETAILS_BY_ENO);
				){
			int no=Integer.parseInt(req.getParameter("eno"));
			
			ps.setInt(1, no);
			
			try(ResultSet rSet=ps.executeQuery()){
				if(rSet.next()) {
					pw.println("<table border='1' align='center'>");
					pw.println("<tr><th>Empno</th><th>Ename</th><th>Job</th><th>salary</th><th>Deptno</th></tr>");
					pw.println("<tr><td>"+rSet.getInt(1)+"</td><td>"+rSet.getString(2)+"</td><td>"+rSet.getString(3)+"</td><td>"+rSet.getFloat(4)+"</td><td>"+rSet.getInt(5)+"</td></tr>");
					pw.println("</table>");
				}
				else {
					pw.println("<h1 style='color:cyan;text-align:center'>Employee Not Found</h1>");
				}
				
				pw.println("<h1 style='color:cyan;text-align:center'><a href='input.html'>Home</a></h1>");
			}//try2
			
		}//try1
		
		
		
		catch (SQLException se) {
			se.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			// TODO: handle exception
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}//doget
   
   @Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}//dopost
}//class
