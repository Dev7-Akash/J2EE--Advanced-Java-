package com.nt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;


public class HtmlServlet extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException 
	{
      res.setContentType("text/html");

	  PrintWriter pw=res.getWriter();

	  pw.println("<table align='center' border='1' bgcolor='gray' height='50%' width='50%'>");
	  pw.println("<tr><td>PlayerName</td><td>Sport</td><td>Country</td></tr>");
	  pw.println("<tr><td>Rohit</td><td>Cricket</td><td>India</td></tr>");
	  pw.println("<tr><td>Messi</td><td>Football</td><td>Argentina</td></tr>");
	  pw.println("<tr><td>Conor</td><td>MMA</td><td>Ireland</td></tr>");
	  pw.println("</table>");
	  pw.close();

	}
}
