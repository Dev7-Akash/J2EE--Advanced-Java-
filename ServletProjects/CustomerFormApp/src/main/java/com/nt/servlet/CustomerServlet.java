package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		 
		 res.setContentType("text/html");
		 
		 String name=req.getParameter("cname");
		 int age=Integer.parseInt(req.getParameter("cage"));
		 String city=req.getParameter("city");
		 String region=req.getParameter("rgn");
		 String addrs=req.getParameter("caddrs");
		 String ms=req.getParameter("ms");
		 String gender=req.getParameter("gender");
		 int    zip=Integer.parseInt(req.getParameter("zip"));
		 String inventory[]=req.getParameterValues("Inl");
		 String mail=req.getParameter("email");
		 String payMode=req.getParameter("pay");
		 String dob=req.getParameter("dob");
		 long mobNo=Long.parseLong(req.getParameter("mobno"));
		 String feedBack=req.getParameter("fdbk");

		 //provide non-select state for checkbox & list-box
		 ms=(ms==null)?"single":ms;
		 inventory=(inventory==null)?new String[]{"No Items Are Selected"}:inventory;
		 
		 //write b.logic
		 
		 if (gender.equalsIgnoreCase("M")) {
			if(age<5)
				pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" Welcome To Our Shop Baby Boy</h1>");
			
			else if(age<12)
				pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" Welcome To Our Shop Small Boy</h1>");

			else if(age<19)
				pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name + " Welcome To Our Shop Teenage Boy</h1>");

			else if(age<35)
				pw.println("<h1 style='color:red;text-align:center'>Mr. " + name + " Welcome To Our Shop Young Man</h1>");

			else 
				pw.println("<h1 style='color:red;text-align:center'>Mr. "+ name +" Welcome To Our Shop Sir</h1>");

			
		}
		 
		 else {
				if(age<5) {
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Baby Girl</h1>");
				}
				else if(age<12) {
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Small Girl</h1>");
				}
				else if(age<19) {
					if (ms.equalsIgnoreCase("married"))
					pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Teenage Married Girl</h1>");
					else 
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Teenage Girl</h1>");
					
				}
				else if(age<35)
					if (ms.equalsIgnoreCase("married"))
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Young Married Women</h1>");
						else 
							pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Young Women</h1>");
				else if(age<50)
					if (ms.equalsIgnoreCase("married"))
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Mam</h1>");
						else 
							pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Young lady</h1>");
				else {
					if (ms.equalsIgnoreCase("married"))
						pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +" Welcome To Our Shop Dadi</h1>");
						else 
							pw.println("<h1 style='color:red;text-align:center'>Mrs. "+ name +"Welcome To Our Shop Buddhi</h1>");
					}
			}//else
		 
		 pw.println("<hr></hr>");
		 pw.println("<p style='text-align:center'>");
		 pw.println("<h1 style='color:purple;text-align:center'>Customer Data Is As Below</h1>");
		 pw.println("<b>Name:: "+name+"</b><br>");
		 pw.println("<b>Mob No:: "+mobNo+"</b><br>");
		 pw.println("<b>Email Id:: "+mail+"</b><br>");
		 pw.println("<b>DOB:: "+dob+"</b><br>");
		 pw.println("<b>Age:: "+age+"</b><br>");
		 pw.println("<b>Gender:: "+gender+"</b><br>");
		 pw.println("<b>Marital Status:: "+ms+"</b><br>");
		 pw.println("<b>City:: "+city+"</b><br>");
		 pw.println("<b>Zip Code:: "+zip+"</b><br>");
		 pw.println("<b>Region:: "+region+"</b><br>");
		 pw.println("<b>Inventory List:: "+Arrays.toString(inventory)+"</b><br>");
		 pw.println("<b>Payment Mode:: "+payMode+"</b><br>");
		 pw.println("<b>FeedBack:: "+feedBack+"</b><br>");
		 pw.println("</p>");
		 pw.println("<hr></hr>");
		 pw.println("<h1 style='text-align:center;color:blue'>Visit Again...Thank You</h1>");

		 pw.println("<h1 style='text-align:center'><a href='customer.html'>Home</a></h1>");
		}//doget
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, res);
		}//doPost

	}//class


