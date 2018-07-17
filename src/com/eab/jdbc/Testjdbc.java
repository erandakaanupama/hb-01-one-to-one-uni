package com.eab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;



public class Testjdbc {

	public static void main(String[] args) {
	
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user="hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to db: " + jdbcUrl);
			Connection myConn = 
					DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("connection successful");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
