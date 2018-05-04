package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

/*
 * Displayed when the Administrator logs into the program
 * Displayed if Role = 0
 */
public class WelcomeController implements Initializable {
	
	@FXML private Button btnLogout;
	@FXML private Button btnAddStudent;
	@FXML private Button btnViewAll;
	@FXML private Button btnSettings;
	@FXML private Button btnSearch;
	@FXML private Button btnElaborate;
	@FXML private TextField txtStudentID;
	@FXML private Label lblError;
	@FXML private Label lblStuName;
	@FXML private Label lblStuGPA;
	@FXML private Label lblStuEligible;
	
	Students student = new Students();
	
	//Allows the Administrator to logout from the software
	@FXML
	private void logout(ActionEvent logoutEvent) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)(((Node) logoutEvent.getSource()).getScene().getWindow());
        stage.setTitle("Gugsi University of Computer Sciences - Login");
        stage.setScene(scene);
        stage.show();   
	}
	
	//Allows the Administrator to Add a New Student
	@FXML
	private void addStudent(ActionEvent addStudentEvent) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("AddStudents.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //Stage stage = (Stage)(((Node) addStudentEvent.getSource()).getScene().getWindow());
        stage.setTitle("Gugsi University of Computer Sciences - Add Student");
        stage.setScene(scene);
        stage.setResizable(false);
		stage.initStyle(StageStyle.UNDECORATED);
        stage.show();  
	}
	
	
	//Allows the Administrator to View All Students
	@FXML
	private void viewAll(ActionEvent viewAllEvent) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("ViewAll.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //Stage stage = (Stage)(((Node) addStudentEvent.getSource()).getScene().getWindow());
        stage.setTitle("Gugsi University of Computer Sciences - All Students");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();  
	}
	
	
	//Allows the Administrator to change the settings of the program
	@FXML
	private void settings(ActionEvent settingsEvent) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        //Stage stage = (Stage)(((Node) settingsEvent.getSource()).getScene().getWindow());
        stage.setTitle("Gugsi University of Computer Sciences - Settings");
        stage.setScene(scene);
        stage.show();  
	}
	
	//Allows the Administrator to lookup a student - Student ID TextField Editable
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
	
	//Allows the Administrator to view the modules taken by that student and the scores etc.
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
		// TODO Auto-generated method stub
		
	}
}
