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
 * To Display all the Student Details in Table View
 * Student Details for all the students is taken from the database
 */
public class ViewAllController implements Initializable {
	
	//Declare the table and the columns for the table
	@FXML private TableView<ViewAll> tableStudents;
	@FXML private TableColumn<ViewAll, Integer> columnID;
	@FXML private TableColumn<ViewAll, String> columnName;
	@FXML private TableColumn<ViewAll, Float> columnGPA;
	@FXML private TableColumn<ViewAll, String> columnEligible;
	
	private ObservableList<ViewAll> data;
	
	//Display the details for all the students by default
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try{
			new databaseConnect();
			
			Connection conn = databaseConnect.getConnection();
			data = FXCollections.observableArrayList();
			
			PreparedStatement retrieve = conn.prepareStatement("SELECT * FROM students");
			ResultSet result = retrieve.executeQuery();
			
			while(result.next()){
				int id = result.getInt("id");
				String name = result.getString("name");
				float gpa = result.getFloat("gpa");
				String eligible = result.getString("eligible");

				data.add(new ViewAll(id,name,gpa,eligible));
			}
			
		}catch(Exception e){System.out.println(e);}
		
		//Set values to the cells of the table
		columnID.setCellValueFactory(new PropertyValueFactory<>("idCol"));
		columnName.setCellValueFactory(new PropertyValueFactory<>("nameCol"));
		columnGPA.setCellValueFactory(new PropertyValueFactory<>("gpaCol"));
		columnEligible.setCellValueFactory(new PropertyValueFactory<>("eligibleCol"));
		
		tableStudents.setItems(data);
		
		
	}
}
