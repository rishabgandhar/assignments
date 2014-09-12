package com.nagarro.util;

import static com.nagarro.constants.DatabaseConstants.DB_URL;
import static com.nagarro.constants.DatabaseConstants.PASS;
import static com.nagarro.constants.DatabaseConstants.USER;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtility {
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}
}
