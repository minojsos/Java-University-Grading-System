package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Students {
	private float gpa;
	
	static double count = 0;
	static int windowOpen = 0;
	static int studentID = 0;
	static int stuID = 0;
	
	//INSERT the student to the 'students' table
	public void setStudents(int stuID, String stuName, String eligible, double gpa){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement setVal = conn.prepareStatement("INSERT INTO students (id,name,gpa,eligible) VALUES(?,?,?,?)");
			setVal.setInt(1,stuID);
			setVal.setString(2, stuName);
			setVal.setDouble(3, gpa);
			setVal.setString(4, eligible);
			setVal.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
		
	}
	
	//Validate the Student ID - Check if Student ID already exists
	public boolean validateID(int stuID){
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement findUser = conn.prepareStatement("SELECT id FROM students WHERE id= ?");
			findUser.setInt(1, stuID);
			ResultSet result = findUser.executeQuery();
			
			if(result.first()){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){System.out.println(e);}
		
		return true;
	}
}
