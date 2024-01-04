package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeasonFinderServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		  PrintWriter pw=res.getWriter();
			
			res.setContentType("text/html");
			
			LocalDateTime ldt=LocalDateTime.now();
			
			int mon=ldt.getMonthValue();
			
			String msg=null;
			if(mon<=4)
				msg="It's Summer Bro";
			else if(mon<=8)
				msg="It's Mansoon Bro";
			else if(mon<=12)
				msg="It's Winter Bro";
			
			
			pw.println("<h1 style='color:red;text-align:center'>"+msg+"</h1>");
			
			pw.println("<br><a href='http://localhost:8080/SeasonFinderApp/page.html'>Home</a>");
			
			pw.close();
			
		}
}
