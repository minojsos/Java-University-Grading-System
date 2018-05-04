package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Settings {
	
	//Retrieve the End Of Module Weightage value
	public int getEndOfMod(){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT endofmodule FROM settings WHERE id = ?");
			retrieve.setInt(1, 1);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return result.getInt("endofmodule");
			}
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
		
		return 0;
	}

	//Retrieve the Continuous Assessments weightage value
	public int getContAsses(){
	
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT continuousassessments FROM settings WHERE id = ?");
			retrieve.setInt(1, 1);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return result.getInt("continuousassessments");
			}
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
	
		return 0;
	}
	
	//Set the EndOfMod weightage value where the user inputs the value to the 'settings' table
	public void setEndOfMod(int value){

		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("UPDATE settings SET endofmodule = ? WHERE id = ?");
			retrieve.setInt(1, value);
			retrieve.setInt(2, 1);
			retrieve.executeUpdate();
			
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
		
	}
	
	//Set the Continuous Assessments value - (100 - endOfMod value) to the 'settings' table
	public void setContAsses(int value){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("UPDATE settings SET continuousassessments = ? WHERE id = ?");
			retrieve.setInt(1, value);
			retrieve.setInt(2, 1);
			retrieve.executeUpdate();
			
			conn.close();
		}catch(Exception e){System.out.println(e);}

	}
	
	//Set the password for the admin
	public void setPassword(String value){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
			retrieve.setString(1,value);
			retrieve.setString(2,"admin");
			retrieve.executeUpdate();
			
			conn.close();
		}catch(Exception e){System.out.println(e);}
		
	}
	
	//Get the password for the admin
	public String getPassword(){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT password FROM users WHERE id = ?");
			retrieve.setInt(1,1);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return result.getString("password");
			}else{
				return "ERROR";
			}
		}catch(Exception e){System.out.println(e);}
		
		return null;
	}
}
