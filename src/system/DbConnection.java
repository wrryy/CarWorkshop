package system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/CarWork?useSSL=false";
	private static String DB_USER = "root";
	private static String DB_PASS = "coderlsab";

	public static Connection connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {

		}
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
}
