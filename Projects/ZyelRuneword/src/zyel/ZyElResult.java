package zyel;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ZyElResult extends Stage{
	ZyElResult(){
		initModality(Modality.APPLICATION_MODAL);
		setTitle("Result");
		setResizable(false);
		Scene scn = new Scene(new Pane(), 640, 480);
		
		setScene(scn);
	}
}