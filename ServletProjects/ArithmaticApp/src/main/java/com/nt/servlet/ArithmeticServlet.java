package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.JspWriter;

public class ArithmeticServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=resp.getWriter();
		
		resp.setContentType("text/html");
		
		String s1Val=req.getParameter("s1");
		
		//read text box values & convert them into floating point values when the submit buttons are pressed
		float val1=0.0f,val2=0.0f;
		
		if (!s1Val.equalsIgnoreCase("link1") && !s1Val.equalsIgnoreCase("link2")) {
			val1=Float.parseFloat(req.getParameter("t1"));
			val2=Float.parseFloat(req.getParameter("t2"));
		}//if
		
		//get sys date & time 
		LocalDateTime ldt=LocalDateTime.now();
		
		//differentiate the logic for multiple submit buttons & hyperlinks 
		
		if (s1Val.equalsIgnoreCase("add")) {
			pw.println("<h1 style='color:green;text-align:center'>Addition::"+(val1+val2)+"</h1>");
		}
		else if (s1Val.equalsIgnoreCase("sub")) {
			pw.println("<h1 style='color:green;text-align:center'>Subtraction::"+(val1+val2)+"</h1>");
		}
		else if (s1Val.equalsIgnoreCase("mul")) {
			pw.println("<h1 style='color:green;text-align:center'>Multiplication::"+(val1*val2)+"</h1>");
		}
		else if (s1Val.equalsIgnoreCase("div")) {
			pw.println("<h1 style='color:green;text-align:center'>Divion::"+(val1/val2)+"</h1>");
		}
		else if (s1Val.equalsIgnoreCase("link2")) {
			int month=ldt.getMonthValue();
			
			if (month<=4) 
				pw.println("<h1 style='color:brown;text-align:center'>It's Summer Season</h1>");
				
			
			else if (month>=5 && month<=8) 
				pw.println("<h1 style='color:brown;text-align:center'>It's Rainy Season</h1>");
				
			
			else if (month<=12 && month>=9) 
				pw.println("<h1 style='color:brown;text-align:center'>It's Winter Season</h1>");
				
		}//elseif
		
		else if(s1Val.equalsIgnoreCase("link1")){

			int hour=ldt.getHour();
			
			if (hour<=12) {
				pw.println("<h1 style='color:orange;text-align:center'>Good Morning</h1>");
			}
			else if (hour<=15 && hour>=13) {
				pw.println("<h1 style='color:orange;text-align:center'>Good Afternoon</h1>");
			}	
			else if (hour<=21 && hour>=16) {
				pw.println("<h1 style='color:orange;text-align:center'>Good Evening</h1>");
			}	
			else 
				pw.println("<h1 style='color:orange;text-align:center'>Good Night</h1>");
			}
			
		//Home Hyperlink
		pw.println("<br><br><h1><a href='input.html'>Home</a></h1>");
        pw.close();
			
		}//doget
		//Home Hyperlink
	    	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(req, resp);
	}//dopost

}//class
