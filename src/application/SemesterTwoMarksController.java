package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class SemesterTwoMarksController implements Initializable {
	
	@FXML private Button btnSave;
	@FXML private Label lblError;
	
	//Core Modules
	@FXML private TextField sc546EME;
	@FXML private TextField sc546CA;
	@FXML private TextField sc546ATT;
	@FXML private TextField sc546GRA;
	private boolean sc546valid = false;
	
	@FXML private TextField sc554EME;
	@FXML private TextField sc554CA;
	@FXML private TextField sc554ATT;
	@FXML private TextField sc554GRA;
	private boolean sc554valid = false;
	
	@FXML private TextField sc555EME;
	@FXML private TextField sc555CA;
	@FXML private TextField sc555ATT;
	@FXML private TextField sc555GRA;
	private boolean sc555valid = false;

	@FXML private TextField sc597EME;
	@FXML private TextField sc597CA;
	@FXML private TextField sc597ATT;
	@FXML private TextField sc597GRA;
	private boolean sc597valid = false;
	
	//Optional Modules
	@FXML private CheckBox sc547;
	@FXML private TextField sc547EME;
	@FXML private TextField sc547CA;
	@FXML private TextField sc547ATT;
	@FXML private TextField sc547GRA;
	private boolean sc547valid = false;
	
	@FXML private CheckBox sc548;
	@FXML private TextField sc548EME;
	@FXML private TextField sc548CA;
	@FXML private TextField sc548ATT;
	@FXML private TextField sc548GRA;
	private boolean sc548valid = false;
	
	@FXML private CheckBox sc549;
	@FXML private TextField sc549EME;
	@FXML private TextField sc549CA;
	@FXML private TextField sc549ATT;
	@FXML private TextField sc549GRA;
	private boolean sc549valid = false;
	
	@FXML private CheckBox sc550;
	@FXML private TextField sc550EME;
	@FXML private TextField sc550CA;
	@FXML private TextField sc550ATT;
	@FXML private TextField sc550GRA;
	private boolean sc550valid = false;
	
	@FXML private CheckBox sc551;
	@FXML private TextField sc551EME;
	@FXML private TextField sc551CA;
	@FXML private TextField sc551ATT;
	@FXML private TextField sc551GRA;
	private boolean sc551valid = false;
	
	@FXML private CheckBox sc552;
	@FXML private TextField sc552EME;
	@FXML private TextField sc552CA;
	@FXML private TextField sc552ATT;
	@FXML private TextField sc552GRA;
	private boolean sc552valid = false;
	
	@FXML private CheckBox sc553;
	@FXML private TextField sc553EME;
	@FXML private TextField sc553CA;
	@FXML private TextField sc553ATT;
	@FXML private TextField sc553GRA;
	private boolean sc553valid = false;
	
	@FXML private CheckBox sc556;
	@FXML private TextField sc556EME;
	@FXML private TextField sc556CA;
	@FXML private TextField sc556ATT;
	@FXML private TextField sc556GRA;
	private boolean sc556valid = false;
	
	@FXML private CheckBox sc557;
	@FXML private TextField sc557EME;
	@FXML private TextField sc557CA;
	@FXML private TextField sc557ATT;
	@FXML private TextField sc557GRA;
	private boolean sc557valid = false;
	
	@FXML private CheckBox sc558;
	@FXML private TextField sc558EME;
	@FXML private TextField sc558CA;
	@FXML private TextField sc558ATT;
	@FXML private TextField sc558GRA;
	private boolean sc558valid = false;
	
	@FXML private CheckBox sc559;
	@FXML private TextField sc559EME;
	@FXML private TextField sc559CA;
	@FXML private TextField sc559ATT;
	@FXML private TextField sc559GRA;
	private boolean sc559valid = false;
	
	@FXML private CheckBox sc560;
	@FXML private TextField sc560EME;
	@FXML private TextField sc560CA;
	@FXML private TextField sc560ATT;
	@FXML private TextField sc560GRA;
	private boolean sc560valid = false;
	
	@FXML private CheckBox sc561;
	@FXML private TextField sc561EME;
	@FXML private TextField sc561CA;
	@FXML private TextField sc561ATT;
	@FXML private TextField sc561GRA;
	private boolean sc561valid = false;
	
	
	Enrollments enroll = new Enrollments(0, "", 0, 0, 0, 0, "", "");
	Modules mod = new Modules();
	Students student = new Students();
	
	double total = 0;
	int credits = 0;
	String passOrFail = null;
	
	static int semesterTwo = 0;
	int stuID = student.stuID;
	
	//Check Box Selection Action
	@FXML
	private void checkBoxSelected(ActionEvent checkBoxEvent) throws IOException{
		/* If the Check Box is selected, make it editable
		 * Else if Check Box is unselected
		 * Make it not editable and clear the value in it
		 * By default Check Box is not editable
		 */
		if(sc547.isSelected()){
			sc547EME.setEditable(true);
			sc547CA.setEditable(true);
			sc547ATT.setEditable(true);
			sc547GRA.setEditable(true);
		}else{
			sc547EME.setEditable(false);
			sc547EME.clear();
			sc547CA.setEditable(false);
			sc547CA.clear();
			sc547ATT.setEditable(false);
			sc547ATT.clear();
			sc547GRA.setEditable(false);
			sc547GRA.clear();
		}
		
		if(sc548.isSelected()){
			sc548EME.setEditable(true);
			sc548CA.setEditable(true);
			sc548ATT.setEditable(true);
			sc548GRA.setEditable(true);
		}else{
			sc548EME.setEditable(false);
			sc548EME.clear();
			sc548CA.setEditable(false);
			sc548CA.clear();
			sc548ATT.setEditable(false);
			sc548ATT.clear();
			sc548GRA.setEditable(false);
			sc548GRA.clear();
		}
		
		if(sc549.isSelected()){
			sc549EME.setEditable(true);
			sc549CA.setEditable(true);
			sc549ATT.setEditable(true);
			sc549GRA.setEditable(true);
		}else{
			sc549EME.setEditable(false);
			sc549EME.clear();
			sc549CA.setEditable(false);
			sc549CA.clear();
			sc549ATT.setEditable(false);
			sc549ATT.clear();
			sc549GRA.setEditable(false);
			sc549GRA.clear();
		}
		
		if(sc550.isSelected()){
			sc550EME.setEditable(true);
			sc550CA.setEditable(true);
			sc550ATT.setEditable(true);
			sc550GRA.setEditable(true);
		}else{
			sc550EME.setEditable(false);
			sc550EME.clear();
			sc550CA.setEditable(false);
			sc550CA.clear();
			sc550ATT.setEditable(false);
			sc550ATT.clear();
			sc550GRA.setEditable(false);
			sc550GRA.clear();
		}
		
		if(sc551.isSelected()){
			sc551EME.setEditable(true);
			sc551CA.setEditable(true);
			sc551ATT.setEditable(true);
			sc551GRA.setEditable(true);
		}else{
			sc551EME.setEditable(false);
			sc551EME.clear();
			sc551CA.setEditable(false);
			sc551CA.clear();
			sc551ATT.setEditable(false);
			sc551ATT.clear();
			sc551GRA.setEditable(false);
			sc551GRA.clear();
		}
		
		if(sc552.isSelected()){
			sc552EME.setEditable(true);
			sc552CA.setEditable(true);
			sc552ATT.setEditable(true);
			sc552GRA.setEditable(true);
		}else{
			sc552EME.setEditable(false);
			sc552EME.clear();
			sc552CA.setEditable(false);
			sc552CA.clear();
			sc552ATT.setEditable(false);
			sc552ATT.clear();
			sc552GRA.setEditable(false);
			sc552GRA.clear();
		}
		
		if(sc553.isSelected()){
			sc553EME.setEditable(true);
			sc553CA.setEditable(true);
			sc553ATT.setEditable(true);
			sc553GRA.setEditable(true);
		}else{
			sc553EME.setEditable(false);
			sc553EME.clear();
			sc553CA.setEditable(false);
			sc553CA.clear();
			sc553ATT.setEditable(false);
			sc553ATT.clear();
			sc553GRA.setEditable(false);
			sc553GRA.clear();
		}
		
		if(sc556.isSelected()){
			sc556EME.setEditable(true);
			sc556CA.setEditable(true);
			sc556ATT.setEditable(true);
			sc556GRA.setEditable(true);
		}else{
			sc556EME.setEditable(false);
			sc556EME.clear();
			sc556CA.setEditable(false);
			sc556CA.clear();
			sc556ATT.setEditable(false);
			sc556ATT.clear();
			sc556GRA.setEditable(false);
			sc556GRA.clear();
		}
		
		if(sc557.isSelected()){
			sc557EME.setEditable(true);
			sc557CA.setEditable(true);
			sc557ATT.setEditable(true);
			sc557GRA.setEditable(true);
		}else{
			sc557EME.setEditable(false);
			sc557EME.clear();
			sc557CA.setEditable(false);
			sc557CA.clear();
			sc557ATT.setEditable(false);
			sc557ATT.clear();
			sc557GRA.setEditable(false);
			sc557GRA.clear();
		}
		
		if(sc558.isSelected()){
			sc558EME.setEditable(true);
			sc558CA.setEditable(true);
			sc558ATT.setEditable(true);
			sc558GRA.setEditable(true);
		}else{
			sc558EME.setEditable(false);
			sc558EME.clear();
			sc558CA.setEditable(false);
			sc558CA.clear();
			sc558ATT.setEditable(false);
			sc558ATT.clear();
			sc558GRA.setEditable(false);
			sc558GRA.clear();
		}
		
		if(sc559.isSelected()){
			sc559EME.setEditable(true);
			sc559CA.setEditable(true);
			sc559ATT.setEditable(true);
			sc559GRA.setEditable(true);
		}else{
			sc559EME.setEditable(false);
			sc559EME.clear();
			sc559CA.setEditable(false);
			sc559CA.clear();
			sc559ATT.setEditable(false);
			sc559ATT.clear();
			sc559GRA.setEditable(false);
			sc559GRA.clear();
		}
		
		if(sc560.isSelected()){
			sc560EME.setEditable(true);
			sc560CA.setEditable(true);
			sc560ATT.setEditable(true);
			sc560GRA.setEditable(true);
		}else{
			sc560EME.setEditable(false);
			sc560EME.clear();
			sc560CA.setEditable(false);
			sc560CA.clear();
			sc560ATT.setEditable(false);
			sc560ATT.clear();
			sc560GRA.setEditable(false);
			sc560GRA.clear();
		}
		
		if(sc561.isSelected()){
			sc561EME.setEditable(true);
			sc561CA.setEditable(true);
			sc561ATT.setEditable(true);
			sc561GRA.setEditable(true);
		}else{
			sc561EME.setEditable(false);
			sc561EME.clear();
			sc561CA.setEditable(false);
			sc561CA.clear();
			sc561ATT.setEditable(false);
			sc561ATT.clear();
			sc561GRA.setEditable(false);
			sc561GRA.clear();
		}
		
	}
	
	/*
	 * Saves Marks - Enrollment - to Database
	 */
	@FXML
	private void saveBtn(ActionEvent saveEvent) throws IOException{
		
		boolean valid = false;
		//Core Module - Storing End Of Mod, Cont Asses, Attendance Hours, and Grade Point
		int[][] integerVal = new int[4][3];
		float[] gradePoint = new float[3];
		//Optional Module - Stroing End Of Mod, Cont Asses, Attendance Hours, and Grade Point
		int[][] optionalIntVal = new int[13][3];
		float[] optionalGP = new float[13];
		//Module sc597 - Storing the Grade (NOT GRADE POINT)
		String sc597GRAval = null;
		
		/*Core Modules - Semester One
		 *Module sc546 
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc546EME.getText().isEmpty() && !sc546CA.getText().isEmpty() && !sc546ATT.getText().isEmpty() && !sc546GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
			if(Integer.parseInt(sc546EME.getText())<=100 && Integer.parseInt(sc546CA.getText())<=100 && Float.parseFloat(sc546GRA.getText())<=4 && Integer.parseInt(sc546ATT.getText())<=mod.getModHours("sc546")){
				
				//If all conditions met, module valid variable is set to true
				try{
					integerVal[0][0] = Integer.parseInt(sc546EME.getText());
					integerVal[0][1] = Integer.parseInt(sc546CA.getText());
					integerVal[0][2] = Integer.parseInt(sc546ATT.getText());
					gradePoint[0] = Float.parseFloat(sc546GRA.getText());
					sc546valid = true;
				}catch(Exception ex){
					sc546valid = false;
				}
			}else{
				sc546valid = false;
				lblError.setText("Values out of range.");
			}
			}catch(Exception e){
				sc546valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc546valid=false;
			lblError.setText("Empty values.");
		}
		
		
		/*Module sc554
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc554EME.getText().isEmpty() && !sc554CA.getText().isEmpty() && !sc554ATT.getText().isEmpty() && !sc554GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
			if(Integer.parseInt(sc554EME.getText())<=100 && Integer.parseInt(sc554CA.getText())<=100 && Float.parseFloat(sc554GRA.getText())<=4 && Integer.parseInt(sc554ATT.getText())<=mod.getModHours("sc554")){
				integerVal[1][0] = Integer.parseInt(sc554EME.getText());
				integerVal[1][1] = Integer.parseInt(sc554CA.getText());
				integerVal[1][2] = Integer.parseInt(sc554ATT.getText());
				//If all conditions met, module valid variable is set to true
				try{
					gradePoint[1] = Float.parseFloat(sc554GRA.getText());
					sc554valid = true;
				}catch(Exception ex){
					sc554valid = false;
				}
			}else{
				sc554valid = false;
				lblError.setText("Values out of range.");
			}
			}catch(Exception e){
				sc554valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc554valid=false;
			lblError.setText("Empty values.");
		}
		
		
		/*Module sc555
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc555EME.getText().isEmpty() && !sc555CA.getText().isEmpty() && !sc555ATT.getText().isEmpty() && !sc555GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
			if(Integer.parseInt(sc555EME.getText())<=100 && Integer.parseInt(sc555CA.getText())<=100 && Float.parseFloat(sc555GRA.getText())<=4 && Integer.parseInt(sc555ATT.getText())<=mod.getModHours("sc555")){
				integerVal[2][0] = Integer.parseInt(sc555EME.getText());
				integerVal[2][1] = Integer.parseInt(sc555CA.getText());
				integerVal[2][2] = Integer.parseInt(sc555ATT.getText());
				//If all conditions met, module valid variable is set to true
				try{
					gradePoint[2] = Float.parseFloat(sc555GRA.getText());
					sc555valid = true;
				}catch(Exception ex){
					sc555valid = false;
				}
				sc555valid = true;
			}else{
				sc555valid = false;
				lblError.setText("Values out of range.");
			}
			}catch(Exception e){
				sc555valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc555valid=false;
			lblError.setText("Empty values.");
		}
		
		
		/*Module sc597
		 *Check if Empty - Cannot be Empty
		 */
		if(!sc597EME.getText().isEmpty() && !sc597CA.getText().isEmpty() && !sc597ATT.getText().isEmpty() && !sc597GRA.getText().isEmpty()){
			//Check if values are valid and are within range
			try{
			if(Integer.parseInt(sc597EME.getText())<=100 && Integer.parseInt(sc597CA.getText())<=100 && Integer.parseInt(sc597ATT.getText())<=mod.getModHours("sc597")){
				integerVal[3][0] = Integer.parseInt(sc597EME.getText());
				integerVal[3][1] = Integer.parseInt(sc597CA.getText());
				integerVal[3][2] = Integer.parseInt(sc597ATT.getText());
				
				if(enroll.validGradeO(sc597GRA.getText())){
					sc597GRAval = sc597GRA.getText();
					sc597valid = true;
				}else{
					lblError.setText("Invalid Grade");
					sc597valid = false;
				}
			}else{
				sc597valid = false;
				lblError.setText("Values out of range.");
			}
			}catch(Exception e){
				sc597valid = false;
				lblError.setText("Recheck Input");
			}
		}else{
			sc597valid=false;
			lblError.setText("Empty values.");
		}
		
		/* Optional Modules
		 * Module sc547
		 * If Checkbox is selected
		 */
		if(sc547.isSelected()){
			if(!sc547EME.getText().isEmpty() && !sc547CA.getText().isEmpty() && !sc547ATT.getText().isEmpty() && !sc547GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc547EME.getText())<=100 && Integer.parseInt(sc547CA.getText())<=100 && Integer.parseInt(sc547ATT.getText())<=mod.getModHours("sc547") && Float.parseFloat(sc547GRA.getText())<=4){
					optionalIntVal[0][0] = Integer.parseInt(sc547EME.getText());
					optionalIntVal[0][1] = Integer.parseInt(sc547CA.getText());
					optionalIntVal[0][2] = Integer.parseInt(sc547ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[0] = Float.parseFloat(sc547GRA.getText());
						sc547valid = true;
					}catch(Exception ex){
						sc547valid = false;
					}
				}else{
					sc547valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc547valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc547valid = false;
			}
		}else{
			sc547valid = true;
		}
		
		
		/*
		 * Module sc548
		 * If Checkbox is selected
		 */
		if(sc548.isSelected()){
			if(!sc548EME.getText().isEmpty() && !sc548CA.getText().isEmpty() && !sc548ATT.getText().isEmpty() && !sc548GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc548EME.getText())<=100 && Integer.parseInt(sc548CA.getText())<=100 && Integer.parseInt(sc548ATT.getText())<=mod.getModHours("sc548") && Float.parseFloat(sc548GRA.getText())<=4){
					optionalIntVal[1][0] = Integer.parseInt(sc548EME.getText());
					optionalIntVal[1][1] = Integer.parseInt(sc548CA.getText());
					optionalIntVal[1][2] = Integer.parseInt(sc548ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[1] = Float.parseFloat(sc548GRA.getText());
						sc548valid = true;
					}catch(Exception ex){
						sc548valid = false;
					}
				}else{
					sc548valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc548valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc548valid = false;
			}
		}else{
			sc548valid = true;
		}
		

		/*
		 * Module sc549
		 * If Checkbox is selected
		 */
		if(sc549.isSelected()){
			if(!sc549EME.getText().isEmpty() && !sc549CA.getText().isEmpty() && !sc549ATT.getText().isEmpty() && !sc549GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc549EME.getText())<=100 && Integer.parseInt(sc549CA.getText())<=100 && Integer.parseInt(sc549ATT.getText())<=mod.getModHours("sc549") && Float.parseFloat(sc549GRA.getText())<=4){
					optionalIntVal[2][0] = Integer.parseInt(sc549EME.getText());
					optionalIntVal[2][1] = Integer.parseInt(sc549CA.getText());
					optionalIntVal[2][2] = Integer.parseInt(sc549ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[2] = Float.parseFloat(sc549GRA.getText());
						sc549valid = true;
					}catch(Exception ex){
						sc549valid = false;
					}
				}else{
					sc549valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc549valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc549valid = false;
			}
		}else{
			sc549valid = true;
		}
		

		/*
		 * Module sc550
		 * If Checkbox is selected
		 */
		if(sc550.isSelected()){
			if(!sc550EME.getText().isEmpty() && !sc550CA.getText().isEmpty() && !sc550ATT.getText().isEmpty() && !sc550GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc550EME.getText())<=100 && Integer.parseInt(sc550CA.getText())<=100 && Integer.parseInt(sc550ATT.getText())<=mod.getModHours("sc550") && Float.parseFloat(sc550GRA.getText())<=4){
					optionalIntVal[3][0] = Integer.parseInt(sc550EME.getText());
					optionalIntVal[3][1] = Integer.parseInt(sc550CA.getText());
					optionalIntVal[3][2] = Integer.parseInt(sc550ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[3] = Float.parseFloat(sc550GRA.getText());
						sc550valid = true;
					}catch(Exception ex){
						sc550valid = false;
					}
				}else{
					sc550valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc550valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc550valid = false;
			}
		}else{
			sc550valid = true;
		}
		
		
		/*
		 * Module sc551
		 * If Checkbox is selected
		 */
		if(sc551.isSelected()){
			if(!sc551EME.getText().isEmpty() && !sc551CA.getText().isEmpty() && !sc551ATT.getText().isEmpty() && !sc551GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc551EME.getText())<=100 && Integer.parseInt(sc551CA.getText())<=100 && Integer.parseInt(sc551ATT.getText())<=mod.getModHours("sc551") && Float.parseFloat(sc551GRA.getText())<=4){
					optionalIntVal[4][0] = Integer.parseInt(sc551EME.getText());
					optionalIntVal[4][1] = Integer.parseInt(sc551CA.getText());
					optionalIntVal[4][2] = Integer.parseInt(sc551ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[4] = Float.parseFloat(sc551GRA.getText());
						sc551valid = true;
					}catch(Exception ex){
						sc551valid = false;
					}
				}else{
					sc551valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc551valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc551valid = false;
			}
		}else{
			sc551valid = true;
		}
		
		
		/*
		 * Module sc552
		 * If Checkbox is selected
		 */
		if(sc552.isSelected()){
			if(!sc552EME.getText().isEmpty() && !sc552CA.getText().isEmpty() && !sc552ATT.getText().isEmpty() && !sc552GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc552EME.getText())<=100 && Integer.parseInt(sc552CA.getText())<=100 && Integer.parseInt(sc552ATT.getText())<=mod.getModHours("sc552") && Float.parseFloat(sc552GRA.getText())<=4){
					optionalIntVal[5][0] = Integer.parseInt(sc552EME.getText());
					optionalIntVal[5][1] = Integer.parseInt(sc552CA.getText());
					optionalIntVal[5][2] = Integer.parseInt(sc552ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[5] = Float.parseFloat(sc552GRA.getText());
						sc552valid = true;
					}catch(Exception ex){
						sc552valid = false;
					}
				}else{
					sc552valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc552valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc552valid = false;
			}
		}else{
			sc552valid = true;
		}
		
		
		/*
		 * Module sc553
		 * If Checkbox is selected
		 */
		if(sc553.isSelected()){
			if(!sc553EME.getText().isEmpty() && !sc553CA.getText().isEmpty() && !sc553ATT.getText().isEmpty() && !sc553GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc553EME.getText())<=100 && Integer.parseInt(sc553CA.getText())<=100 && Integer.parseInt(sc553ATT.getText())<=mod.getModHours("sc553") && Float.parseFloat(sc553GRA.getText())<=4){
					optionalIntVal[6][0] = Integer.parseInt(sc553EME.getText());
					optionalIntVal[6][1] = Integer.parseInt(sc553CA.getText());
					optionalIntVal[6][2] = Integer.parseInt(sc553ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[6] = Float.parseFloat(sc553GRA.getText());
						sc553valid = true;
					}catch(Exception ex){
						sc553valid = false;
					}
				}else{
					sc553valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc553valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc553valid = false;
			}
		}else{
			sc553valid = true;
		}
		
		
		/*
		 * Module sc556
		 * If Checkbox is selected
		 */
		if(sc556.isSelected()){
			if(!sc556EME.getText().isEmpty() && !sc556CA.getText().isEmpty() && !sc556ATT.getText().isEmpty() && !sc556GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc556EME.getText())<=100 && Integer.parseInt(sc556CA.getText())<=100 && Integer.parseInt(sc556ATT.getText())<=mod.getModHours("sc556") && Float.parseFloat(sc556GRA.getText())<=4){
					optionalIntVal[7][0] = Integer.parseInt(sc556EME.getText());
					optionalIntVal[7][1] = Integer.parseInt(sc556CA.getText());
					optionalIntVal[7][2] = Integer.parseInt(sc556ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[7] = Float.parseFloat(sc556GRA.getText());
						sc556valid = true;
					}catch(Exception ex){
						sc556valid = false;
					}
				}else{
					sc556valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc556valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc556valid = false;
			}
		}else{
			sc556valid = true;
		}
		
		
		/*
		 * Module sc557
		 * If Checkbox is selected
		 */
		if(sc557.isSelected()){
			if(!sc557EME.getText().isEmpty() && !sc557CA.getText().isEmpty() && !sc557ATT.getText().isEmpty() && !sc557GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc557EME.getText())<=100 && Integer.parseInt(sc557CA.getText())<=100 && Integer.parseInt(sc557ATT.getText())<=mod.getModHours("sc557") && Float.parseFloat(sc557GRA.getText())<=4){
					optionalIntVal[8][0] = Integer.parseInt(sc557EME.getText());
					optionalIntVal[8][1] = Integer.parseInt(sc557CA.getText());
					optionalIntVal[8][2] = Integer.parseInt(sc557ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[8] = Float.parseFloat(sc557GRA.getText());
						sc557valid = true;
					}catch(Exception ex){
						sc557valid = false;
					}
				}else{
					sc557valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc557valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc557valid = false;
			}
		}else{
			sc557valid = true;
		}
		
		
		/*
		 * Module sc558
		 * If Checkbox is selected
		 */
		if(sc558.isSelected()){
			if(!sc558EME.getText().isEmpty() && !sc558CA.getText().isEmpty() && !sc558ATT.getText().isEmpty() && !sc558GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc558EME.getText())<=100 && Integer.parseInt(sc558CA.getText())<=100 && Integer.parseInt(sc558ATT.getText())<=mod.getModHours("sc558") && Float.parseFloat(sc558GRA.getText())<=4){
					optionalIntVal[9][0] = Integer.parseInt(sc558EME.getText());
					optionalIntVal[9][1] = Integer.parseInt(sc558CA.getText());
					optionalIntVal[9][2] = Integer.parseInt(sc558ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[9] = Float.parseFloat(sc558GRA.getText());
						sc558valid = true;
					}catch(Exception ex){
						sc558valid = false;
					}
				}else{
					sc558valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc558valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc558valid = false;
			}
		}else{
			sc558valid = true;
		}
		
		
		/*
		 * Module sc559
		 * If Checkbox is selected
		 */
		if(sc559.isSelected()){
			if(!sc559EME.getText().isEmpty() && !sc559CA.getText().isEmpty() && !sc559ATT.getText().isEmpty() && !sc559GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc559EME.getText())<=100 && Integer.parseInt(sc559CA.getText())<=100 && Integer.parseInt(sc559ATT.getText())<=mod.getModHours("sc559") && Float.parseFloat(sc559GRA.getText())<=4){
					optionalIntVal[10][0] = Integer.parseInt(sc559EME.getText());
					optionalIntVal[10][1] = Integer.parseInt(sc559CA.getText());
					optionalIntVal[10][2] = Integer.parseInt(sc559ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[10] = Float.parseFloat(sc559GRA.getText());
						sc559valid = true;
					}catch(Exception ex){
						sc559valid = false;
					}
				}else{
					sc559valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc559valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc559valid = false;
			}
		}else{
			sc559valid = true;
		}
		
		
		/*
		 * Module sc560
		 * If Checkbox is selected
		 */
		if(sc560.isSelected()){
			if(!sc560EME.getText().isEmpty() && !sc560CA.getText().isEmpty() && !sc560ATT.getText().isEmpty() && !sc560GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc560EME.getText())<=100 && Integer.parseInt(sc560CA.getText())<=100 && Integer.parseInt(sc560ATT.getText())<=mod.getModHours("sc560") && Float.parseFloat(sc560GRA.getText())<=4){
					optionalIntVal[11][0] = Integer.parseInt(sc560EME.getText());
					optionalIntVal[11][1] = Integer.parseInt(sc560CA.getText());
					optionalIntVal[11][2] = Integer.parseInt(sc560ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[11] = Float.parseFloat(sc560GRA.getText());
						sc560valid = true;
					}catch(Exception ex){
						sc560valid = false;
					}
				}else{
					sc560valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc560valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc560valid = false;
			}
		}else{
			sc560valid = true;
		}
		
		
		/*
		 * Module sc561
		 * If Checkbox is selected
		 */
		if(sc561.isSelected()){
			if(!sc561EME.getText().isEmpty() && !sc561CA.getText().isEmpty() && !sc561ATT.getText().isEmpty() && !sc561GRA.getText().isEmpty()){
				//Check if values are valid and are within range
				try{
				if(Integer.parseInt(sc561EME.getText())<=100 && Integer.parseInt(sc561CA.getText())<=100 && Integer.parseInt(sc561ATT.getText())<=mod.getModHours("sc561") && Float.parseFloat(sc561GRA.getText())<=4){
					optionalIntVal[12][0] = Integer.parseInt(sc561EME.getText());
					optionalIntVal[12][1] = Integer.parseInt(sc561CA.getText());
					optionalIntVal[12][2] = Integer.parseInt(sc561ATT.getText());
					//If all conditions met, module valid variable is set to true
					try{
						optionalGP[12] = Float.parseFloat(sc561GRA.getText());
						sc561valid = true;
					}catch(Exception ex){
						sc561valid = false;
					}
				}else{
					sc561valid = false;
					lblError.setText("Values out of range.");
				}
				}catch(Exception e){
					sc561valid = false;
					lblError.setText("Recheck Input");
				}
			}else{
				sc561valid = false;
			}
		}else{
			sc561valid = true;
		}
		
		if(sc546valid && sc554valid && sc555valid && sc547valid && sc548valid && sc549valid && sc550valid && sc551valid && sc552valid && sc553valid && sc556valid && sc557valid && sc558valid && sc559valid && sc560valid && sc561valid && sc597valid){
			
			
			/* CORE MODULES
			 * Module sc546
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[0][0], integerVal[0][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[0],integerVal[0][2],"sc546");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc546");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc531", total, integerVal[0][2], credits, gradePoint[0], passOrFail);
			
			/* Module sc554
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[1][0], integerVal[1][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[1],integerVal[1][2],"sc554");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc554");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc554", total, integerVal[1][2], credits, gradePoint[1], passOrFail);
			
			/* Module sc555
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[2][0], integerVal[2][1]);
			
			//Decide whether PASS or FAIL
			passOrFail = enroll.passorfail(gradePoint[2],integerVal[2][2],"sc555");
			//Retrieve the Credits from the 'modules' table for the given Module Code
			if(passOrFail == "PASS"){
				credits = mod.getModCredits("sc555");
			}else{
				credits = 0;
			}
			//If All Data Valid, store the enrollment details in the 'enrollment' table
			enroll.setEnroll(stuID, "sc555", total, integerVal[2][2], credits, gradePoint[2], passOrFail);
			
			/* Module sc597
			 * End Of Module Examination and Continuous Assessment Total Marks
			*/
			total = enroll.findTotal(integerVal[3][0], integerVal[3][1]);
			credits = mod.getModCredits("sc597");
			enroll.setEnrollOthers(stuID, "sc597", credits, total, integerVal[3][2], sc597GRAval);
			
			
			/*
			 * Optional Modules 
			 * Module sc547
			 */
			if(sc547.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[0][0], optionalIntVal[0][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[0],optionalIntVal[0][2],"sc547");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc547");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc547", total, optionalIntVal[0][2], credits, optionalGP[0], passOrFail);
			}
			
			//Module sc548
			if(sc548.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[1][0], optionalIntVal[1][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[1],optionalIntVal[1][2],"sc548");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc548");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc548", total, optionalIntVal[1][2], credits, optionalGP[1], passOrFail);
			}
			
			//Module sc549	
			if(sc549.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[2][0], optionalIntVal[2][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[2],optionalIntVal[2][2],"sc549");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc549");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc549", total, optionalIntVal[2][2], credits, optionalGP[2], passOrFail);
			}
			
			//Module sc550
			if(sc550.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[3][0], optionalIntVal[3][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[3],optionalIntVal[3][2],"sc550");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc550");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc550", total, optionalIntVal[3][2], credits, optionalGP[3], passOrFail);
			}
			
			//Module sc551
			if(sc551.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[4][0], optionalIntVal[4][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[4],optionalIntVal[4][2],"sc551");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc551");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc551", total, optionalIntVal[4][2], credits, optionalGP[4], passOrFail);
			}
			
			//Module sc552
			if(sc552.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[5][0], optionalIntVal[5][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[5],optionalIntVal[5][2],"sc552");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc552");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc552", total, optionalIntVal[5][2], credits, optionalGP[5], passOrFail);
			}
			
			//Module sc553
			if(sc553.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[6][0], optionalIntVal[6][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[6],optionalIntVal[6][2],"sc553");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc553");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc553", total, optionalIntVal[6][2], credits, optionalGP[6], passOrFail);
			}
			
			//Module sc556
			if(sc556.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[7][0], optionalIntVal[7][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[7],optionalIntVal[7][2],"sc556");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc556");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc556", total, optionalIntVal[7][2], credits, optionalGP[7], passOrFail);
			}
			
			//Module sc557
			if(sc557.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[8][0], optionalIntVal[8][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[8],optionalIntVal[8][2],"sc557");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc557");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc557", total, optionalIntVal[8][2], credits, optionalGP[8], passOrFail);
			}
			
			//Module sc558
			if(sc558.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[9][0], optionalIntVal[9][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[9],optionalIntVal[9][2],"sc558");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc558");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc558", total, optionalIntVal[9][2], credits, optionalGP[9], passOrFail);
			}
			
			//Module sc559
			if(sc559.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[10][0], optionalIntVal[10][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[10],optionalIntVal[10][2],"sc559");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc559");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc559", total, optionalIntVal[10][2], credits, optionalGP[10], passOrFail);
			}
			
			//Module sc560
			if(sc560.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[11][0], optionalIntVal[11][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[11],optionalIntVal[11][2],"sc560");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc560");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc560", total, optionalIntVal[11][2], credits, optionalGP[11], passOrFail);
			}
			
			//Module sc561
			if(sc561.isSelected()){
				//End Of Module Examination and Continuous Assessment Total Marks
				total = enroll.findTotal(optionalIntVal[12][0], optionalIntVal[12][1]);
				
				//Decide whether PASS or FAIL
				passOrFail = enroll.passorfail(optionalGP[12],optionalIntVal[12][2],"sc561");
				//Retrieve the Credits from the 'modules' table for the given Module Code
				if(passOrFail == "PASS"){
					credits = mod.getModCredits("sc561");
				}else{
					credits = 0;
				}
				//If All Data Valid, store the enrollment details in the 'enrollment' table
				enroll.setEnroll(stuID, "sc561", total, optionalIntVal[12][2], credits, optionalGP[12], passOrFail);
			}
				semesterTwo = 1;	
			
				Stage stage = (Stage) btnSave.getScene().getWindow();
				stage.close();
			
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
