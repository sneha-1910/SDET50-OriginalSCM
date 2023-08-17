package com.scm_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class selectqueryTEST {

	public static void main(String[] args) throws SQLException {

		// TODO Auto-generated method stub
		Connection con = null;
		ResultSet result = null;
		//try {
			// register the database----1
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// get connection----2
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet50", "root", "root");
			// create statement----3
			Statement state = con.createStatement();
			String query = "select* from frnds";
			// execute query----4
			result = state.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " "
						+ result.getString(4));
			}
		} 
	//catch (Exception e) {

		//} 
   //finally {
			// close database connection-----5
			//con.close();
		//}

	}

//}
