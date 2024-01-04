package com.nit.jdbc;

import java.sql.*;

class SqlTest 
{
	public static void main(String[] args) throws Exception
	{
		//Establish the connection with DB s/w
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","AKKI","7597");

		//To create jdbc statement obj

		Statement st=con.createStatement();

		//create sql query process

		ResultSet rs=st.executeQuery("SELECT * FROM STUDENT");

		while(rs.next()!=false){

			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
		}

	}
}
