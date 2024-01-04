package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ChooseCityServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
	 
		PrintWriter pw=res.getWriter();
		
		res.setContentType("text/html");
		
		int countryIndex=Integer.parseInt(req.getParameter("country"));
		
		String [][] cities={{"New Delhi","Mumbai","Chennai","Benglore","Kolkata"},
				{"Washington DC","Los Angeles","Orlando","New York","Chicago"},
				{"Melbourne","Sydney","Brisbane","Perth","Gold Coast"},
				{"Shanghai","Beijing","Hong Kong","Macau","Wuhan"},
				{"Moscow","Saint Petersburg","Samara","Sochi","Novosibirsk"},
		};
		 pw.print("<h1 style='color:aqua;text-align:center'>Top Five Cities Are As Below</h1>");

		
		      for(int j = 0; j < cities[countryIndex].length; ++j) {
		        System.out.println(cities[countryIndex][j]);
		      
		pw.println("<h1 style='color:brown;text-align:center'>"+cities[countryIndex][j]+"</h1>");
		      }
		pw.println("<h1 style='text-align:center'><a href='input.html'>Home</a></h1>");
		
		pw.close();
	}//dopost

}
