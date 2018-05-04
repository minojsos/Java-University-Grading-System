package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * Contains the methods when searching for a student.
 */
public class Search {
	private int stuID;
	private String stuName;
	private float gpa;
	private String eligible;
	
	//Search Constructor
	public Search(int stuID, String stuName, float gpa, String eligible){
		this.stuID = stuID;
		this.stuName = stuName;
		this.gpa = gpa;
		this.eligible = eligible;
	}
	
	//Validate the Student ID - Check if Student ID exists in 'students' table
	public static boolean validStuID(int stuID){
		
		try{
			
			Connection conn = new databaseConnect().getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT id FROM students WHERE id= ?");
			retrieve.setLong(1, stuID);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return true;
			}
			else{
				return false;
			}
			
		}catch(Exception e){System.out.print(e);}
		
		return false;
	}
	
	//Retrieve Student Name given the valid Student ID
	public static String getStuName(int stuID){
		
		try{
			
			Connection conn = new databaseConnect().getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT name FROM students WHERE id= ?");
			retrieve.setLong(1, stuID);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return result.getString("name");
			}
			else{
				return "error";
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return null;
	}
	
	//Retrieve the Student's GPA given the valid student ID
	public static float getGPA(int stuID){
		
		try{
			
			Connection conn = new databaseConnect().getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT gpa FROM students WHERE id= ?");
			retrieve.setLong(1, stuID);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return result.getInt("gpa");
			}
			else{
				return 0.0f;
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return 0;
	}
	
	//Retrieve the Students Eligibility given the valid Student ID
	public static String getEligible(int stuID){
		
		try{
			
			Connection conn = new databaseConnect().getConnection();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT eligible FROM students WHERE id= ?");
			retrieve.setLong(1, stuID);
			ResultSet result = retrieve.executeQuery();
			
			if(result.first()){
				return result.getString("eligible");
			}
			else{
				return "error";
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return null;
	}
}
