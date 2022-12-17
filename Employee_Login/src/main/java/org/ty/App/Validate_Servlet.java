package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Validate_Servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("un");
		String pass= req.getParameter("pwd");
		
		PrintWriter out=resp.getWriter();
		
		String Qry ="Select * from login.logindetails where username=? and password=? ";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&pass=root");
			PreparedStatement pstmt = con.prepareStatement(Qry);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs= pstmt.executeQuery();	
			if(rs.next()) {
				RequestDispatcher rd = req.getRequestDispatcher("/welcome");
				rd.forward(req, resp);
			}else {
				out.print("<html><body bgcolor='cyan'><h1>Sorry !!! Username or Password is incorrect</h1><br>"+
			"<h2>Please enter valid cradentials</h2>"+"</body></html>");
				RequestDispatcher rd =req.getRequestDispatcher("Login.html");
				rd.include(req, resp);
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
