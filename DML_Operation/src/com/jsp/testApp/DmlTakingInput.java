package com.jsp.testApp;
import java.util.Scanner;
import java.sql.*;

public class DmlTakingInput {

	public static void main(String[] args) {
//		String inQry = "insert into  student.studentrecords values(?,?,?)";
//		//String inQry = "Delete from student.studentrecords where id = ?";
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the id: ");
//		int id = sc.nextInt();
//		
//	    System.out.println("Enter the name ");
//		String name = sc.next();
//		
//		System.out.println("Enter the age: ");
//		int age = sc.nextInt();
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
//			
//			//Prepared Statement
//			PreparedStatement pstmt = con.prepareStatement(inQry);
//			
//			//Set the data for placeholder ---> setxxx()
//			pstmt.setInt(1, id);
//			pstmt.setString(2, name);
//		    pstmt.setInt(3, age);
//			
//			pstmt.executeUpdate();
//			System.out.println("Finished");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String inQry ="insert into student.studentrecords values(?,?,?)";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id:");
		int id = sc.nextInt();
		System.out.println("Enter the name:");
		String name = sc.next();
		System.out.println("Enter the age:");
		int age = sc.nextInt();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			//prepared Statement
			PreparedStatement pstmt = con.prepareStatement(inQry);
			
			//Set the data for placeholder ---> setxxx()
			pstmt.setInt(1,id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
