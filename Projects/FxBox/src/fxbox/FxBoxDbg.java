package fxbox;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class FxBoxDbg extends Application{
	
	private FxBoxButtons      Buttons         = new FxBoxButtons();
	private FxBoxMenuItems    ButtonMenuItems = new FxBoxMenuItems();
    private FxBoxContextMenus Contexts        = new FxBoxContextMenus();	
	
	public static void main(String[] args){
		launch();
	}

	public void start(Stage stg){
		
		stg.setTitle("Fx box dbg window");
		
		Scene scn = new Scene(new Pane(), 300, 400);
		
		Buttons.add("Ok", 10, 20, 100, 20).setOnAction((ActionEvent event)->{
			FxBoxUtil.dbg("Button OK");
		});
		
		Contexts.add("Button");
		
		Buttons.get("Ok").setOnMouseClicked((MouseEvent event)->{
			if(event.getButton() == MouseButton.SECONDARY){
				FxBoxUtil.dbg("Show context");
				Contexts.get("Button").show(Buttons.get("Ok"), 0, 0);
			}
		});
		
		ButtonMenuItems.add("Test").setOnAction((ActionEvent event) ->{
			FxBoxUtil.dbg("Menu test");
		});
	
		ButtonMenuItems.setToContext(Contexts.get("Button"));
		Buttons.get("Ok").setContextMenu(Contexts.get("Button"));
		Buttons.setTo(scn);
		stg.setScene(scn);
		stg.show();
	}
}