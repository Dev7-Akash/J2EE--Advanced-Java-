package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Multiple_Links_Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter pw=res.getWriter();
			
		res.setContentType("text/html");
		
		String pval=req.getParameter("p1");
		
	    if(pval.equalsIgnoreCase("link1")) {
	    	
	    	LocalDateTime ldt=LocalDateTime.now();
	    	
	    	int hour=ldt.getHour();
	    	
	    	String msg=null;
	    	if(hour<12)
	    		msg="Good Morning";
	    	else if(hour<16)
	    		msg="Good AfterNoon";
	    	else if(hour<20)
	    		msg="Good Evening";
	    	else
	    		msg="Good Night";
	    	
	    	pw.println("<h1 style='color:red;text-align:center'>"+msg+"</h1>");
	    	
	    }//if
	    
	    else if(pval.equalsIgnoreCase("link2")) {
	    	
            LocalDateTime ldt=LocalDateTime.now();
	    	
	    	int month=ldt.getMonthValue();
	    	
	    	if(month<=4)
	    	pw.println("<h1 style='color:aqua;text-align:center'>Its A Summer</h1>");
	    	
	    	else if(month<=8)
		    	pw.println("<h1 style='color:aqua;text-align:center'>Its A Mansoon</h1>");
	    	
	    	else
		    	pw.println("<h1 style='color:aqua;text-align:center'>Its A Winter</h1>");
	    }//else if    
	    
	    else {
	    	pw.println("<h1 style='color:brown; text-align:center'>About Us Page</h1><br><br><p style='color:black; text-align:center'>Our mission is to help people to see data in new ways, discover insights, unlock endless possibilities.</p>");
	    			 
	    }//else
	    
		pw.println("<h1 style='text-align:center'><a href='links.html'>Home</a></h1>");

	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}//doPost
}//class
