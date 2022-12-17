package com.jsp.testApp;
//Insert multiple record in single database
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dml2 {

	public static void main(String[] args) {
		
		
		try {
			//load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Step 1 done");
			
			//Establish connection with the database server and java
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Step 2 done");
			
			//Create a Statement or a platform
			Statement stmt = con.createStatement();
			System.out.println("Step 3 done!!");
			
			//Execute the sql queries
			stmt.executeUpdate("insert into product.productrecords values(2,'bag',10)");
     		stmt.executeUpdate("insert into product.productrecords values(3,'shirt',30)");
			stmt.executeUpdate("insert into product.productrecords values(4,'Jeans',30)");
			stmt.executeUpdate("insert into product.productrecords values(5,'socks',10)");
		
		} catch (Exception e) 
		{
			
			e.printStackTrace();
		} 
		

	}

}
