package fxbox;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;

public class FxBoxContextMenus{
	
	private ContextMenu Contexts[];
	private int         ContextsNumber = 0;
						
	public  ContextMenu add(String name){
		if(ContextsNumber > 0){
			for(ContextMenu current:Contexts)
				if(current.getId().equals(name)) return null;
		}
		
		ContextMenu[] NewContexts = new ContextMenu[ContextsNumber + 1];
		
		for(int i = 0; i < ContextsNumber; i++){
			NewContexts[i] = Contexts[i];
		}
		NewContexts[ContextsNumber ] = new ContextMenu();
		NewContexts[ContextsNumber ].setId(name);
		Contexts = NewContexts;
		return NewContexts[ContextsNumber ++];
	}
	
	public ContextMenu get(String name){
		if(ContextsNumber > 0){
			for(ContextMenu seek:Contexts){
				if(seek.getId().equals(name)) return seek;
			}
		}
		return null;
	}
}