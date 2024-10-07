package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test4 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root", "root");
		Statement statement = connection.createStatement();
		statement.addBatch("insert into student values(108,'lalitha')");
		statement.addBatch("update student set stname='ram' where stid=100");
		statement.addBatch("delete from student where stid=105");
		
		int x[] = statement.executeBatch();
		
		System.out.println(x[0] + "row(s) inserted");
		System.out.println(x[1] + "row(s) updated");
		System.out.println(x[2] + "row(s) deleted");
	}

}
