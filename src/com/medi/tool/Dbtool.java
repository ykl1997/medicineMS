package com.medi.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbtool {

	private static String USERNAMR = "admin";
	private static String PASSWORD = "123456";
	private static String DRVIER = "oracle.jdbc.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@192.168.80.128:1521:bule";

	public static Connection getConnection() {
		Connection connection = null;
		if (connection == null) {
			try {
				Class.forName(DRVIER);
				connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("class not find !", e);
			} catch (SQLException e) {
				throw new RuntimeException("get connection error!", e);
			}
		}
		return connection;
	}

}
