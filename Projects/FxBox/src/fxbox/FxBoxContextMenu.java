package fxbox;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;

public class FxBoxContextMenus{
	
	private ContextMenu Contexts[];
	private int         ContextsNumber = 0;
						
	public  ContextMenu addContexMenu(String name){
		if(ContextsNumber > 0){
			for(ContextMenu current:Contexts)
				if(current.getId().equal(name)) return null;
		}
		
		ContextMenu NewContexts = new ContextMenu[ContextsNumber + 1];
		
		for(int i = 0; i < ContextsNumber; i++){
			NewContexts[i] = Contexts[i];
		}
		NewContexts[ContextsNumber ] = new MenuItem(name);
		NewContexts[ContextsNumber ].setId(name);
		Contexts = NewContexts;
		return NewContexts[ContextsNumber ++];
	}
	
	public ContexMenu get(String name){
		if(ContextsNumber > 0){
			for(ContextMenu seek:Contexts){
				if(seek.getId(name).equal(name)) return seek;
			}
		}
		return null;
	}
}