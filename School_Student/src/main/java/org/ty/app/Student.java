package org.ty.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Student extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		String Sid = req.getParameter("id");
		int id = Integer.parseInt(Sid);

		String name = req.getParameter("nm");

		String Sage = req.getParameter("ag");
		int age = Integer.parseInt(Sage);

		String grade = req.getParameter("gd");

		// to display from different html page to servlet

		PrintWriter output = resp.getWriter();
		output.print("<html><body><h1>Successfully saved the record !!!</h1><br><br>" + "<h2>Id : " + id + "</h2><br><br>"
				+ "<h2>Name : " + name + "</h2><br><br>" + "<h2>Age : " + age + "</h2><br><br>" + "<h2>grade : " + grade
				+ "</h2><br><br>"+"</body></html>");
		
		
		//JDBC Code
		String inQry ="insert into school_student.studentrecord values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement(inQry);
			
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3, age);
			pstmt.setString(4,grade);
			
			pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
