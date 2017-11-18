package gui.view;

import java.time.LocalDate;
import java.util.ArrayList;

import gui.model.Unit_Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CreateProfilePane extends GridPane 
{
	private Label profileNameLbl, maxPointsLbl, dateLbl;
	private TextField profileName; 
	private ComboBox<Integer> maxPoints;
	private DatePicker date;
	private Button createBtn;
		
	public CreateProfilePane()
	{		
		this.setPadding(new Insets(40, 40, 40, 40));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setHalignment(HPos.RIGHT);
		this.getColumnConstraints().add(col1);
		
		profileNameLbl = new Label("Profile Name: ");
		maxPointsLbl = new Label("Max Points: ");
		dateLbl = new Label("Input Date: ");
		
		profileName = new TextField();
		
		/*ObservableList<Integer> points = FXCollections.observableArrayList();
		for (int i = 500; i < 5500; i = i + 500)
		{
			points.add(i);			
		}*/
		
		maxPoints = new ComboBox<Integer>();
		date = new DatePicker(LocalDate.now());		
		
		createBtn = new Button("Create Profile");
		
		this.add(profileNameLbl, 0, 0);
		this.add(profileName, 1, 0);
		
		this.add(maxPointsLbl, 0, 1);
		this.add(maxPoints, 1, 1);
		
		this.add(dateLbl, 0, 2);
		this.add(date, 1, 2);
				
		this.add(new HBox(), 0, 6);
		this.add(createBtn, 1, 6);		
	}
	
	public String getProfileName()
	{
		return profileName.getText();
	}
	
	public void populateMaxPointsComboBox(ArrayList<Integer> points)
	{
		maxPoints.getItems().addAll(points);
		maxPoints.getSelectionModel().select(0); //default selection
	}
	
	public Integer getSelectedMaxPoints()
	{
		return maxPoints.getSelectionModel().getSelectedItem();
	}
	
	public LocalDate getprofileDate()
	{
		return date.getValue();
	}
	
	public void CreateProfileHandler(EventHandler<ActionEvent> handler)
	{
		createBtn.setOnAction(handler);
	}	
}
