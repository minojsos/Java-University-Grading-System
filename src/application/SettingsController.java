package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.stage.*;

public class SettingsController implements Initializable {
	
	@FXML private Button btnSave;
	@FXML private TextField endOfMod;
	@FXML private TextField contAsses;
	@FXML private PasswordField password;
	@FXML private Label lblError;
	
	Settings settings = new Settings();
	
	/*
	 * Save Button Action will ensure that endOfMod is between 50 and 60 (inclusive)
	 * contAsses will therefore be between 50 and 40 (inclusive)
	 * And save these values to the 'settings' table in the database
	 * Display errors if endOfMod is empty
	 */
	@FXML
	private void saveBtn(ActionEvent saveEvent) throws IOException{
		
		int endofmod;
		int contasses;
		String pass;
		
		if(!(endOfMod.getText().isEmpty()) && !(password.getText().isEmpty())){
			try{
			endofmod = Integer.parseInt(endOfMod.getText());
			pass = password.getText();
			if(endofmod>=50 && endofmod<=60){
				settings.setEndOfMod(endofmod);
				contasses = 100 - endofmod;
				settings.setContAsses(contasses);
				settings.setPassword(pass);
				Stage stage = (Stage) btnSave.getScene().getWindow();
				stage.close();
			}else{
				lblError.setText("Please enter a value between 50 and 60");
			}
			}catch(Exception ex){
				lblError.setText("Invalid value");
			}
		}else 
		
		if(!(endOfMod.getText().isEmpty()) && (password.getText().isEmpty())){
			try{
			endofmod = Integer.parseInt(endOfMod.getText());
			if(endofmod>=50 && endofmod<=60){
				settings.setEndOfMod(endofmod);
				contasses = 100 - endofmod;
				settings.setContAsses(contasses);
				Stage stage = (Stage) btnSave.getScene().getWindow();
				stage.close();
			}else{
				lblError.setText("Please enter a value between 50 and 60");
			}
			}catch(Exception ex){
				lblError.setText("Invalid value");
			}
		}else
		
		if((endOfMod.getText().isEmpty()) && !(password.getText().isEmpty())){
			pass = password.getText();
			lblError.setText("Please enter a value between 50 and 60 for End Of Module Examinations.");
			settings.setPassword(pass);
		}else
		
		if((endOfMod.getText().isEmpty()) && (password.getText().isEmpty())){
			lblError.setText("Please enter a value between 50 and 60 for End Of Module Examinations.");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try{
			endOfMod.setText(String.valueOf(settings.getEndOfMod()));
			contAsses.setText(String.valueOf(settings.getContAsses()));
		}catch(Exception e){System.out.println(e);}
	}
}
