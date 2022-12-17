package org.ty.app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Test extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		String place = req.getParameter("pl");

		// System.out.println(name+" "+place);

		// in different page using html from the servlet

		// PrintWriter <-- print ("<html></html>");
		// class --> getWriter() --->ServletResponse

//		PrintWriter output = resp.getWriter();
//		output.print("<html><body bgcolor = 'cyan'>" + "<h1>Details of Student:-" + name + " " + place + ""
//				+ "</h1></body></html>");
		
		PrintWriter output =resp.getWriter();
		output.print("<html><body bgcolor='pink'>" + "<h1>Details of Students:-" + name +" "+ place + "" +"</h1></body></html>");
	}

}
