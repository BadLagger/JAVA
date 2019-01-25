package fxbox;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;

public class FxBoxButtons{
	private Button[] Buttons;
	private int      ButtonsNumber = 0;
	
	public Button add(String name, int x, int y, int h, int w){
		
		if(ButtonsNumber > 0){
			for(Button seek:Buttons){
				if(seek.getText().equals(name)) return null;
			}
		}
		
		Button[] NewButtons = new Button[ButtonsNumber + 1];
		
		for(int i = 0; i < ButtonsNumber; i++){
			NewButtons[i] = Buttons[i];
		}
		NewButtons[ButtonsNumber] = new Button(name);
		NewButtons[ButtonsNumber].relocate(x, y);
		NewButtons[ButtonsNumber].setPrefSize(h, w);
		Buttons = NewButtons;
		return NewButtons[ButtonsNumber++];
	}
	
	public Button get(String name){
		
		if(ButtonsNumber > 0){
			for(Button seek:Buttons){
				if(seek.getText().equals(name)) return seek;
			}
		}
		
		return null;
	}
	
	public void setTo(Scene scn){
		if(ButtonsNumber > 0){
			for(Button current:Buttons)
				((Pane)scn.getRoot()).getChildren().add(current);
		}
	}
}