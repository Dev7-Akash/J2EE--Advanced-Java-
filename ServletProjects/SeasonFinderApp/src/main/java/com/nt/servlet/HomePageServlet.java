package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.Month;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomePageServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		  PrintWriter pw=res.getWriter();
			
			res.setContentType("text/html");
			
			
			pw.println("<h1 style='color:red;text-align:center'>SeasonFinderApp--Home Page</h1>");

			pw.close();
			
		}
}
