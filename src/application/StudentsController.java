package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class StudentsController implements Initializable {
	
	@FXML private Button btnLogout;
	@FXML private Button btnSearch;
	@FXML private Button btnElaborate;
	@FXML private TextField txtStudentID;
	@FXML private Label lblWelcome;
	@FXML private Label lblStuName;
	@FXML private Label lblStuGPA;
	@FXML private Label lblStuEligible;
	@FXML private Label lblError;
	
	String username;	
	
	Students student = new Students();
	
	//Lets the student to Logout
	@FXML
	private void logout(ActionEvent logoutEvent) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)(((Node) logoutEvent.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.show();   
	}
	
	/*
	 * The ID is not changeable - It is set by the program
	 * The user will be able to view their details only - Name, GPA, Eligibility
	 */
	@FXML
	private void search(ActionEvent searchEvent) throws IOException{
		
		String stuName;
		String stuEligible;
		float stuGPA;
		
		if(!txtStudentID.getText().isEmpty()){
			try{
			int stuID = Integer.parseInt(txtStudentID.getText());
			if(Search.validStuID(stuID)){
				student.studentID = stuID;
				stuName = Search.getStuName(stuID);
				lblStuName.setText(stuName);
				stuGPA = Search.getGPA(stuID);
				lblStuGPA.setText(String.valueOf(stuGPA));
				stuEligible = Search.getEligible(stuID);
				lblStuEligible.setText(stuEligible);
				lblError.setText("");
			}else{
				lblStuName.setText("");
				lblStuGPA.setText("");
				lblStuEligible.setText("");
				lblError.setText("Invalid Student ID");
			}
			}catch(Exception e){
				lblError.setText("Recheck Input");
			}
		}else{
			lblError.setText("Empty Student ID");
		}
	}
	
	//Allows the students view all the individual modules they've taken and their scores etc.
	@FXML
	private void elaborate(ActionEvent elaborateEvent) throws IOException{
		
		if(!txtStudentID.getText().isEmpty()){
			try{
			int stuID = Integer.parseInt(txtStudentID.getText());
			if(Search.validStuID(stuID)){
				student.studentID = stuID;
				Parent root = FXMLLoader.load(getClass().getResource("InDetail.fxml"));
		        Scene scene = new Scene(root);
		        Stage stage = new Stage();
		        //Stage stage = (Stage)(((Node) elaborateEvent.getSource()).getScene().getWindow());
		        stage.setTitle("Gugsi University of Computer Sciences - Full Details");
		        stage.setScene(scene);
		        stage.show();
			}else{
				lblStuName.setText("");
				lblStuGPA.setText("");
				lblStuEligible.setText("");
				lblError.setText("Invalid Student ID");
			}
			}catch(Exception e){
				lblError.setText("Recheck Input");
			}
		}else{
			lblError.setText("Empty Student ID");
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		username = Users.uSerName;
		lblWelcome.setText("Welcome, "+username);
		txtStudentID.setText(String.valueOf(Users.id));
	}
}
