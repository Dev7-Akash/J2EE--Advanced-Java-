package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
  PrintWriter pw=res.getWriter();
	
	res.setContentType("text/html");
	
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
	
	pw.println("<br><a href='http://localhost:8080/WishMessageApp/page.html'>Home</a>");
	
	pw.close();
	
}
}