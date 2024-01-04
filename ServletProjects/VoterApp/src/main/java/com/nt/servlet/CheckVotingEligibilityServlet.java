package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckVotingEligibilityServlet extends HttpServlet{
   public void doGet(HttpServletResponse res, HttpServletRequest req)throws ServletException, IOException{
	  
	   PrintWriter pw=res.getWriter();
	   
	   res.setContentType("text/html");
	   
	   String name=req.getParameter("pname");
	   String addrs=req.getParameter("padd");
	   String tage=req.getParameter("page");
	   int age=Integer.parseInt(tage);
	   
	   if(age>=18)
		   pw.println("<h1 style='color:green;text-align:center'>Mr/Mrs/Miss."+name+"Of"+addrs+"You Are Eligible For Voting</h1>");
	   else 
		   pw.println("<h1 style='color:red;text-align:center'>Mr/Mrs/Miss."+name+"Of"+addrs+"You Are Not Eligible For Voting</h1>");
		   
	   pw.println("<a style='text-align:center' href='input.html'><img src='Images/home.jpg'></a>");
	   
	   pw.close();
	}
   }

