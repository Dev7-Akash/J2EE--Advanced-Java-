package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class LifeCycleTestServlet extends HttpServlet {

	static {
		System.out.println("LifeCycleTestServlet:: Static Block");
	}
	
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet::0-param Constructor");
	}
	
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	System.out.println("LifeCycleTestServlet:: init(-)Method");
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("LifeCycleTestServlet:: service(-) Method");
    	
    	PrintWriter pw=res.getWriter();
    	
    	res.setContentType("text/html");
    	
    	Date date=new Date();
    	
    	pw.println("<h1 style='color:blue;text-align:center'>Date And Time :: "+date+"</h1>");
    	
    	pw.close();
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	System.out.println("LifeCycleTestServlet::destroy(-) Method");
    }
}
