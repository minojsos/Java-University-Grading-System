package application;

import javafx.beans.property.*;

/*
 * Find values to Display the Enrollment Details in Table View
 * Enrollment Details for a given student is taken from the database
 */
public class EnrollmentDetails {
	
	Students student = new Students();
	private int stuID = student.stuID;
	private final StringProperty modCodeCol;
	private final IntegerProperty totalMarksCol;
	private final IntegerProperty attendanceCol;
	private final IntegerProperty creditsCol;
	private final FloatProperty gradePointCol;
	private final StringProperty passCol;
	private final StringProperty gradeCol;
	
	//EnrollmentDetails Constructor
	public EnrollmentDetails(String modCode, int totalMarks, int attendance, int credits, float gradePoint, String passOrFail, String grade){
		
		this.modCodeCol = new SimpleStringProperty(modCode);
		this.totalMarksCol = new SimpleIntegerProperty(totalMarks);
		this.attendanceCol = new SimpleIntegerProperty(attendance);
		this.creditsCol = new SimpleIntegerProperty(credits);
		this.gradePointCol = new SimpleFloatProperty(gradePoint);
		this.passCol = new SimpleStringProperty(passOrFail);
		this.gradeCol = new SimpleStringProperty(grade);
		
	}
	
	/*
	 * Given the Student ID = student.stuID
	 * Get and Set Module Code
	 */
	public String getModCodeCol(){
		return modCodeCol.get();
	}
	
	public void setModCodeCol(String modCode){
		modCodeCol.set(modCode);
	}
	
	//Get and Set Total Marks for the Module
	public int getTotalMarksCol(){
		return totalMarksCol.get();
	}
	
	public void setTotalMarksCol(int totalMarks){
		totalMarksCol.set(totalMarks);
	}
	
	//Get and Set Attendance for the Module
	public int getAttendanceCol(){
		return attendanceCol.get();
	}
	
	public void setAttendanceCol(int attendance){
		attendanceCol.set(attendance);
	}
	
	//Get and Set Credits for the Module
	public int getCreditsCol(){
		return creditsCol.get();
	}
	
	public void setCreditsCol(int credits){
		creditsCol.set(credits);
	}
	
	//Get and Set the Grade Point for the Module
	public float getGradePointCol(){
		return gradePointCol.get();
	}
	
	public void setGradePointCol(float gradePoint){
		gradePointCol.set(gradePoint);
	}
	
	//Get and Set if Pass for the Module
	public String getPassCol(){
		return passCol.get();
	}
	
	public void setPassCol(String passOrFail){
		passCol.set(passOrFail);
	}
	
	//Get and Set the Grade for the Moudle
	public String getGradeCol(){
		return gradeCol.get();
	}
	
	public void setGradeCol(String grade){
		gradeCol.set(grade);
	}
	
	//Property Values
	public StringProperty modCodeColProperty(){
		return modCodeCol;
	}
	
	public IntegerProperty attendanceColProperty(){
		return attendanceCol;
	}
	
	public IntegerProperty totalMarksColProperty(){
		return totalMarksCol;
	}
	
	public IntegerProperty creditsColProperty(){
		return creditsCol;
	}
	
	public FloatProperty gradePointColProperty(){
		return gradePointCol;
	}
	
	public StringProperty passColProperty(){
		return passCol;
	}
	
	public StringProperty gradeColProperty(){
		return gradeCol;
	}
	
	
}
