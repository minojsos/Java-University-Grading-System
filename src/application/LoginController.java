package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class LoginController implements Initializable {
	static String username;
	static String password;
    
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    
    @FXML private Button btnLogin;
    
    @FXML private Label lblTitle;
    
    Users user = new Users();
    
    @FXML
    private void login(ActionEvent event) throws Exception{
        username = txtUsername.getText();
        password = txtPassword.getText();
        
        boolean validLogin = false;
        boolean role;
        
        validLogin = Users.validateLogin(username, password);
        
        //Validate Username and Password
        if(validLogin){
        	role = Users.getRole(username,password);
        	//If role = 0 (true) THEN admin ELSE (false) student
        	if(role == true){
        		Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        		Scene scene = new Scene(root);
        		Stage stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        		stage.setTitle("Gugsi University of Computer Sciences - Administrator");
        		stage.setX(50);
        		stage.setY(0);
        		stage.setScene(scene);
        		stage.show();   
        	}else{
        		Users.userName(username);
        		Parent root = FXMLLoader.load(getClass().getResource("Students.fxml"));
            	Scene scene = new Scene(root);
            	Stage stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            	stage.setTitle("Gugsi University of Computer Sciences - Student");
            	stage.setScene(scene);
            	stage.setX(50);
            	stage.setY(0);
            	stage.show();
        	}
        }
        else {
        	//Display Error Message
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Invalid Username or Password \nIf you are student, consult a staff");
            error.showAndWait();
        }
        
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
