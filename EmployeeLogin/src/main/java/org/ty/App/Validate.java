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
@WebServlet("/validate")
public class Validate extends HttpServlet {
	
	

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String uname = req.getParameter("un");
			String pass = req.getParameter("pwd");

			PrintWriter output = resp.getWriter();
			String Qry = "Select * from login.logindetails where username =? and password = ? ";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
				PreparedStatement pstmt = con.prepareStatement(Qry);
				pstmt.setString(1, uname);
				pstmt.setString(2, pass);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					RequestDispatcher rd = req.getRequestDispatcher("/welcome");
					rd.forward(req, resp);
				} else {
					output.print(
							"<html><body bgcolor = 'skyblue'> " + "<br>" + "<h2>Sorry!!! Username or Password is incorrect"
									+ "</h2>" + "<h3>Please enter valid input</h3>" + "" + "</body></html>");
					RequestDispatcher rd = req.getRequestDispatcher("login.html");
					rd.include(req, resp);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}

