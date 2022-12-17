package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")

public class Welcome extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("un");
		String pass = req.getParameter("pwd");

		PrintWriter output = resp.getWriter();
		String Qry = "Select * from login.logindetails where username = ? and password = ? ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt = con.prepareStatement(Qry);
			pstmt.setString(1, uname);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String usern = rs.getString(1);
				String passw = rs.getString(2);
				int id1 = rs.getInt(3);
				String name = rs.getString(4);
				String dept = rs.getString(5);
				//rd.forward(req, resp);
				output.print("<html><body bgcolor = 'cyan'> " + "<br>" + "<h2>Details are:-</h2>" + "<h3>Id =" + id1
						+ "</h3>" + "<h3>Name =" + name + "</h3>" + "<h3>Dept = " + dept + "" + "</h3></body></html>");

			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
