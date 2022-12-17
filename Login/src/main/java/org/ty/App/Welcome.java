package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Welcome extends HttpServlet {
	int id1;
	String name;
	String dept;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("un");
		String pass = req.getParameter("pwd");

		String inQry = "select * from login.logindetails where username =? and password = ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement(inQry);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);

			ResultSet rs = pstmt.executeQuery();
			PrintWriter output = resp.getWriter();
			//Servlet Chaining
			RequestDispatcher rd = req.getRequestDispatcher("");
			if (rs.next()) {
				//user = rs.getString(1);
				//pass = rs.getString(2);
				id1 = rs.getInt(3);
				name = rs.getString(4);
				dept = rs.getString(5);
				//rd.forward(req, resp);
				output.print("<html><body bgcolor = 'cyan'> " + "<br>" + "<h2>Details are:-</h2>" + "<h3>Id =" + id1
						+ "</h3>" + "<h3>Name =" + name + "</h3>" + "<h3>Dept = " + dept + "" + "</h3></body></html>");

			} else {
				output.print("<html><body bgcolor = 'skyblue'> " + "<br>" + "<h2>Sorry!!! Username or Password is incorrect" + "</h2>"
						+ "<h3>Please enter valid input</h3>" +""+ "</body></html>");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
