package org.mql.test.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;


public class App1 {

	public App1() {
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to database :"+jdbcUrl);
			 Connection con = DriverManager.getConnection(jdbcUrl , user , password);
			System.out.println("Connection successful !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new App1();

	}

}
