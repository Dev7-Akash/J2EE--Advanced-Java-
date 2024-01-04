package com.nit.jdbc1;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LobInsertionTest {
	
	private static final String Insert_Actor_Info="INSERT INTO ACTOR_INFO VALUES(AIF_SEQ.NEXTVAL,?,?,?)";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "AKKI", "7597");
    		  Scanner sc=new Scanner(System.in);
    		  PreparedStatement ps=con.prepareStatement(Insert_Actor_Info);
    		  ){
    	  //Read input from end user
    	  String name=null, photopath=null, profilepath=null;
    	  if(sc!=null) {
    		  System.out.println("Enter Actor Name::");
    		  name=sc.next();
    		  System.out.println("Enter Actor's Photo Path");
    		  photopath=sc.next().trim().replace("?", "");
    		  System.out.println("Enter Actors's Profile Path");
    		  profilepath=sc.next().trim().replace("?", "");
    		      		  
    	  }//if
    	  //Create Stream obj points to the file
    	  try(InputStream is=new FileInputStream(photopath);
    			  Reader reader=new FileReader(profilepath)){
    		  
    		  //set values to query param
    		  if(ps!=null){
    			  ps.setString(1, name);
    			  ps.setBinaryStream(2, is);
    			  ps.setCharacterStream(3, reader);
    			  
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
