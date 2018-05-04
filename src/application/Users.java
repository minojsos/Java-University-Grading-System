package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Users {
	private String username;
	private String password;
	private int role;
	static String uSerName;
	static int id;
	
	
	//Retrieve the name and the ID of the Student when the student makes a valid login
	public static void userName(String username){
		
		try{
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT name FROM students WHERE id= ?");
			retrieve.setString(1, username);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				uSerName = result.getString("name");
				id = Integer.parseInt(username);
			}
			
		}catch(Exception e){System.out.print(e);}
	}
	
	//Store the user to the 'users' table given the Admin provides valid values
	public void setUser(String password, int stuID){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement set = conn.prepareStatement("INSERT INTO users (username,password,role) VALUES (?,?,?)");
			set.setString(1, String.valueOf(stuID));
			set.setString(2, password);
			set.setInt(3, 1);
			set.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
	}
	
	/*Validate the login
	 * Check if the Input Username and Password combination exists in the database
	 * If it does, let the student or admin login to their account
	 */
	public static boolean validateLogin(String username, String password){
		boolean valid = false;
		
		try {
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
	        PreparedStatement retrieve = conn.prepareStatement("SELECT password FROM users WHERE username= '"+username+"'");
			ResultSet result = retrieve.executeQuery();
			
			if(result.first() && result.getString("password").equals(password)) {
				valid = true;
	        }
	        
	    }catch(Exception e){System.out.println(e);}
		
		return valid;
	}
	
	/* Retrieve the user Role from the database.
	 * If the login details are valid and role = 0, then Admin
	 * Else if the login details are valid and role = 1, then Student
	 * else invalid login details
	 */
	public static boolean getRole(String username, String password){
		
		try{
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			PreparedStatement retrieve = conn.prepareStatement("SELECT role FROM users WHERE username = ? AND password = ? AND role = ?");
			retrieve.setString(1, username);
			retrieve.setString(2, password);
			retrieve.setString(3, "0");
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return true;
			}
			else{
				return false;
			}
		}catch(Exception e){System.out.println(e);}
		
		return false;
	}
	
	
}
