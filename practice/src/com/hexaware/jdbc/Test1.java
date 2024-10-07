package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//load the driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("driver class loaded");
		
		//get the connection 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root", "root");
		
		System.out.println("i got the connection");
		
		Statement statement = connection.createStatement();
		
		int x = statement.executeUpdate("insert into student values(105,'rese')");
		
		System.out.println(x + "row(s) inserted");
		
		//close the connection 
		connection.close();
		
	}

}
