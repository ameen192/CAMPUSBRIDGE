package edu.campus.utility;

import java.sql.*;

public class Conn {
	static Connection con;
	static Statement stmt;
	static int count;
	private Conn() {

		try{
			if(stmt == null){
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/pandas","root","dinga");
				stmt = con.createStatement();
				count++;
			}

		}catch(Exception e){
			System.out.println("connection failed ");
		}
	}
	public Statement getStmt(){
		System.out.println("no of times connection is created "+count);
		return stmt;
	}
}
