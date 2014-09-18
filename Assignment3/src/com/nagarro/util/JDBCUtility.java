package com.nagarro.util;

import static com.nagarro.constants.DatabaseConstants.DB_URL;
import static com.nagarro.constants.DatabaseConstants.PASS;
import static com.nagarro.constants.DatabaseConstants.USER;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * The Class JDBCUtility.
 * 
 * @author rishabgandhar
 */
public class JDBCUtility {

	/** The connection. */
	private static Connection connection;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public static Connection getConnection() {
		return connection;
	}
}
