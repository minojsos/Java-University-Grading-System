package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;

/*
 * To Display the Enrollment Details in Table View
 * Enrollment Details for a given student is taken from the database
 */
public class InDetailsController implements Initializable {
	
	Students student = new Students();
	
	//Declare the table and the columns for the table
	@FXML private TableView<EnrollmentDetails> tableEnrollment;
	@FXML private TableColumn<EnrollmentDetails, String> columnModCode;
	@FXML private TableColumn<EnrollmentDetails, Integer> columnMarks;
	@FXML private TableColumn<EnrollmentDetails, Integer> columnAttendance;
	@FXML private TableColumn<EnrollmentDetails, Integer> columnCredits;
	@FXML private TableColumn<EnrollmentDetails, Float> columnGP;
	@FXML private TableColumn<EnrollmentDetails, String> columnPass;
	@FXML private TableColumn<EnrollmentDetails, String> columnGrade;
	
	@FXML private Label lblName;
	@FXML private Label lblGPA;
	@FXML private Label lblEligible;
	
	private ObservableList<EnrollmentDetails> data;
	
	//Display the Enrollment Details for a Student given the student ID
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String stuName = Search.getStuName(student.studentID);
		lblName.setText(stuName);
		float stuGPA = Search.getGPA(student.studentID);
		lblGPA.setText(String.valueOf(stuGPA));
		String stuEligible = Search.getEligible(student.studentID);
		lblEligible.setText(stuEligible);
		
		try{
			new databaseConnect();
			
			Connection conn = databaseConnect.getConnection();
			data = FXCollections.observableArrayList();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT * FROM enrollment WHERE studID= ?");
			retrieve.setInt(1,student.studentID);
			ResultSet result = retrieve.executeQuery();
			
			while(result.next()){
				String modCode = result.getString("modCode");
				int totalMarks = result.getInt("totalMarks");
				int attendance = result.getInt("attendance");
				int credits = result.getInt("credits");
				float gradePoint = result.getFloat("gradePoint");
				String passOrFail = result.getString("passOrFail");
				String grade = result.getString("grade");

				data.add(new EnrollmentDetails(modCode,totalMarks,attendance,credits,gradePoint,passOrFail,grade));
			}
			
		}catch(Exception e){System.out.println(e);}
		
		//Set values to the cells of the table
		columnModCode.setCellValueFactory(new PropertyValueFactory<>("modCodeCol"));
		columnMarks.setCellValueFactory(new PropertyValueFactory<>("totalMarksCol"));
		columnAttendance.setCellValueFactory(new PropertyValueFactory<>("attendanceCol"));
		columnCredits.setCellValueFactory(new PropertyValueFactory<>("creditsCol"));
		columnGP.setCellValueFactory(new PropertyValueFactory<>("gradePointCol"));
		columnPass.setCellValueFactory(new PropertyValueFactory<>("passCol"));
		columnGrade.setCellValueFactory(new PropertyValueFactory<>("gradeCol"));
		
		tableEnrollment.setItems(null);
		tableEnrollment.setItems(data);
		
		
	}
}
