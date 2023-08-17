package com.scm_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class queryinsert {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result = 0;
		try {
			// register the database
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// get connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet50", "root", "root");
			// create statement
			Statement state = con.createStatement();
			String query = "insert into frnds values(1,'Sneha','Manual',null);";
			// execute query
			result = state.executeUpdate(query);
		}
	
   catch (Exception e) {
	
	   
}
		finally {
			if(result>0)
			{
				System.out.println("Data inserted successfully");
			}
			else {
			 System.err.println("Data not inserted");
			}
		}
}
}