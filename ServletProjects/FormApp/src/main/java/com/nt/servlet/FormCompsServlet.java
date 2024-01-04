package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormCompsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 PrintWriter pw=res.getWriter();
	 
	 res.setContentType("text/html");
	 
	 String name=req.getParameter("pname");
	 int age=Integer.parseInt(req.getParameter("page"));
	 String addrs=req.getParameter("paddrs");
	 String ms=req.getParameter("ms");
	 String gender=req.getParameter("gender");
	 String qlf=req.getParameter("qlf");
	 String courses[]=req.getParameterValues("crs");
	 String mail=req.getParameter("email");
	 String dob=req.getParameter("dob");
	 String tob=req.getParameter("tob");
	 String wob=req.getParameter("wb");
	 String fbUrl=req.getParameter("fburl");
	 long mobNo=Long.parseLong(req.getParameter("mobno"));
	 int favNo=Integer.parseInt(req.getParameter("favno"));
	 float salary=Float.parseFloat(req.getParameter("sal"));
	 String favColor=req.getParameter("favclr");
	 String item=req.getParameter("itemsearch");

	 //provide non-select state for checkbox & list-box
	 ms=(ms==null)?"single":ms;
	 courses=(courses==null)?new String[]{"No Cources Are Selected"}:courses;
	 
	 //write b.logic
	 
	 if (gender.equalsIgnoreCase("M")) {
		if(age<5)
			pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" You Are a Baby Boy</h1>");
		
		else if(age<12)
			pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" You Are a Small Boy</h1>");

		else if(age<19)
			pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name + " You Are a Teenage Boy</h1>");

		else if(age<35)
			pw.println("<h1 style='color:red;text-align:center'>Mr. " + name + " You Are a Young Man</h1>");

		else if(age<50)
			pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" You Are a Middle-Aged Man</h1>");

		else
			pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" You Are a Old Man</h1>");

	}
	 
	 else {
			if(age<5) {
				pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"You Are a Baby Girl</h1>");
			}
			else if(age<12) {
				pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Small Girl</h1>");
			}
			else if(age<19) {
				if (ms.equalsIgnoreCase("married"))
				pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Teenage Married Girl</h1>");
				else 
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Teenage Girl</h1>");
				
			}
			else if(age<35)
				if (ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Young Married Women</h1>");
					else 
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Young Women</h1>");
			else if(age<50)
				if (ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Middle-Aged Married Women</h1>");
					else 
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Middle-Aged Women</h1>");
			else {
				if (ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Married Dadi</h1>");
					else 
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" You Are a Buddhi</h1>");
				}
		}//else
	 
	 pw.println("<h1 style='color:aqua;text-align:center'>Form Data Is As Below</h1>");
	 pw.println("<b>Name::"+name+"</b><br>");
	 pw.println("<b>Age::"+age+"</b><br>");
	 pw.println("<b>Address::"+addrs+"</b><br>");
	 pw.println("<b>Qualification::"+qlf+"</b><br>");
	 pw.println("<b>Marital Status::"+ms+"</b><br>");
	 pw.println("<b>Courses::"+Arrays.toString(courses)+"</b><br>");
	 pw.println("<b>Email::"+mail+"</b><br>");
	 pw.println("<b>DOB::"+dob+"</b><br>");
	 pw.println("<b>TOB::"+tob+"</b><br>");
	 pw.println("<b>WOB::"+wob+"</b><br>");
	 pw.println("<b>Mobile Number::"+mobNo+"</b><br>");
	 pw.println("<b>Favourite Number::"+favNo+"</b><br>");
	 pw.println("<b>Favourite Color::"+favColor+"</b><br>");
	 pw.println("<b>Salary::"+salary+"</b><br>");
	 pw.println("<b>Search Item::"+item+"</b><br>");
	 
	 pw.println("<h1 style='text-align:center'><a href='input.html'>Home</a></h1>");
	}//doget
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//doPost

}//class
