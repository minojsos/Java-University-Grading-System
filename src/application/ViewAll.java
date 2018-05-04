package application;

import javafx.beans.property.*;

/*
 * Find values to Display all the Student Details in Table View
 * Student Details for all the students is taken from the database
 */
public class ViewAll {
	
	Students student = new Students();
	private final IntegerProperty idCol;
	private final StringProperty nameCol;
	private final FloatProperty gpaCol;
	private final StringProperty eligibleCol;
	
	//ViewAll Constructor
	public ViewAll(int id, String name, float gpa, String eligible){
		
		this.idCol = new SimpleIntegerProperty(id);
		this.nameCol = new SimpleStringProperty(name);
		this.gpaCol = new SimpleFloatProperty(gpa);
		this.eligibleCol = new SimpleStringProperty(eligible);
		
	}
	
	/*
	 * Given the Student ID = student.stuID
	 * Get and Set Module Code
	 */
	public int getIDCol(){
		return idCol.get();
	}
	
	public void setIDCol(int value){
		idCol.set(value);
	}
	
	//Get and Set Total Marks for the Module
	public String getNameCol(){
		return nameCol.get();
	}
	
	public void setNameCol(String value){
		nameCol.set(value);
	}
	
	//Get and Set Attendance for the Module
	public float getGpaCol(){
		return gpaCol.get();
	}
	
	public void setGpaCol(float value){
		gpaCol.set(value);
	}
	
	//Get and Set Credits for the Module
	public String getEligibleCol(){
		return eligibleCol.get();
	}
	
	public void setEligibleCol(String value){
		eligibleCol.set(value);
	}
	
	//Property Values
	public IntegerProperty idColProperty(){
		return idCol;
	}
	
	public StringProperty nameColProperty(){
		return nameCol;
	}
	
	public FloatProperty gpaColProperty(){
		return gpaCol;
	}
	
	public StringProperty eliglbeColProperty(){
		return eligibleCol;
	}
	
}
