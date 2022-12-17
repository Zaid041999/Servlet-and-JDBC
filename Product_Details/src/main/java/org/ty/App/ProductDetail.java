package org.ty.App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class ProductDetail extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String Pid = req.getParameter("id");
		int id = Integer.parseInt(Pid);
		
		String name = req.getParameter("nm");
		
		String Pprice = req.getParameter("pr");
		int price = Integer.parseInt(Pprice);
		
		String Pquantity = req.getParameter("qty");
		int quantity = Integer.parseInt(Pquantity);
		
		        // JDBC code
		
				String inQry = "insert into  product.productrecords values(?,?,?,?)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

					// Prepared Statement
					PreparedStatement pstmt = con.prepareStatement(inQry);

					// Set the data for placeholder ---> setxxx()
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setInt(3, price);
					pstmt.setInt(4, quantity);
					

					pstmt.executeUpdate();
				} catch (Exception e) {

					e.printStackTrace();
				}
	}

}
