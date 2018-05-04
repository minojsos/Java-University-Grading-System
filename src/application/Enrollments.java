package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Used to store the enrollment details of each Student to the database
 */
public class Enrollments {
	private int studID;
	private String modCode;
	private int totalMarks;
	private int attendance;
	private int credits;
	private float gradePoint;
	private String passOrFail;
	private String grade;
	int totCredits;
	double creditsGP;
	
	Modules mod = new Modules();
	Settings settings = new Settings();
	Students student = new Students();
	
	//Enrollmets Constructor
	public Enrollments(int studID, String modCode, int totalMarks, int attendance, int credits, int gradePoint, String passOrFail, String grade){
		this.studID = student.stuID;
		this.modCode = modCode;
		this.totalMarks = totalMarks;
		this.attendance = attendance;
		this.credits = credits;
		this.gradePoint = gradePoint;
		this.passOrFail = passOrFail;
		this.grade = grade;
	}
	
	//Enrollment for Research, Industrial Research and Seminar Module
	public void setEnrollOthers(int stuID, String modCode, int credits, double totalMarks, int attendance, String grade){
		String passOrFail;
		double gradePoint = 0;
		//Determine if Pass or Fail Given the grade
		switch(grade){
		case "A+": 
		case "A":
		case "A-":
		case "B+":
		case "B":
		case "B-":
		case "C+":
		case "C":{
			passOrFail = "PASS";
			break;
		}
		default:{
			passOrFail = "FAIL";
			break;
		}
		}
		
		switch(grade){
		case "A+":{
			gradePoint = 4.0;
			break;
		}
		case "A":{
			gradePoint = 4.0;
			break;
		}
		case "A-":{
			gradePoint = 3.7;
			break;
		}
		case "B+":{
			gradePoint = 3.3;
			break;
		}
		case "B":{
			gradePoint = 3.0;
			break;
		}
		case "B-":{
			gradePoint = 2.7;
			break;
		}
		case "C+":{
			gradePoint = 2.3;
			break;
		}
		case "C":{
			gradePoint = 2.0;
			break;
		}
		case "F":{
			gradePoint = 0;
		}
		}
		
		if(attendance<((80/100)*mod.getModHours(modCode))){
			passOrFail = "FAIL";
		}else{
			passOrFail = "PASS";
		}
		
		//If Fail, no credits for that module
		if(passOrFail == "FAIL"){
			credits = 0;
		}
		
		totCredits += credits;
		creditsGP += (credits*gradePoint);
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement setVal = conn.prepareStatement("INSERT INTO enrollment (studID,modCode,totalMarks,attendance,credits,gradePoint,passOrFail,grade) VALUES (?,?,?,?,?,?,?,?)");
			setVal.setInt(1, stuID);
			setVal.setString(2, modCode);
			setVal.setDouble(3, totalMarks);
			setVal.setInt(4, attendance);
			setVal.setInt(5, credits);
			setVal.setFloat(6, 0.0f);
			setVal.setString(7, passOrFail);
			setVal.setString(8, grade);
			setVal.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
	}
	
	//Enrollment For Preliminary Module
	public void setEnrollOptional(int stuID, String modCode, double totalMarks, int attendance, String grade){
		String passOrFail;
		
		//Determine if the person has passed or failed using the given grade
		switch(grade){
		case "A+": 
		case "A":
		case "A-":
		case "B+":
		case "B":
		case "B-":
		case "C+":
		case "C":{
			passOrFail = "PASS";
			break;
		}
		default:{
			passOrFail = "FAIL";
			break;
		}
		}
		
		if(attendance<((80/100)*mod.getModHours(modCode))){
			passOrFail = "FAIL";
		}else{
			passOrFail = "PASS";
		}
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			//INSERT the data into 'enrollment' table
			PreparedStatement setVal = conn.prepareStatement("INSERT INTO enrollment (studID,modCode,totalMarks,attendance,credits,gradePoint,passOrFail,grade) VALUES (?,?,?,?,?,?,?,?)");
			setVal.setInt(1, stuID);
			setVal.setString(2, modCode);
			setVal.setDouble(3, totalMarks);
			setVal.setInt(4, attendance);
			setVal.setInt(5, 0);
			setVal.setFloat(6, 0.0f);
			setVal.setString(7, passOrFail);
			setVal.setString(8, grade);
			setVal.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
	}
	
	
	//Enrollment for Core and Optional Modules
	public void setEnroll(int stuID, String modCode, double totalMarks, int attendance, int credits, double gradePoint, String passOrFail){
		
		//Determine the grade given the gradePoint
		if(gradePoint > 4.0){
			grade = "A+";
		}else if(gradePoint == 4.0){
			grade = "A";
		}else if(gradePoint < 4.0 && gradePoint >= 3.7){
			grade = "A-";
		}else if(gradePoint < 3.7 && gradePoint >= 3.3){
			grade = "B+";
		}else if(gradePoint < 3.3 && gradePoint >= 3.0){
			grade = "B";
		}else if(gradePoint < 3.0 && gradePoint >= 2.7){
			grade = "B-";
		}else if(gradePoint < 2.7 && gradePoint >= 2.3){
			grade = "C+";
		}else if(gradePoint < 2.3 && gradePoint >= 2.0){
			grade = "C";
		}else{
			grade = "F";
		}
		
		if(gradePoint < 2){
			gradePoint = 0;
		}
		//If Fail, no credits for that module
		if(passOrFail == "FAIL"){
			credits = 0;
		}
		totCredits += credits;
		creditsGP += (credits*gradePoint);
		
		
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			//INSERT data into the 'enrollment' table
			PreparedStatement setVal = conn.prepareStatement("INSERT INTO enrollment (studID,modCode,totalMarks,attendance,credits,gradePoint,passOrFail,grade) VALUES (?,?,?,?,?,?,?,?)");
			setVal.setInt(1, stuID);
			setVal.setString(2, modCode);
			setVal.setDouble(3, totalMarks);
			setVal.setInt(4, attendance);
			setVal.setInt(5, credits);
			setVal.setDouble(6, gradePoint);
			setVal.setString(7, passOrFail);
			setVal.setString(8, this.grade);
			setVal.executeUpdate();
			
		}catch(Exception e){System.out.println(e);}
		
	}
	
	//Validate Grade in Preliminary Modules
	public boolean validGradeO(String grade){
		//If input grade is valid, return true ELSE false
		switch(grade){
		case "A+":
		case "A":
		case "A-":
		case "B+":
		case "B":
		case "B-":
		case "C+":
		case "C": 
		case "F":{
			return true;
		}
		default:{
			return false;
		}
		}
		
	}
	
	//Find the total given the End Of Module Examination Total Marks and Continuous Assessment Total Marks.
	public double findTotal(int eme, int ca){
		//Obtain the weightage percentage values from 'settings' table - Methods in settings class used
		int endOfMod = settings.getEndOfMod();
		int contAsses = settings.getContAsses();
		//Calculate total using the obtain values and return total
		double total = (((double)endOfMod/100)*eme) + (((double)contAsses/100)*ca);
		
		return total;
	}
	
	//Determine if "PASS" or "FAIL" - Uses the input gradePoint, Attended Hours and Module Hours
	public String passorfail(float gradePoint, int hours, String modCode){
		int modHours = 0;
		String passorfail = null;
		try{
			
			new databaseConnect();
			Connection conn = databaseConnect.getConnection();
			
			PreparedStatement findHours = conn.prepareStatement("SELECT modHours FROM modules WHERE modCode = ?");
			findHours.setString(1, modCode);
			ResultSet result = findHours.executeQuery();
			
			/*If Attended Hours >= 80% of Module Hours AND Grade Point >= 2.0 - "PASS"
			 * OR
			 * If Module Hours == 0 AND Grade Point >= 2.0 - "PASS"
			 * ELSE
			 * "FAIL"
			 */
			if(result.first()){
				modHours = result.getInt("modHours");
				if(gradePoint >= 2.0 && (hours>=(80/100*modHours))){
					passorfail = "PASS";
				}else if(gradePoint >= 2.0 && modHours == 0){
					passorfail = "PASS";
				}else{
					passorfail = "FAIL";
				}
			}
		}catch(Exception e){System.out.println(e);}
		
		return passorfail;
	}
	
	
	//Determine the eligibility of the student given the gpa and the total credits
	public String getEligible(int credits, double gpa){
		
		String eligible = "Not Eligible";
		
		if(credits >= 25 && credits < 30 && (gpa>=2.75 && gpa<=2.99)){
			eligible = "Postgraduate Diploma in Computer Science";
		}else if(credits >= 30 && credits < 45){
			if(gpa>=3.00 && gpa<=3.49){
				eligible= "MSc by Coursework with Pass";
			}else if(gpa>=3.50 && gpa <=3.69){
				eligible = "MSc by Coursework with Merit";
			}else if(gpa>=3.70 && gpa<=4.0){
				eligible = "MSc by Coursework with Distinction";
			}
		}else if(credits >= 45 && credits < 60){
			if(gpa>=3.00 && gpa<=3.49){
				eligible = "MSc by Coursework and Research with Pass";
			}else if(gpa>=3.50 && gpa <=3.69){
				eligible = "MSc by Coursework and Research with Merit";
			}else if(gpa>=3.70 && gpa<=4.00){
				eligible = "MSc by Coursework and Research with Distinction";
			}
		}else if(credits >= 60){
			if(gpa>=3.00 && gpa<=3.49){
				eligible= "MSc by Research with Pass";
			}else if(gpa>=3.50 && gpa <=3.69){
				eligible = "MSc by Research with Merit";
			}else if(gpa>=3.70 && gpa<=4.00){
				eligible = "MSc by Research with Distinction";
			}
		}
		
		return eligible;
	}
}
