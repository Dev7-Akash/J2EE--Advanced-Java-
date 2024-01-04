package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
	 
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		int countryIndex=Integer.parseInt(req.getParameter("country"));
		
		String countries[]=new String[] {"New Delhi", "Washington DC","CannBera","Bejing","Dhaka","Mosco"};
		
		pw.println("<h1 style='color:red;text-align:center'>The Capital City Name Is::"+countries[countryIndex]+"</h1>");
		
		pw.println("<h1 style='text-align:center'><a href='input.html'>Home</a></h1>");
		
		pw.close();
	}//dopost

}//class
