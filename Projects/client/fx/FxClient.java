package client.fx;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.event.*;

public class FxClient extends Application {
	
	final private String version = "v.01.00";
	private int width  = 550,
                height = 350;
    
	Menu menuFile,
	     menuLanguage;
	
	Button connectBtn;
	
	public static void main(String[] args){
		launch();
	}
	
	public void init(){
	}
	
	public void start(Stage stg){
		stg.setTitle("FxClient " + version);
		
		Scene scn = new Scene(new Pane(), width, height);
		scn.getStylesheets().add("FxClientStyle.css");
		((Pane) scn.getRoot()).getStyleClass().add("root");
		//((Pane) scn.getRoot()).setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		MenuBar menuBar = new MenuBar();
		menuBar.getStyleClass().add("menu-bar");
		//menuBar.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		menuBar.setPrefWidth(width + 10);
		
		menuFile = new Menu("File");
		menuFile.getStyleClass().add("menu-item");
		menuLanguage = new Menu("Language");
		
		ToggleGroup tglLandGroup = new ToggleGroup();
		
		RadioMenuItem langEng = new RadioMenuItem("English");
		langEng.setToggleGroup(tglLandGroup);
		langEng.setOnAction((ActionEvent e) -> {
			menuFile.setText("File");
			menuLanguage.setText("Language");
			connectBtn.setText("Connect");
		});
		
		RadioMenuItem langRus = new RadioMenuItem("Русский");
		langRus.setToggleGroup(tglLandGroup);
		langRus.setOnAction((ActionEvent e) -> {
			menuFile.setText("Файл");
			menuLanguage.setText("Язык");
			connectBtn.setText("Подключиться");
		});
		langEng.setSelected(true);
		menuLanguage.getItems().addAll(langEng, langRus);
		
		menuBar.getMenus().addAll(menuFile, menuLanguage);
		
		connectBtn = new Button("Connect");
		connectBtn.getStyleClass().add("button");
		connectBtn.resize(20, 30);
		connectBtn.relocate(50, 100);
		stg.setScene(scn);
		stg.setResizable(false);
		
		((Pane) scn.getRoot()).getChildren().addAll(menuBar, connectBtn);
		stg.show();
	}
	
	public void stop(){
	}
}