package util;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static String url = "jdbc:mysql://localhost:3307/dbcrud";
	private static String user = "root";
	private static String password = "1234";

	private static String driver = "com.mysql.cj.jdbc.Driver";

	private static Connection con = null;

	public static Connection getCon() {

		
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					

		return con;
	}

}
