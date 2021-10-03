package com.bridgelabz.employeepayrolljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1/payroll_service";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Connection established successfully..!!");
		} catch (SQLException e) {
			System.out.println(e);
		}
		return connection;
	}
}
