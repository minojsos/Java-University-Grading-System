package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

/*
 * ADD NEW STUDENTS
 * All Core Module Values needs to be given.
 * Optional Modules - If Check Box is selected, then inputs needs to be given. If not selected, not considered.
 * Giving inputs for Preliminary, SemesterOne and SemesterTwo.
 * Student ID, Name and Password is also required.
 */

public class AddStudentsController implements Initializable {
	
	@FXML private TextField studentID;
	@FXML private TextField studentName;
	@FXML private PasswordField studentPassword;
	@FXML private Button btnNext;
	@FXML private Button btnFinish;
	@FXML private Button btnExit;
	@FXML private Button modPreliminary;
	@FXML private Button modSemOne;
	@FXML private Button modSemTwo;
	@FXML private Label lblError;
	
	//Option Modules - Research and CWK
	@FXML private TextField sc598EME;
	@FXML private TextField sc598CA;
	@FXML private TextField sc598ATT;
	@FXML private TextField sc598GP;
	boolean sc598valid = false;
	
	@FXML private TextField sc599EME;
	@FXML private TextField sc599CA;
	@FXML private TextField sc599ATT;
	@FXML private TextField sc599GP;
	boolean sc599valid = false;
	
	Students student = new Students();
	Users user = new Users();
	Enrollments enroll = new Enrollments(0, "", 0, 0, 0, 0, "", "");
	Modules mod = new Modules();
	
	int credits = 0;
	int hours = 0;
	String passOrFail;
	double gpa = 0.0;
	String eligible = null;
	boolean valid = false;
	
	//Preliminary Modules Window - Opens only if student ID is input and doesn't already exist
	@FXML
	private void preliminaryBtn(ActionEvent preEvent) throws IOException{
		if(!studentID.getText().isEmpty()){
			try{
			if(!student.validateID(Integer.parseInt(studentID.getText()))){
				Students.stuID = Integer.parseInt(studentID.getText());
				Parent root = FXMLLoader.load(getClass().getResource("PreliminaryModuleMarks.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
        		stage.setResizable(false);
        		stage.setMaximized(false);
        		stage.initStyle(StageStyle.UNDECORATED);
				stage.show();
			}else{
				lblError.setText("Student ID already exists");
			}
			}catch(Exception ex){
				lblError.setText("Recheck Input");
			}
		}else{
			lblError.setText("Please Input a Student ID");
		}
	}
	
	//Semester One Modules Window - Opens only if student ID is input and doesn't already exist
	@FXML
	private void semesterOneBtn(ActionEvent semOneEvent) throws IOException{
		if(!studentID.getText().isEmpty()){
			try{
			if(!student.validateID(Integer.parseInt(studentID.getText()))){
				Students.stuID = Integer.parseInt(studentID.getText());
				Parent root = FXMLLoader.load(getClass().getResource("SemesterOneMarks.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setMaximized(false);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.show();
			}else{
				lblError.setText("Student ID already exists");
			}
			}catch(Exception ex){
				lblError.setText("Recheck Input");
			}
		}else{
			lblError.setText("Please Input a Student ID");
		}
	}
	
	//Semester Two Modules Window - Opens only if student ID is input and doesn't already exist
	@FXML
	private void semesterTwoBtn(ActionEvent semTwoEvent) throws IOException{
		if(!studentID.getText().isEmpty()){
			try{
			if(!student.validateID(Integer.parseInt(studentID.getText()))){
				Students.stuID = Integer.parseInt(studentID.getText());
				Parent root = FXMLLoader.load(getClass().getResource("SemesterTwoMarks.fxml"));
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.setScene(scene);
				stage.setResizable(false);
				stage.setMaximized(false);
		        stage.initStyle(StageStyle.UNDECORATED);
				stage.show();
			}else{
				lblError.setText("Student ID already exists");
			}
			}catch(Exception ex){
				lblError.setText("Recheck Input");
			}
		}else{
			lblError.setText("Please Input a Student ID");
		}
	}
	
	//Exit the window without saving any of the input data in the current screen
	@FXML
	private void exitBtn(ActionEvent exitEvent) throws IOException{
		
		if(PreliminaryModuleMarksController.preliminaryModule == 1 || SemesterOneMarksController.semesterOne == 1 || SemesterTwoMarksController.semesterTwo == 1){
			//Display Error Message
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("You may not exit\nYou must complete the current student");
            error.showAndWait();
		}else{
			Stage stage = (Stage) btnExit.getScene().getWindow();
			stage.close();
		}
		
		
	}
	/* Allows to add the Current Student if all details are input and they are valid - Window Empties 
	 * So that the next student can be added
	 * moduleNameValid variable is set to false if any condition fails
	 */
	@FXML
	private void nextBtn(ActionEvent nextEvent) throws IOException{
		
		boolean windows = false;
		double total;
		int stuID;
		String stuName;
		String password;
		int sc598EMEval = 0; int sc598CAval = 0; int sc598ATTval = 0; String sc598GPval = null;
		int sc599EMEval = 0; int sc599CAval = 0; int sc599ATTval = 0; String sc599GPval = null;
		
		//Checks if Student ID, Name and Password is not Empty - If empty, displays an error
		if(!(studentID.getText().isEmpty()) && !(studentName.getText().isEmpty()) && !(studentPassword.getText().isEmpty())){
			
		try{
			stuID = Integer.parseInt(studentID.getText());
			stuName = studentName.getText();
			password = studentPassword.getText();
			//Validates Student ID - If already exists, displays an error
			if(!student.validateID(stuID)){
				
				//Ensures that all the required Module values are given - If empty, displays an error
				if(!sc598EME.getText().isEmpty() && !sc598CA.getText().isEmpty() && !sc598ATT.getText().isEmpty() && !sc598GP.getText().isEmpty()){
					//Checks if the values are within range - If not, displays an error
					try{
					if(Integer.parseInt(sc598EME.getText())<=100 && Integer.parseInt(sc598CA.getText())<=100 && Integer.parseInt(sc598ATT.getText())<=mod.getModHours("sc598")){
						sc598EMEval = Integer.parseInt(sc598EME.getText());
						sc598CAval = Integer.parseInt(sc598CA.getText());
						sc598ATTval = Integer.parseInt(sc598ATT.getText());
						//Checks if the Input Grade is valid - If not, displays an error
						if(enroll.validGradeO(sc598GP.getText())){
							sc598GPval = sc598GP.getText();
							sc598valid = true;
						}else{
							lblError.setText("Invalid Grade");
							sc598valid = false;
						}
							
					}else{
						sc598valid = false;
						lblError.setText("Values out of range.");
					}
					}catch(Exception e){
						sc598valid = false;
						lblError.setText("Recheck Input");
					}
				}else{
					sc598valid = false;
				}
				
				//Above Process repeats for the next Module Here
				if(!sc599EME.getText().isEmpty() && !sc599CA.getText().isEmpty() && !sc599ATT.getText().isEmpty() && !sc599GP.getText().isEmpty()){
					try{
					if(Integer.parseInt(sc599EME.getText())<=100 && Integer.parseInt(sc599CA.getText())<=100 && Integer.parseInt(sc599ATT.getText())<=mod.getModHours("sc599")){
						sc599EMEval = Integer.parseInt(sc599EME.getText());
						sc599CAval = Integer.parseInt(sc599CA.getText());
						sc599ATTval = Integer.parseInt(sc599ATT.getText());
						
						if(enroll.validGradeO(sc599GP.getText())){
							sc599GPval = sc599GP.getText();
							sc599valid = true;
						}else{
							lblError.setText("Invalid Grade");
							sc599valid = false;
						}
							
					}else{
						sc599valid = false;
						lblError.setText("Values out of range.");
					}	
					}catch(Exception e){
						sc599valid = false;
						lblError.setText("Recheck Input");
					}
				}else{
					sc599valid = false;
				}
				
				//Ensures that the Preliminary Module, Semester One and Semester two windows were opened - If not, error will be displayed
				if(PreliminaryModuleMarksController.preliminaryModule != 1 || SemesterOneMarksController.semesterOne != 1 || SemesterTwoMarksController.semesterTwo != 1){
					lblError.setText("Please make sure all required inputs are given.");
					windows = false;
				}else{
					windows = true;
				}
				
				//If All required inputs are given, then if condition is true - Else error
				if(sc598valid && sc599valid && windows){
					
					total = enroll.findTotal(Integer.parseInt(sc598EME.getText()), Integer.parseInt(sc598CA.getText()));
					credits = mod.getModCredits("sc598");
					enroll.setEnrollOthers(stuID, "sc598", credits, total, sc598ATTval, sc599GPval);
					
					total = enroll.findTotal(Integer.parseInt(sc599EME.getText()), Integer.parseInt(sc599CA.getText()));
					credits = mod.getModCredits("sc599");
					enroll.setEnrollOthers(stuID, "sc598", credits, total, sc599ATTval, sc599GPval);
					

					gpa = ((double)enroll.creditsGP/enroll.totCredits);
					eligible = enroll.getEligible(enroll.totCredits, gpa);
					
					System.out.println(gpa);
					
					user.setUser(password, stuID);
					student.setStudents(stuID, stuName, eligible, gpa);
					
					
					Parent root = FXMLLoader.load(getClass().getResource("AddStudents.fxml"));
					Scene scene = new Scene(root);
			    	Stage stage = (Stage)(((Node) nextEvent.getSource()).getScene().getWindow());
			    	stage.setScene(scene);
			    	stage.setResizable(false);
			    	stage.setMaximized(false);
					stage.initStyle(StageStyle.UNDECORATED);
			    	stage.show();
				}else{
					lblError.setText("Please Check Inputs Values");
				}
				
			}else{
				lblError.setText("Student ID already exists.");
			}
		}catch(Exception ex){
			lblError.setText("Invalid Student ID");
		}
		}else{
			lblError.setText("Empty Student ID, Name or Password.");
		}
		
	}
	
	/* Allows to add the Current Student if all details are input and they are valid - Window Closed
	 * moduleNameValid variable is set to false if any condition fails
	 */
	@FXML
	private void finishBtn(ActionEvent finishEvent) throws IOException{
		
		boolean windows = false;
		double total;
		int stuID;
		String stuName;
		String password;
		int sc598EMEval = 0; int sc598CAval = 0; int sc598ATTval = 0; String sc598GPval = null;
		int sc599EMEval = 0; int sc599CAval = 0; int sc599ATTval = 0; String sc599GPval = null;
		
		//Checks if Student ID, Name and Password is not Empty - If empty, displays an error
		if(!(studentID.getText().isEmpty()) && !(studentName.getText().isEmpty()) && !(studentPassword.getText().isEmpty())){
			try{
			stuID = Integer.parseInt(studentID.getText());
			stuName = studentName.getText();
			password = studentPassword.getText();
			
			//Validates Student ID - If already exists, displays an error
			if(!student.validateID(stuID)){
				
				//Ensures that all the required Module values are given - If empty, displays an error
				if(!sc598EME.getText().isEmpty() && !sc598CA.getText().isEmpty() && !sc598ATT.getText().isEmpty() && !sc598GP.getText().isEmpty()){
					//Checks if the values are within range - If not, displays an error
					try{
					if(Integer.parseInt(sc598EME.getText())<=100 && Integer.parseInt(sc598CA.getText())<=100 && Integer.parseInt(sc598ATT.getText())<=mod.getModHours("sc598")){
						sc598EMEval = Integer.parseInt(sc598EME.getText());
						sc598CAval = Integer.parseInt(sc598CA.getText());
						sc598ATTval = Integer.parseInt(sc598ATT.getText());
						//Checks if the Input Grade is valid - If not, displays an error
						if(enroll.validGradeO(sc598GP.getText())){
							sc598GPval = sc598GP.getText();
							sc598valid = true;
						}else{
							lblError.setText("Invalid Grade");
							sc598valid = false;
						}
							
					}else{
						sc598valid = false;
						lblError.setText("Values out of range.");
					}	
					}catch(Exception e){
						sc598valid = false;
						lblError.setText("Recheck Input");
					}
				}else{
					sc598valid = false;
				}
				
				//Above Process repeats for the next Module Here
				if(!sc599EME.getText().isEmpty() && !sc599CA.getText().isEmpty() && !sc599ATT.getText().isEmpty() && !sc599GP.getText().isEmpty()){
					try{
					if(Integer.parseInt(sc599EME.getText())<=100 && Integer.parseInt(sc599CA.getText())<=100 && Integer.parseInt(sc599ATT.getText())<=mod.getModHours("sc599")){
						sc599EMEval = Integer.parseInt(sc599EME.getText());
						sc599CAval = Integer.parseInt(sc599CA.getText());
						sc599ATTval = Integer.parseInt(sc599ATT.getText());
						
						if(enroll.validGradeO(sc599GP.getText())){
							sc599GPval = sc599GP.getText();
							sc599valid = true;
						}else{
							lblError.setText("Invalid Grade");
							sc599valid = false;
						}
							
					}else{
						sc599valid = false;
						lblError.setText("Values out of range.");
					}
					}catch(Exception e){
						sc599valid = false;
						lblError.setText("Recheck Input");
					}
				}else{
					sc599valid = false;
				}
				
				//Ensures that the Preliminary Module, Semester One and Semester two windows were opened - If not, error will be displayed
				if(PreliminaryModuleMarksController.preliminaryModule != 1 || SemesterOneMarksController.semesterOne != 1 || SemesterTwoMarksController.semesterTwo != 1){
					lblError.setText("Please make sure all required inputs are given.");
					windows = false;
				}else{
					windows = true;
				}
				
				if(sc598valid && sc599valid && windows){
					
					total = enroll.findTotal(Integer.parseInt(sc598EME.getText()), Integer.parseInt(sc598CA.getText()));
					credits = mod.getModCredits("sc598");
					enroll.setEnrollOthers(stuID, "sc598", credits, total, sc598ATTval, sc599GPval);
					
					total = enroll.findTotal(Integer.parseInt(sc599EME.getText()), Integer.parseInt(sc599CA.getText()));
					credits = mod.getModCredits("sc599");
					enroll.setEnrollOthers(stuID, "sc598", credits, total, sc599ATTval, sc599GPval);
					

					gpa = ((double)enroll.creditsGP/enroll.totCredits);
					eligible = enroll.getEligible(enroll.totCredits, gpa);
					
					System.out.println(gpa);
					
					user.setUser(password, stuID);
					student.setStudents(stuID, stuName, eligible, gpa);

					Stage stage = (Stage) btnFinish.getScene().getWindow();
					stage.close();
				}else{
					lblError.setText("Please Check Inputs Values");
				}
				
			}else{
				lblError.setText("Student ID already exists.");
			}
		}catch(Exception e){
			lblError.setText("Invalid Student ID");
		}
		}else{
			lblError.setText("Empty Student ID, Name or Password.");
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
