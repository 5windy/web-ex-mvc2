package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/web_ex";
			String user = MY_PASSWORD;
			String password = MY_PASSWORD;
			
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Database 연동 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Database 연동 실패");
		}
		
		return conn;
	}

}
