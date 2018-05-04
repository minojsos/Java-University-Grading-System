package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class PreliminaryModuleMarksController implements Initializable {
	
	@FXML private Button btnSave;
	@FXML private Label lblError;
	
	//Preliminary Modules
	@FXML private TextField sc411EME;
	@FXML private TextField sc411CA;
	@FXML private TextField sc411ATT;
	@FXML private TextField sc411G;
	boolean sc411valid = false;
	
	@FXML private TextField sc412EME;
	@FXML private TextField sc412CA;
	@FXML private TextField sc412ATT;
	@FXML private TextField sc412G;
	boolean sc412valid = false;
	
	@FXML private TextField sc414EME;
	@FXML private TextField sc414CA;
	@FXML private TextField sc414ATT;
	@FXML private TextField sc414G;
	boolean sc414valid = false;
	
	@FXML private TextField sc415EME;
	@FXML private TextField sc415CA;
	@FXML private TextField sc415ATT;
	@FXML private TextField sc415G;
	boolean sc415valid = false;
	
	@FXML private TextField sc416EME;
	@FXML private TextField sc416CA;
	@FXML private TextField sc416ATT;
	@FXML private TextField sc416G;
	boolean sc416valid = false;
	
	@FXML private TextField sc417EME;
	@FXML private TextField sc417CA;
	@FXML private TextField sc417ATT;
	@FXML private TextField sc417G;
	boolean sc417valid = false;
	
	@FXML private TextField sc418EME;
	@FXML private TextField sc418CA;
	@FXML private TextField sc418ATT;
	@FXML private TextField sc418G;
	boolean sc418valid = false;
	
	static int preliminaryModule = 0;
	Modules mod = new Modules();
	Enrollments enroll = new Enrollments(0, "", 0, 0, 0, 0, "", "");
	Students student = new Students();
	
	double total = 0;
	int hours = 0;
	int stuID = Students.stuID;
	
	/*
	 * Saves the Marks for all the Preliminary Modules
	 * Only if conditions result to true
	 */
	@FXML
	private void saveBtn(ActionEvent saveEvent) throws IOException{
		
		int[][] integerVal = new int[7][3];
		String[] gradeVal = new String[7];
		
		//Module sc411 
		//Check if Empty - Cannot be Empty
		if(!sc411EME.getText().isEmpty() && !sc411CA.getText().isEmpty() && !sc411ATT.getText().isEmpty() && !sc411G.getText().isEmpty()){
			try{
				if(Integer.parseInt(sc411EME.getText())<=100 && Integer.parseInt(sc411CA.getText())<=100 && Integer.parseInt(sc411ATT.getText())<=mod.getModHours("sc411")){
					integerVal[0][0] = Integer.parseInt(sc411EME.getText());
					integerVal[0][1] = Integer.parseInt(sc411CA.getText());
					integerVal[0][2] = Integer.parseInt(sc411ATT.getText());
					if(enroll.validGradeO(sc411G.getText())){
						gradeVal[0] = sc411G.getText();
						sc411valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc411valid = false;
					}
				
				}else{
					sc411valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc411valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc411valid=false;
			lblError.setText("Empty values.");
		}
		
		//Module sc412
		//Check if Empty - Cannot be Empty
		if(!sc412EME.getText().isEmpty() && !sc412CA.getText().isEmpty() && !sc412ATT.getText().isEmpty() && !sc412G.getText().isEmpty()){
			try{
				if(Integer.parseInt(sc412EME.getText())<=100 && Integer.parseInt(sc412CA.getText())<=100 && Integer.parseInt(sc412ATT.getText())<=mod.getModHours("sc412")){
					integerVal[1][0] = Integer.parseInt(sc412EME.getText());
					integerVal[1][1] = Integer.parseInt(sc412CA.getText());
					integerVal[1][2] = Integer.parseInt(sc412ATT.getText());
					if(enroll.validGradeO(sc412G.getText())){
						gradeVal[1] = sc412G.getText();
						sc412valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc412valid = false;
					}
				
				}else{
					sc412valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc412valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc412valid=false;
			lblError.setText("Empty values.");
		}
		
		//Module sc414
		//Check if Empty - Cannot be Empty
		if(!sc414EME.getText().isEmpty() && !sc414CA.getText().isEmpty() && !sc414ATT.getText().isEmpty() && !sc414G.getText().isEmpty()){
			try{
				if(Integer.parseInt(sc414EME.getText())<=100 && Integer.parseInt(sc414CA.getText())<=100 && Integer.parseInt(sc414ATT.getText())<=mod.getModHours("sc414")){
					integerVal[2][0] = Integer.parseInt(sc414EME.getText());
					integerVal[2][1] = Integer.parseInt(sc414CA.getText());
					integerVal[2][2] = Integer.parseInt(sc414ATT.getText());
					if(enroll.validGradeO(sc414G.getText())){
						gradeVal[2] = sc414G.getText();
						sc414valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc414valid = false;
					}
					
				}else{
					sc414valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc414valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc414valid=false;
			lblError.setText("Empty values.");
		}
		
		//Module sc415
		//Check if Empty - Cannot be Empty
		if(!sc415EME.getText().isEmpty() && !sc415CA.getText().isEmpty() && !sc415ATT.getText().isEmpty() && !sc415G.getText().isEmpty()){
			try{	
				if(Integer.parseInt(sc415EME.getText())<=100 && Integer.parseInt(sc415CA.getText())<=100 && Integer.parseInt(sc415ATT.getText())<=mod.getModHours("sc415")){
					integerVal[3][0] = Integer.parseInt(sc415EME.getText());
					integerVal[3][1] = Integer.parseInt(sc415CA.getText());
					integerVal[3][2]  = Integer.parseInt(sc415ATT.getText());
					if(enroll.validGradeO(sc415G.getText())){
						gradeVal[3] = sc415G.getText();
						sc415valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc415valid = false;
					}
					
				}else{
					sc415valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc415valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc415valid=false;
			lblError.setText("Empty values.");
		}
		
		//Module sc416
		//Check if Empty - Cannot be Empty
		if(!sc416EME.getText().isEmpty() && !sc416CA.getText().isEmpty() && !sc416ATT.getText().isEmpty() && !sc416G.getText().isEmpty()){
			try{
				if(Integer.parseInt(sc416EME.getText())<=100 && Integer.parseInt(sc416CA.getText())<=100 && Integer.parseInt(sc416ATT.getText())<=mod.getModHours("sc416")){
					integerVal[4][0] = Integer.parseInt(sc416EME.getText());
					integerVal[4][1] = Integer.parseInt(sc416CA.getText());
					integerVal[4][2] = Integer.parseInt(sc416ATT.getText());
					if(enroll.validGradeO(sc416G.getText())){
						gradeVal[4] = sc416G.getText();
						sc416valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc416valid = false;
					}
				
				}else{
					sc416valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc416valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc416valid=false;
			lblError.setText("Empty values.");
		}
		
		//Module sc417
		//Check if Empty - Cannot be Empty
		if(!sc417EME.getText().isEmpty() && !sc417CA.getText().isEmpty() && !sc417ATT.getText().isEmpty() && !sc417G.getText().isEmpty()){
			try{
				if(Integer.parseInt(sc417EME.getText())<=100 && Integer.parseInt(sc417CA.getText())<=100 && Integer.parseInt(sc417ATT.getText())<=mod.getModHours("sc417")){
					integerVal[5][0] = Integer.parseInt(sc417EME.getText());
					integerVal[5][1] = Integer.parseInt(sc417CA.getText());
					integerVal[5][2] = Integer.parseInt(sc417ATT.getText());
					if(enroll.validGradeO(sc417G.getText())){
						gradeVal[5] = sc417G.getText();
						sc417valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc417valid = false;
					}
					
				}else{
					sc417valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc417valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc417valid=false;
			lblError.setText("Empty values.");
		}
		
		//Module sc418
		//Check if Empty - Cannot be Empty
		if(!sc418EME.getText().isEmpty() && !sc418CA.getText().isEmpty() && !sc418ATT.getText().isEmpty() && !sc418G.getText().isEmpty()){
			try{	
				if(Integer.parseInt(sc418EME.getText())<=100 && Integer.parseInt(sc418CA.getText())<=100 && Integer.parseInt(sc418ATT.getText())<=mod.getModHours("sc418")){
					integerVal[6][0] = Integer.parseInt(sc418EME.getText());
					integerVal[6][1] = Integer.parseInt(sc418CA.getText());
					integerVal[6][2] = Integer.parseInt(sc418ATT.getText());
					//Validate The Grade
					if(enroll.validGradeO(sc418G.getText())){
						gradeVal[6] = sc418G.getText();
						sc418valid = true;
					}else{
						lblError.setText("Invalid Grade");
						sc418valid = false;
					}
				
				}else{
					sc418valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc418valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc418valid=false;
			lblError.setText("Empty values.");
		}
		
		//IF all compulsory inputs are given = true (NO ERRORS) THEN Proceed to enter into Database
		if(sc411valid && sc412valid && sc414valid && sc415valid && sc416valid && sc417valid && sc418valid){
			
			//sc411 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[0][0], integerVal[0][1]);
			enroll.setEnrollOptional(stuID, "sc411", total, integerVal[0][2], gradeVal[0]);
			
			//sc412 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[1][0], integerVal[1][1]);
			enroll.setEnrollOptional(stuID, "sc412", total, integerVal[1][2], gradeVal[1]);
			
			//sc414 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[2][0], integerVal[2][1]);
			enroll.setEnrollOptional(stuID, "sc414", total, integerVal[2][2], gradeVal[2]);
			
			//sc415 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[3][0], integerVal[3][1]);
			enroll.setEnrollOptional(stuID, "sc415", total, integerVal[3][2], gradeVal[3]);
			
			//sc416 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[4][0], integerVal[4][1]);
			enroll.setEnrollOptional(stuID, "sc416", total, integerVal[4][2], gradeVal[4]);
			
			//sc417 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[5][0], integerVal[5][1]);
			enroll.setEnrollOptional(stuID, "sc417", total, integerVal[5][2], gradeVal[5]);
			
			//sc418 - Store in 'enrollments' table
			total = enroll.findTotal(integerVal[6][0], integerVal[6][1]);
			enroll.setEnrollOptional(stuID, "sc418", total, integerVal[6][2], gradeVal[6]);
			
			preliminaryModule = 1;
			
			Stage stage = (Stage) btnSave.getScene().getWindow();
			stage.close();
		}else{
			lblError.setText("Please Check Input Values");
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
