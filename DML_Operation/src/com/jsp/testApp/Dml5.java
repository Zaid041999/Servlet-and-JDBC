package com.jsp.testApp;
//perform delete operation 
import java.sql.*;
public class Dml5 {

	public static void main(String[] args) {
		
		try {
			//Load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1 done");
			
			//Establish connection with database server and java
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Step 2 done");
			
			//Create a statement or platform
			Statement stmt = con.createStatement();
			System.out.println("Step 3 done!!");
			
			//Execute the sql queries
			stmt.executeUpdate("Delete from student.studentrecords  where id =6 ");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
