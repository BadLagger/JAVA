package fxbox;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;

public class FxBoxDbg extends Application{
	
	public static void main(String[] args){
		launch();
	}

	public void start(Stage stg){
		
		stg.setTitle("Fx box dbg window");
		
		Scene scn = new Scene(new Pane(), 300, 400);
		
		stg.setScene(scn);
		stg.show();
	}
}