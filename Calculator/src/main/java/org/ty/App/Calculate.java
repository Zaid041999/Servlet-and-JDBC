package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Calculate extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		String Cnum1 = req.getParameter("num1");
		int num1 = Integer.parseInt(Cnum1);//wrapper class

		String Cnum2 = req.getParameter("num2");
		int num2 = Integer.parseInt(Cnum2);

		int add = num1 + num2;
		int sub = num1 - num2;
		int mult = num1 * num2;
		int div = num1 / num2;
		
		// in different page using html from the servlet
		PrintWriter output = resp.getWriter();
		output.print("<html><body><h2>Addition is "+add+"</h2><br>"+"<h2>Substraction is "+sub+"</h2><br>"
				+"<h2>Multiplication is "+mult+"</h2><br>"+"<h2>Division is "+div+"</h2><br>"
				+"<h2>Thank You !!</h2>"+"</body></html>");
		
	}

}
