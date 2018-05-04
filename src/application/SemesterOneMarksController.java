package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class SemesterOneMarksController implements Initializable {
	
	private int count = 0;
	
	@FXML private Button btnSave;
	@FXML private Label lblError;
	
	//Core Modules
	@FXML private TextField sc531EME;
	@FXML private TextField sc531CA;
	@FXML private TextField sc531ATT;
	@FXML private TextField sc531GRA;
	private boolean sc531valid = false;
	
	@FXML private TextField sc535EME;
	@FXML private TextField sc535CA;
	@FXML private TextField sc535ATT;
	@FXML private TextField sc535GRA;
	private boolean sc535valid = false;
	
	@FXML private TextField sc537EME;
	@FXML private TextField sc537CA;
	@FXML private TextField sc537ATT;
	@FXML private TextField sc537GRA;
	private boolean sc537valid = false;
	
	@FXML private TextField sc538EME;
	@FXML private TextField sc538CA;
	@FXML private TextField sc538ATT;
	@FXML private TextField sc538GRA;
	private boolean sc538valid = false;
	
	@FXML private TextField sc539EME;
	@FXML private TextField sc539CA;
	@FXML private TextField sc539ATT;
	@FXML private TextField sc539GRA;
	private boolean sc539valid = false;
	
	//Optional Modules
	@FXML private CheckBox sc532;
	@FXML private TextField sc532EME;
	@FXML private TextField sc532CA;
	@FXML private TextField sc532ATT;
	@FXML private TextField sc532GRA;
	private boolean sc532valid = false;
	
	@FXML private CheckBox sc533;
	@FXML private TextField sc533EME;
	@FXML private TextField sc533CA;
	@FXML private TextField sc533ATT;
	@FXML private TextField sc533GRA;
	private boolean sc533valid = false;
	
	@FXML private CheckBox sc534;
	@FXML private TextField sc534EME;
	@FXML private TextField sc534CA;
	@FXML private TextField sc534ATT;
	@FXML private TextField sc534GRA;
	private boolean sc534valid = false;
	
	@FXML private CheckBox sc536;
	@FXML private TextField sc536EME;
	@FXML private TextField sc536CA;
	@FXML private TextField sc536ATT;
	@FXML private TextField sc536GRA;
	private boolean sc536valid = false;
	
	@FXML private CheckBox sc540;
	@FXML private TextField sc540EME;
	@FXML private TextField sc540CA;
	@FXML private TextField sc540ATT;
	@FXML private TextField sc540GRA;
	private boolean sc540valid = false;
	
	@FXML private CheckBox sc541;
	@FXML private TextField sc541EME;
	@FXML private TextField sc541CA;
	@FXML private TextField sc541ATT;
	@FXML private TextField sc541GRA;
	private boolean sc541valid = false;
	
	@FXML private CheckBox sc542;
	@FXML private TextField sc542EME;
	@FXML private TextField sc542CA;
	@FXML private TextField sc542ATT;
	@FXML private TextField sc542GRA;
	private boolean sc542valid = false;
	
	@FXML private CheckBox sc543;
	@FXML private TextField sc543EME;
	@FXML private TextField sc543CA;
	@FXML private TextField sc543ATT;
	@FXML private TextField sc543GRA;
	private boolean sc543valid = false;
	
	Enrollments enroll = new Enrollments(0, "", 0, 0, 0, 0, "", "");
	Modules mod = new Modules();
	Students student = new Students();
	
	double total = 0;
	int credits = 0;
	String passOrFail = null;
	static int semesterOne = 0;
	//Retrieve the stored Student ID from student Class
	int stuID = student.stuID;
	
	//Check Box Selection Action
	@FXML
	private void checkBoxSelected(ActionEvent checkBoxEvent) throws IOException{
		/* If the Check Box is selected, make it editable
		 * Else if Check Box is unselected
		 * Make it not editable and clear the value in it
		 * By default Check Box is not editable
		 */
		if(sc532.isSelected()){
			count++;
			sc532EME.setEditable(true);
			sc532CA.setEditable(true);
			sc532ATT.setEditable(true);
			sc532GRA.setEditable(true);
		}else{
			sc532EME.setEditable(false);
			sc532EME.clear();
			sc532CA.setEditable(false);
			sc532CA.clear();
			sc532ATT.setEditable(false);
			sc532ATT.clear();
			sc532GRA.setEditable(false);
			sc532GRA.clear();
		}
		
		if(sc533.isSelected()){
			count++;
			sc533EME.setEditable(true);
			sc533CA.setEditable(true);
			sc533ATT.setEditable(true);
			sc533GRA.setEditable(true);
		}else{
			sc533EME.setEditable(false);
			sc533EME.clear();
			sc533CA.setEditable(false);
			sc533CA.clear();
			sc533ATT.setEditable(false);	
			sc533ATT.clear();
			sc533GRA.setEditable(false);
			sc533GRA.clear();
		}
		
		if(sc534.isSelected()){
			count++;
			sc534EME.setEditable(true);
			sc534CA.setEditable(true);
			sc534ATT.setEditable(true);
			sc534GRA.setEditable(true);
		}else{
			sc534EME.setEditable(false);
			sc534EME.clear();
			sc534CA.setEditable(false);
			sc534CA.clear();
			sc534ATT.setEditable(false);
			sc534ATT.clear();
			sc534GRA.setEditable(false);
			sc534GRA.clear();
		}
		
		if(sc536.isSelected()){
			count++;
			sc536EME.setEditable(true);
			sc536CA.setEditable(true);
			sc536ATT.setEditable(true);
			sc536GRA.setEditable(true);
		}else{
			sc536EME.setEditable(false);
			sc536EME.clear();
			sc536CA.setEditable(false);
			sc536CA.clear();
			sc536ATT.setEditable(false);
			sc536ATT.clear();
			sc536GRA.setEditable(false);
			sc536GRA.clear();
		}
		
		if(sc540.isSelected()){
			count++;
			sc540EME.setEditable(true);
			sc540CA.setEditable(true);
			sc540ATT.setEditable(true);
			sc540GRA.setEditable(true);
		}else{
			sc540EME.setEditable(false);
			sc540EME.clear();
			sc540CA.setEditable(false);
			sc540CA.clear();
			sc540ATT.setEditable(false);
			sc540ATT.clear();
			sc540GRA.setEditable(false);
			sc540GRA.clear();
		}
		
		if(sc541.isSelected()){
			count++;
			sc541EME.setEditable(true);
			sc541CA.setEditable(true);
			sc541ATT.setEditable(true);
			sc541GRA.setEditable(true);
		}else{
			sc541EME.setEditable(false);
			sc541EME.clear();
			sc541CA.setEditable(false);
			sc541CA.clear();
			sc541ATT.setEditable(false);
			sc541ATT.clear();
			sc541GRA.setEditable(false);
			sc541GRA.clear();
		}
		
		if(sc542.isSelected()){
			count++;
			sc542EME.setEditable(true);
			sc542CA.setEditable(true);
			sc542ATT.setEditable(true);
			sc542GRA.setEditable(true);
		}else{
			sc542EME.setEditable(false);
			sc542EME.clear();
			sc542CA.setEditable(false);
			sc542CA.clear();
			sc542ATT.setEditable(false);
			sc542ATT.clear();
			sc542GRA.setEditable(false);
			sc542GRA.clear();
		}
		
		if(sc543.isSelected()){
			count++;
			sc543EME.setEditable(true);
			sc543CA.setEditable(true);
			sc543ATT.setEditable(true);
			sc543GRA.setEditable(true);
		}else{
			sc543EME.setEditable(false);
			sc543EME.clear();
			sc543CA.setEditable(false);
			sc543CA.clear();
			sc543ATT.setEditable(false);
			sc543ATT.clear();
			sc543GRA.setEditable(false);
			sc543GRA.clear();
		}
		
	}
	
	/*
	 * Saves Marks - Enrollment - To Database
	 */
	@FXML
	private void saveBtn(ActionEvent saveEvent) throws IOException{
		
		boolean valid = false;
		int[][] integerVal = new int[5][3];
		float[] gradePoint = new float[5];
		
		int[][] optionalIntVal = new int[8][3];
		float[] optionalGP = new float[8];
		
		/*Core Modules - Semester One
		 *Module sc531 
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc531EME.getText().isEmpty() && !sc531CA.getText().isEmpty() && !sc531ATT.getText().isEmpty() && !sc531GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
				if(Integer.parseInt(sc531EME.getText())<=100 && Integer.parseInt(sc531CA.getText())<=100 && Float.parseFloat(sc535GRA.getText())<=4 && Integer.parseInt(sc531ATT.getText())<=mod.getModHours("sc531")){
					integerVal[0][0] = Integer.parseInt(sc531EME.getText());
					integerVal[0][1] = Integer.parseInt(sc531CA.getText());
					integerVal[0][2] = Integer.parseInt(sc531ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						gradePoint[0] = Float.parseFloat(sc531GRA.getText());
						sc531valid = true;
					}catch(Exception ex){
						sc531valid = false;
					}
				}else{
					sc531valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc531valid = false;
				lblError.setText("Re-Check Input");
			}
		}else{
			sc531valid=false;
			lblError.setText("Empty values.");
		}
		
		/*Module sc535
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc535EME.getText().isEmpty() && !sc535CA.getText().isEmpty() && !sc535ATT.getText().isEmpty() && !sc535GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
				if(Integer.parseInt(sc535EME.getText())<=100 && Integer.parseInt(sc535CA.getText())<=100 && Float.parseFloat(sc535GRA.getText())<=4 && Integer.parseInt(sc535ATT.getText())<=mod.getModHours("sc535")){
					integerVal[1][0] = Integer.parseInt(sc535EME.getText());
					integerVal[1][1] = Integer.parseInt(sc535CA.getText());
					integerVal[1][2] = Integer.parseInt(sc535ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						gradePoint[1] = Float.parseFloat(sc535GRA.getText());
						sc535valid = true;
					}catch(Exception ex){
						sc535valid = false;
					}
				}else{
					sc535valid = false;
					lblError.setText("Values out of range.");
				}	
			}catch(Exception ex){
				sc535valid = false;
				lblError.setText("Re-Check Input");
			}
		}else{
			sc535valid=false;
			lblError.setText("Empty values.");
		}
		
		/*Module sc537
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc537EME.getText().isEmpty() && !sc537CA.getText().isEmpty() && !sc537ATT.getText().isEmpty() && !sc537GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
				if(Integer.parseInt(sc537EME.getText())<=100 && Integer.parseInt(sc537CA.getText())<=100 && Float.parseFloat(sc537GRA.getText())<=4 && Integer.parseInt(sc537ATT.getText())<=mod.getModHours("sc537")){
					integerVal[2][0] = Integer.parseInt(sc537EME.getText());
					integerVal[2][1] = Integer.parseInt(sc537CA.getText());
					integerVal[2][2] = Integer.parseInt(sc537ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						gradePoint[2] = Float.parseFloat(sc537GRA.getText());
						sc537valid = true;
					}catch(Exception ex){
						sc537valid = false;
					}
				}else{
					sc537valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc537valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc537valid=false;
			lblError.setText("Empty values.");
		}
		
		/*Module sc538
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc538EME.getText().isEmpty() && !sc538CA.getText().isEmpty() && !sc538ATT.getText().isEmpty() && !sc538GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
				if(Integer.parseInt(sc538EME.getText())<=100 && Integer.parseInt(sc538CA.getText())<=100 && Float.parseFloat(sc538GRA.getText())<=4 && Integer.parseInt(sc538ATT.getText())<=mod.getModHours("sc538")){
					integerVal[3][0] = Integer.parseInt(sc538EME.getText());
					integerVal[3][1] = Integer.parseInt(sc538CA.getText());
					integerVal[3][2] = Integer.parseInt(sc538ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						gradePoint[3] = Float.parseFloat(sc538GRA.getText());
						sc538valid = true;
					}catch(Exception ex){
						sc538valid = false;
					}
				}else{
					sc538valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc538valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc538valid=false;
			lblError.setText("Empty values.");
		}
		
		/*Module sc539
		 *Check if Empty - Cannot be Empty
	   	 */
		if(!sc539EME.getText().isEmpty() && !sc539CA.getText().isEmpty() && !sc539ATT.getText().isEmpty() && !sc539GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
				if(Integer.parseInt(sc539EME.getText())<=100 && Integer.parseInt(sc539CA.getText())<=100 && Float.parseFloat(sc539GRA.getText())<=4 && Integer.parseInt(sc539ATT.getText())<=mod.getModHours("sc539")){
					integerVal[4][0] = Integer.parseInt(sc539EME.getText());
					integerVal[4][1] = Integer.parseInt(sc539CA.getText());
					integerVal[4][2] = Integer.parseInt(sc539ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						gradePoint[4] = Float.parseFloat(sc539GRA.getText());
						sc539valid = true;
					}catch(Exception ex){
						sc539valid = false;
					}
				}else{
					sc539valid = false;
					lblError.setText("Values out of range.");
				}
			}catch(Exception ex){
				sc539valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc539valid=false;
			lblError.setText("Empty values.");
		}
		
		/* Optional Modules
		 * Module sc532
		 * If Checkbox is selected
		 */
		if(sc532.isSelected()){
			if(!sc532EME.getText().isEmpty() && !sc532CA.getText().isEmpty() && !sc532ATT.getText().isEmpty() && !sc532GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc532EME.getText())<=100 && Integer.parseInt(sc532CA.getText())<=100 && Integer.parseInt(sc532ATT.getText())<=mod.getModHours("sc532") && Float.parseFloat(sc532GRA.getText())<=4){
						optionalIntVal[0][0] = Integer.parseInt(sc532EME.getText());
						optionalIntVal[0][1] = Integer.parseInt(sc532CA.getText());
						optionalIntVal[0][2] = Integer.parseInt(sc532ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[0] = Float.parseFloat(sc532GRA.getText());
							sc532valid = true;
						}catch(Exception ex){
							sc532valid = false;
						}
					}else{
						sc532valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc532valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc532valid = false;
			}
		}else{
			sc532valid = true;
		}
		
		/*
		 * Module sc533
		 * If Checkbox is selected
		 */
		if(sc533.isSelected()){
			if(!sc533EME.getText().isEmpty() && !sc533CA.getText().isEmpty() && !sc533ATT.getText().isEmpty() && !sc533GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc533EME.getText())<=100 && Integer.parseInt(sc533CA.getText())<=100 && Integer.parseInt(sc533ATT.getText())<=mod.getModHours("sc533") && Float.parseFloat(sc533GRA.getText())<=4){
						optionalIntVal[1][0] = Integer.parseInt(sc533EME.getText());
						optionalIntVal[1][1] = Integer.parseInt(sc533CA.getText());
						optionalIntVal[1][2] = Integer.parseInt(sc533ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[1] = Float.parseFloat(sc533GRA.getText());
							sc533valid = true;
						}catch(Exception ex){
							sc533valid = false;
						}
					}else{
						sc533valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc533valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc533valid = false;
			}
		}else{
			sc533valid = true;
		}
		
		/*
		 * Module sc534
		 * If Checkbox is selected
		 */
		if(sc534.isSelected()){
			if(!sc534EME.getText().isEmpty() && !sc534CA.getText().isEmpty() && !sc534ATT.getText().isEmpty() && !sc534GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc534EME.getText())<=100 && Integer.parseInt(sc534CA.getText())<=100 && Integer.parseInt(sc534ATT.getText())<=mod.getModHours("sc534") && Float.parseFloat(sc534GRA.getText())<=4){
						optionalIntVal[2][0] = Integer.parseInt(sc534EME.getText());
						optionalIntVal[2][1] = Integer.parseInt(sc534CA.getText());
						optionalIntVal[2][2] = Integer.parseInt(sc534ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[2] = Float.parseFloat(sc534GRA.getText());
							sc534valid = true;
						}catch(Exception ex){
							sc534valid = false;
						}
					}else{
						sc534valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc534valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc534valid = false;
			}
		}else{
			sc534valid = true;
		}
		
		/*
		 * Module sc536
		 * If Checkbox is selected
		 */
		if(sc536.isSelected()){
			if(!sc536EME.getText().isEmpty() && !sc536CA.getText().isEmpty() && !sc536ATT.getText().isEmpty() && !sc536GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc536EME.getText())<=100 && Integer.parseInt(sc536CA.getText())<=100 && Integer.parseInt(sc536ATT.getText())<=mod.getModHours("sc536") && Float.parseFloat(sc536GRA.getText())<=4){
						optionalIntVal[3][0] = Integer.parseInt(sc536EME.getText());
						optionalIntVal[3][1] = Integer.parseInt(sc536CA.getText());
						optionalIntVal[3][2] = Integer.parseInt(sc536ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[3] = Float.parseFloat(sc536GRA.getText());
							sc536valid = true;
						}catch(Exception ex){
						sc536valid = false;
						}
					}else{
						sc536valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc536valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc536valid = false;
			}
		}else{
			sc536valid = true;
		}
		
		/*
		 * Module sc540
		 * If Checkbox is selected
		 */
		if(sc540.isSelected()){
			if(!sc540EME.getText().isEmpty() && !sc540CA.getText().isEmpty() && !sc540ATT.getText().isEmpty() && !sc540GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc540EME.getText())<=100 && Integer.parseInt(sc540CA.getText())<=100 && Integer.parseInt(sc540ATT.getText())<=mod.getModHours("sc540") && Float.parseFloat(sc540GRA.getText())<=4){
						optionalIntVal[4][0] = Integer.parseInt(sc540EME.getText());
						optionalIntVal[4][1] = Integer.parseInt(sc540CA.getText());
						optionalIntVal[4][2] = Integer.parseInt(sc540ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[4] = Float.parseFloat(sc540GRA.getText());
							sc540valid = true;
						}catch(Exception ex){
							sc540valid = false;
						}
					}else{
						sc540valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc540valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc540valid = false;
			}
		}else{
			sc540valid = true;
		}
		
		/*
		 * Module sc541
		 * If Checkbox is selected
		 */
		if(sc541.isSelected()){
			if(!sc541EME.getText().isEmpty() && !sc541CA.getText().isEmpty() && !sc541ATT.getText().isEmpty() && !sc541GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc541EME.getText())<=100 && Integer.parseInt(sc541CA.getText())<=100 && Integer.parseInt(sc541ATT.getText())<=mod.getModHours("sc541") && Float.parseFloat(sc541GRA.getText())<=4){
						optionalIntVal[5][0] = Integer.parseInt(sc541EME.getText());
						optionalIntVal[5][1] = Integer.parseInt(sc541CA.getText());
						optionalIntVal[5][2] = Integer.parseInt(sc541ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[5] = Float.parseFloat(sc541GRA.getText());
							sc541valid = true;
						}catch(Exception ex){
							sc541valid = false;
						}
					}else{
						sc541valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc541valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc541valid = false;
			}
		}else{
			sc541valid = true;
		}
		
		/*
		 * Module sc542
		 * If Checkbox is selected
		 */
		if(sc542.isSelected()){
			//Check if any empty boxes are present (if checkbox selected)
			if(!sc542EME.getText().isEmpty() && !sc542CA.getText().isEmpty() && !sc542ATT.getText().isEmpty() && !sc542GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc542EME.getText())<=100 && Integer.parseInt(sc542CA.getText())<=100 && Integer.parseInt(sc542ATT.getText())<=mod.getModHours("sc542") && Float.parseFloat(sc542GRA.getText())<=4){
						optionalIntVal[6][0] = Integer.parseInt(sc542EME.getText());
						optionalIntVal[6][1] = Integer.parseInt(sc542CA.getText());
						optionalIntVal[6][2] = Integer.parseInt(sc542ATT.getText());
						optionalGP[6] = Float.parseFloat(sc542GRA.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[6] = Float.parseFloat(sc542GRA.getText());
							sc542valid = true;
						}catch(Exception ex){
							sc542valid = false;
						}
					}else{
						//Else set module valid variable to false
						sc542valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc542valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc542valid = false;
			}
		}else{
			sc542valid = true;
		}
		
		/*
		 * Module sc543
		 * If Checkbox is selected
		 */
		if(sc543.isSelected()){
			//Check if any empty boxes are present (if checkbox selected)
			if(!sc543EME.getText().isEmpty() && !sc543CA.getText().isEmpty() && !sc543ATT.getText().isEmpty() && !sc543GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
					if(Integer.parseInt(sc543EME.getText())<=100 && Integer.parseInt(sc543CA.getText())<=100 && Integer.parseInt(sc543ATT.getText())<=mod.getModHours("sc543") && Float.parseFloat(sc543GRA.getText())<=4){
						optionalIntVal[7][0] = Integer.parseInt(sc543EME.getText());
						optionalIntVal[7][1] = Integer.parseInt(sc543CA.getText());
						optionalIntVal[7][2] = Integer.parseInt(sc543ATT.getText());
						//If all conditions met, module valid variable is set to true
						try{
							optionalGP[7] = Float.parseFloat(sc543GRA.getText());
							sc543valid = true;
						}catch(Exception ex){
							sc543valid = false;
						}
					}else{
						//Else set module valid variable to false
						sc543valid = false;
						lblError.setText("Values out of range.");
					}
				}catch(Exception ex){
					sc543valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc543valid = false;
			}
		}else{
			sc543valid = true;
		}
		
		
		//Check If all inputs are given in valid form and store the data
		if(sc531valid && sc532valid && sc533valid && sc534valid && sc535valid && sc536valid && sc537valid && sc538valid && sc539valid && sc540valid && sc541valid && sc542valid && sc543valid){

			
			/* Module sc531
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[0][0], integerVal[0][1]);
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[0],integerVal[0][2],"sc531");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc531");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc531", total, integerVal[0][2], credits, gradePoint[0], passOrFail);

			
			/* Module sc535
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[1][0], integerVal[1][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[1],integerVal[1][2],"sc535");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc535");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc535", total, integerVal[1][2], credits, gradePoint[1], passOrFail);

			
			/* Module sc537
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[2][0], integerVal[2][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[2],integerVal[2][2],"sc537");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc537");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc537", total, integerVal[2][2], credits, gradePoint[2], passOrFail);
			
			/* Module sc538
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[3][0], integerVal[3][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[3],integerVal[3][2],"sc538");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc538");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc538", total, integerVal[3][2], credits, gradePoint[3], passOrFail);
			
			/* Module sc539
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[4][0], integerVal[4][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[4],integerVal[4][2],"sc539");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc539");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc539", total, integerVal[4][2], credits, gradePoint[4], passOrFail);
			
			/*
			 * Optional Modules 
			 * Module sc532
			 */
			if(sc532.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[0][0], optionalIntVal[0][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[0],optionalIntVal[0][2],"sc532");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc532");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc532", total, optionalIntVal[0][2], credits, optionalGP[0], passOrFail);
			}
			
			//Module sc533
			
			if(sc533.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[1][0], optionalIntVal[1][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[1],optionalIntVal[1][2],"sc533");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc533");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc533", total, optionalIntVal[1][2], credits, optionalGP[1], passOrFail);
			}
			
			//Module sc534
			
			if(sc534.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[2][0], optionalIntVal[2][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[2],optionalIntVal[2][2],"sc534");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc534");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc534", total, optionalIntVal[2][2], credits, optionalGP[2], passOrFail);
			}
			
			//Module sc536
			
			if(sc536.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[3][0], optionalIntVal[3][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[3],optionalIntVal[3][2],"sc536");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc536");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc536", total, optionalIntVal[3][2], credits, optionalGP[3], passOrFail);
			}
			
			//Module sc540
			
			if(sc540.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[4][0], optionalIntVal[4][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[4],optionalIntVal[4][2],"sc540");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc540");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc540", total, optionalIntVal[4][2], credits, optionalGP[4], passOrFail);
			}
			
			//Module sc541
			
			if(sc541.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[5][0], optionalIntVal[5][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[5],optionalIntVal[5][2],"sc541");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc541");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc541", total, optionalIntVal[5][2], credits, optionalGP[5], passOrFail);
			}
			
			//Module sc542
			
			if(sc542.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[6][0], optionalIntVal[6][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[6],optionalIntVal[6][2],"sc542");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc542");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc542", total, optionalIntVal[6][2], credits, optionalGP[6], passOrFail);
			}
			
			//Module sc543
			
			if(sc543.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[7][0], optionalIntVal[7][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[7],optionalIntVal[7][2],"sc543");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc543");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc543", total, optionalIntVal[7][2], credits, optionalGP[7], passOrFail);
			}
			
			semesterOne = 1;
			
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
