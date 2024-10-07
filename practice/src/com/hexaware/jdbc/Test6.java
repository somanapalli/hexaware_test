package com.hexaware.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test6 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hexaware", "root","root");
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		statement.addBatch("update rama set bal=bal-10000 where accno=1000");
		statement.addBatch("update sitha set bal=bal+10000 where accno=1001");
		int x[] = statement.executeBatch();
		
		if(x[0] > 0 & x[1] > 0) {
			connection.commit();
			System.out.println("funds transferred successfully, have a great day...");
		}
		else
		{
			connection.rollback();
			System.out.println("something went wrong in your account, please check it once");
		}
		
	}
	

}
