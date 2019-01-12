package badlagger.fxbox;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class FxBoxDbg extends Application{
	
	FxBoxButtons Buttons = new FxBoxButtons();
	
	public static void main(String[] args){
		launch();
	}
	
	public void start(Stage stg){
		stg.setTitle("FxBox debug window");
		
		Scene scn = new Scene(new Pane(), 300, 200);
		
		Buttons.addButton("Ok", 10, 20, 30, 10).setOnAction((ActionEvent event)->{
			System.out.println("Ok button pressed");
		});
		
		Buttons.addButton("Next", 10, 50, 30, 10).setOnAction((ActionEvent event)->{
			System.out.println("Next button pressed");
		});
		
		Buttons.add(scn);
		stg.setScene(scn);
		stg.show();
	}
}
 