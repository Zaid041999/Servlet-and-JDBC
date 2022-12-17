package org.emp.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Http_servlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String eid = req.getParameter("id");
		int id = Integer.parseInt(eid);
		
		String name = req.getParameter("nm");
		String dept = req.getParameter("dp");

		// in different page using html from the servlet

		// PrintWriter <-- print ("<html></html>");
		// class --> getWriter() --->ServletResponse
		PrintWriter output = resp.getWriter();
		output.print("<html><body bgcolor='cyan'>" + "<h1>Registration Completed !!" + "</h1>" + "<br>" + "<h2>Details are:-</h2>"
				 + "<h3>Id =" + id + "</h3>"  + "<h3>Name =" + name + "</h3>"  + "<h3>Dept = "
				+ dept + "" + "</h3></body></html>");

		// JDBC code
		String inQry = "insert into  employee.empdetails values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

			// Prepared Statement
			PreparedStatement pstmt = con.prepareStatement(inQry);

			// Set the data for placeholder ---> setxxx()
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, dept);

			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
