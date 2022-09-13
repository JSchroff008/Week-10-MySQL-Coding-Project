package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {
	private static String HOST = "localhost";
	private static String PASSWORD = "project";
	private static int PORT = 3306;
	private static String SCHEMA = "project";
	private static String USER = "project";

	public static Connection getConnection() {
		String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false", HOST, PORT, SCHEMA, 
				USER, PASSWORD);
		System.out.println("Connecting with user = " + url);

		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Successfully obatained connection!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Error getting connection.");
			throw new DbException(e);
		}
	}

}