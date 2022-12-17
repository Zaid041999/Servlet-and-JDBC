//Code to execute the batch w.r.t Statement
package com.jsp.testApp;

import java.sql.*;

public class Batch_update {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;

		String inQry = "insert into employee.empdetails values(12,'Aru','Technical')";
		String upQry = "update product.productrecords set Pname='Fans' where Pid =7 ";
		String delQry = "delete from student.studentrecords where id =31 ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Step 1 done");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			System.out.println("Step 2 done");

			stmt = con.createStatement();
			System.out.println("Step 3 done!!");

			// Added the qry into the batch
		    stmt.addBatch(inQry);
			stmt.addBatch(upQry);
			stmt.addBatch(delQry);

			// Execute the batch

			int[] ar = stmt.executeBatch();
			System.out.println("Size of the array :-" + ar.length);
			System.out.println("Finished");
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			if(stmt!=null) {
				try {
					stmt.close();
					System.out.println("Statement closed !!!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
					System.out.println("Connection closed !!!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
