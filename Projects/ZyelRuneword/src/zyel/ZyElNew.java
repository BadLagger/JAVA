package zyel;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;

public class ZyElNew extends Stage{
	
	private Label lName = new Label("Name"),
		          lSockets = new Label("Sockets"),
		          lSockNum[] = new Label[5],
				  lClass = new Label("Class");
	
	private TextField tName = new TextField();
	
	private RadioButton rSocket[] = new RadioButton[5];
	private String[] classList;
	
	ObservableList ClassList = FXCollections.observableArrayList();
	ZyElList ClassListView;
	
	class ZyElList extends ComboBox{
		ZyElList(ObservableList list, int x, int y, int width){
			super(list);
			relocate(x, y);
			setPrefWidth(width);
			setEditable(false);
			//setCellFactory(ComboBoxListCell.forListView(list));
		}
	}
	
	ZyElNew(){
		initModality(Modality.APPLICATION_MODAL);
		setTitle("New");
        lName    = new Label("Name");
		lSockets = new Label("Sockets");
		
		setResizable(false);
		Scene scn = new Scene(new Pane(), 640, 480);
		
		CreateName();
		CreateSockets();
		CreateClassListView();
		
		((Pane)scn.getRoot()).getChildren().addAll(lName, tName, lSockets, 
												   rSocket[0], rSocket[1], rSocket[2], rSocket[3], rSocket[4],
												   lSockNum[0], lSockNum[1], lSockNum[2], lSockNum[3], lSockNum[4],
												   lClass,
												   ClassListView);
		setScene(scn);
	}
	
	public void showWindow(){
	    if(ZyElLang.getCurrent().equals("Eng")){
		  setTitle("New");
          lName.setText("Name");
		  lSockets.setText("Sockets");
		  lClass.setText("Class");
		} else {
		  setTitle("Новая запись в список предметов");
          lName.setText("Название");
		  lSockets.setText("Сокеты");
		  lClass.setText("Класс");
		}
		classList = ZyElLang.getCurrentCls();
		ClassList.setAll(classList);
		show();
	}
	
	private void CreateName(){
		lName.relocate(10, 10);
		tName.relocate(70, 5);
		tName.setPrefWidth(100);
	}
	
	private void CreateSockets(){
		ToggleGroup tgl = new ToggleGroup();
		lSockets.relocate(10, 50);
		for(int i = 0; i < rSocket.length; i++){
			rSocket[i] = new RadioButton();
			rSocket[i].setToggleGroup(tgl);
			lSockNum[i] = new Label(Integer.toString(i + 2)); 
			lSockNum[i].relocate(75 + i*20, 35);
			rSocket[i].setId("Sockets " + (i + 2));
			rSocket[i].relocate(70 + i*20, 50);
		}
	}
	
	private void CreateClassListView(){
		lClass.relocate(10, 90);
		ClassListView = new ZyElList(ClassList, 70, 90, 100);
		ClassListView.setCellFactory(ComboBoxListCell.forListView(ClassList));
	}
}