package com.jsp.testApp;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Dml {

	public static void main(String[] args) {
	 
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("Step 1 done");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
//			System.out.println("Step 2 done");
//			
//			Statement stmt = con.createStatement();
//			System.out.println("Step 3 done!!");
//			
//			//Execute sql queries
//		//	stmt.executeUpdate("insert into student.studentrecords values(11,'scott',21)");
//		//	stmt.executeUpdate("insert into product.productrecords values(1,'shoes',20)");
//			
//			//stmt.executeUpdate("update student.studentrecords set name ='Miller',age=22 where id=11");
//			
//		} catch (Exception e)
//		{
//			
//			e.printStackTrace();
//		}
//
//	}
		try {
			//Load and register the driver class
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("step1 done");
			//Establish the connection between java and database server
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("step2 done");
			//Create a statement or a platform
			Statement stmt = con.createStatement();
			System.out.println("step3 done");
			//Execute the sql query
		//	stmt.executeUpdate("insert into student.studentrecords value(1,'Queen',22)");
		//	stmt.executeUpdate("update student.studentrecords set name='Arun',age=22 where id =1 ");
			stmt.executeUpdate("Delete from student.studentrecords where id =7");
			System.out.println("step4 done !!!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

}
}
