package com.jsp.testApp;

import java.sql.*;

public class Dql {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			 stmt = con.createStatement();
			
			 rs = stmt.executeQuery("Select * from student.studentrecords");
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				
				System.out.println("Id :" +id+ " name is " +name+ " and age is "+age);
				/*System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));*/
				/*System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));*/
			}
		} catch (Exception e) {
		
			e.printStackTrace(); 
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
					System.out.println("ResultSet closed !!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			if(stmt!=null) {
				try {
					stmt.close();
					System.out.println("Statement closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
					System.out.println("Connection closed !!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
