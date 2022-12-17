package com.jsp.testApp;
//Insert multiple record in multiple database
import java.sql.*;
public class Dml3 {

	public static void main(String[] args) {
	
		try {
			
			//Load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1 done");
			
			//Establish connection with database server and java
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Step 2 done");
			
			//Create a Statement or platform
			Statement stmt = con.createStatement();
			System.out.println("Step 3 done!!");
			
			//Execute the sql queries
		//	stmt.executeUpdate("insert into student.studentrecords values(1,'Adam',20)");
			//stmt.executeUpdate("insert into student.studentrecords values(2,'John',22)");
			stmt.executeUpdate("insert into product.productrecords values(6,'Belt',20)");
			stmt.executeUpdate("insert into product.productrecords values(7,'keychain',20)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
