package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class databaseConnect {
	
	//Setup a connection to the database
	public static Connection getConnection() throws Exception{
		
		//Credentials to connect to the database - If successfully connected, Output CONNECTED
		try{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/coursework?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
}
