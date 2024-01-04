package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Locale;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MultipleLinksServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
     
		PrintWriter pw=res.getWriter();
		  
	    res.setContentType("text/html");
		
	    String pval=req.getParameter("p1");
	    
	    Locale locales[]=Locale.getAvailableLocales();
	    
	    if(pval.equalsIgnoreCase("link1")) {
	    	pw.println("<h1>All The Countries Are As Below</h1>");
	    for(Locale l:locales) {
	    	pw.println(l.getDisplayCountry()+",");
	    }
	}//if
	
	    else if(pval.equalsIgnoreCase("link2")) {
	    	pw.println("<h1>All The Languages Are As Below</h1>");
	    for(Locale l:locales) {
	    	pw.println(l.getDisplayLanguage()+",");
	    }
	    }//else if
	    
	    else if(pval.equalsIgnoreCase("link3")) {
	    	
	    	LocalDateTime ldt=LocalDateTime.now();
	    	
	    	int month=ldt.getMonthValue();
	    	
	    	if(month<=4)
	    	pw.println("<h1 style='color:aqua;text-align:center'>Its A Summer</h1>");
	    	
	    	else if(month<=8)
		    	pw.println("<h1 style='color:aqua;text-align:center'>Its A Mansoon</h1>");
	    	
	    	else
		    	pw.println("<h1 style='color:aqua;text-align:center'>Its A Winter</h1>");
	    }//else if
	    
	    else if(pval.equalsIgnoreCase("link4")) {
	    	
		  pw.println("<h1 style='color:orange;text-align:center'>System Date & Time Is::"+new java.util.Date()+"</h1>");

	    }//else if
		pw.println("<h1 style='text-align:center'><a href='links.html'>Home</a></h1>");

			
		}//doGet
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		doGet(req, res);
		
	}//doPost

	    
	}//class


