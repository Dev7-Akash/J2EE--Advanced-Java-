package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClientSideServlet extends HttpServlet {

@Override
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
			  
		   PrintWriter pw=res.getWriter();
		   
		   res.setContentType("text/html");
		   
		   String name=req.getParameter("pname");
		   String addrs=req.getParameter("paddrs");
		   String tage=req.getParameter("page");
		   int age=Integer.parseInt(tage);
		   
		   //server side form validation logic
		   
//		   int age=0;
//		   List<String> errorList= new ArrayList<>();
//		   if(name==null||name.length()==0||name.equals("")) {//required rule on name
//			   errorList.add("Person Name Is Required");
//		   }else if(name.length()<5) {
//			   errorList.add("Person Name Must have More Than 5 Letters");
//		   }
//		   
//		   
//		   if(addrs==null||name.length()==0||name.equals("")) {//required rule on name
//			   errorList.add("Person Address Is Required");
//		   }
//		   
//		   if(tage==null||tage.length()==0||tage.equals("")) {//required rule on name
//			   errorList.add("Person Age Is Required");
//		   }
//		   else {
//			   try {
//				   age=Integer.parseInt(tage);
//				   if(age<=0||age>=126) {
//					   errorList.add("Person Age Must Be In The Range Of 1 To 125");
//				   }
//			   }
//			   catch (NumberFormatException nfe) {
//				   errorList.add("Person Age Must Be Numeric Value");
//			}
//			   
//		   }
//		   
//		   //print error msg
//		   if(errorList.size()!=0) {
//			   pw.println("<ul style='color:red'>");
//			   for(String errMsg:errorList) {
//				   pw.println("<li>"+errMsg+"</li>");
//			   }//for
//			   
//			   pw.println("</ul>");
//			   pw.println("</br><a href='input.html'>Home</a>");
//		   }//if
//		   
//		   
//		   
	
		   if(age>=18)
			   pw.println("<h1 style='color:green;text-align:center'>Mr/Mrs/Miss. "+name+" Of "+ addrs+ " You Are Eligible For Voting</h1>");
		   else 
			   pw.println("<h1 style='color:red;text-align:center'>Mr/Mrs/Miss. "+name+" Of "+ addrs+ " You Are Not Eligible For Voting</h1>");
			   
		   pw.println("<a style='text-align:center' href='input.html'><img src='Images/home.jpg'></a>");
		   
		   pw.close();
		}
 



}
