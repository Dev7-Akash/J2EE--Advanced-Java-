package com.nit.jdbc1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class JobSeekerInfoInsert_Mysql {
	
	private static final String Insert_JobSeeker_Query="INSERT INTO JOB_SEEKER_INFO(JSNAME,ADDRESS,DOB,QLF,PHOTO,RESUME) VALUES(?,?,?,?,?,?)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try(Connection con=DriverManager.getConnection("jdbc:mysql:///akashdb","root", "7597");
    		  Scanner sc=new Scanner(System.in);
    		  PreparedStatement ps=con.prepareStatement(Insert_JobSeeker_Query);
    		  ){
    	  //Read input from end user
    	  String name=null,add=null,dob=null,qlf=null, photopath=null, resumepath=null;
    	  if(sc!=null) {
    		  System.out.println("Enter Job Seeker's Name::");
    		  name=sc.next();
    		  System.out.println("Enter Job Seeker's Address::");
    		  add=sc.nextLine();
    		  sc.nextLine();
    		  System.out.println("Enter Job Seeker's Dob::");
    		  dob=sc.next();
    		  System.out.println("Enter Job Seeker's Qualification::");
    		  qlf=sc.next();
    		  System.out.println("Enter Job Seeker's Photo Path::");
    		  photopath=sc.next().trim().replace("?", "");
    		  System.out.println("Enter Job Seeker's Resume Path");
    		  resumepath=sc.next().trim().replace("?", "");
    		      		  
    	  }//if
    	  
    	  //convert string date into java.sql.date class obj 
    	  SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
    	  java.util.Date udob=sdf.parse(dob);
    	  java.sql.Date sqdob=new java.sql.Date(udob.getTime());
    	  //Create Stream obj points to the file
    	  try(InputStream is=new FileInputStream(photopath);
    			  Reader reader=new FileReader(resumepath)){
    		  
    		  //set values to query param
    		  if(ps!=null){
    			  ps.setString(1, name);
    			  ps.setString(2, add);
    			  ps.setDate(3, sqdob);
    			  ps.setString(4, qlf);
    			  ps.setBinaryStream(5, is);
    			  ps.setCharacterStream(6, reader);
    			  
    			  //execute sql query
    			  int count=ps.executeUpdate();
    			  if(count==0) 
    				  System.out.println("Record Not Inserted");
    			  else
    				  System.out.println("Record Inserted Successfully");
    		
    		  }//if
    		  
    	  }//try2
    	  
      }//try
      catch (SQLException se) {
    	  se.printStackTrace();
		// TODO: handle exception
	}
      
      catch (Exception e) {
    	  e.printStackTrace();
		// TODO: handle exception
	}
      
	}//main

}//class
