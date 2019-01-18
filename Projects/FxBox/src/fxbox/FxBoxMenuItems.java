package fxbox;

import javafx.scene.control.*;

public class FxBoxMenuItems{
	private MenuItem[] Items;
	private int        ItemsNumber = 0;
	
	public MenuItem add(String name){
		if(ItemsNumber > 0){
			for(MenuItem current:Items)
				if(current.getId().equals(name)) return null;
		}
		
		MenuItem[] NewItems = new MenuItem[ItemsNumber + 1];
		
		for(int i = 0; i < ItemsNumber; i++){
			NewItems[i] = Items[i];
		}
		NewItems[ItemsNumber] = new MenuItem(name);
		NewItems[ItemsNumber].setId(name);
		Items = NewItems;
		return NewItems[ItemsNumber++];
	}
	
	public MenuItem get(String name){
		if(ItemsNumber > 0){
			for(MenuItem seek:Items){
				if(seek.getId().equals(name)) return seek;
			}
		}
		return null;
	}
	
	public void setToContext(ContextMenu menu){
		if((menu != null) && (ItemsNumber > 0)){
			for(MenuItem i:Items){
				menu.getItems().add(i);
			}
		}
	}
}