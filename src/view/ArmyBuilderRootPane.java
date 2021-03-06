package view;

import javafx.scene.control.Tab;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;

public class ArmyBuilderRootPane extends BorderPane
{
	private ArmyBuilderMenuBar mb;
	
	private TabPane tp;
	private Tab tab1, tab2;
	private CreateProfilePane cp;
	private AddUnitPane au;
	
	public ArmyBuilderRootPane()
	{
		this.getStylesheets().add(getClass().getResource("globalStyles.css").toExternalForm());
		
		mb = new ArmyBuilderMenuBar();
		cp = new CreateProfilePane();
		au = new AddUnitPane();
		
		tp = new TabPane();
		tab1 = new Tab("Create Profile", cp);
		tab2 = new Tab("Add Unit", au);
		
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //ensures user can't close tabs
		tp.getTabs().addAll(tab1, tab2);
						
		this.setTop(mb);
		this.setCenter(tp);
	}
	
	public void nextTab(int index) 
	{
		tp.getSelectionModel().select(index);
	}
	
	public ArmyBuilderMenuBar getArmyBuilderMenuBar()
	{
		return mb;
	}
	
	public CreateProfilePane getCreateProfilePane()
	{
		return cp;
	}
	
	public AddUnitPane getAddUnitPane()
	{
		return au;
	}	
}
