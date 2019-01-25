package zyel;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;

public class ZyElRuneword extends Application{
	
	final int mainWinWidth = 790, mainWinHeight = 510;
	
	final Label Min = new Label("Minimum"),
		        Max = new Label("Maximum");
	
	final Button   Process = new Button("Process");
	
	final ZyElCheck[] Sockets= {new ZyElCheck("2", 10, 10),
							    new ZyElCheck("3", 50, 10),
								new ZyElCheck("4", 90, 10),
								new ZyElCheck("5", 10, 40),
								new ZyElCheck("6", 50, 40)};
	final ZyElCheck[] Classes= {new ZyElCheck(ZyElLang.getCls(ZyElClass.ASSASSIN), 10, 10),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.BARBARIAN), 10, 45),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.DRUID), 10, 80),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.AMAZON), 10, 115),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.NECROMANCER), 10, 150),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.PALADIN), 130, 10),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.SORCERESS), 130, 45),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.ALL), 130, 80),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.NONE), 130, 115),
								new ZyElCheck(ZyElLang.getCls(ZyElClass.ONLY), 130, 150)}; 
	final ZyElCheck[] Items= {new ZyElCheck("Amulet", 10, 10), 
							  new ZyElCheck("Any armor", 10, 45),
							  new ZyElCheck("Auric shield", 10, 80),
							  new ZyElCheck("Belt", 10, 115),
							  new ZyElCheck("Boot", 10, 150),
							  new ZyElCheck("Circlet", 130, 10),
							  new ZyElCheck("Glove", 130, 45),
							  new ZyElCheck("Necro head", 130, 80),
							  new ZyElCheck("Helmet", 130, 115),
							  new ZyElCheck("Druit pelt", 130, 150),
							  new ZyElCheck("Primal helmet", 250, 10),
							  new ZyElCheck("Ring", 250, 45),
							  new ZyElCheck("Shield", 250, 80),
							  new ZyElCheck("Torso armor", 250, 115)};
	
	final ZyElCheck[] Weapons = {new ZyElCheck("Amazon bow", 10, 10),
	                             new ZyElCheck("Amazon javelin", 10, 45),
								 new ZyElCheck("Amazon spear", 10, 80),
								 new ZyElCheck("Axe", 10, 115),
								 new ZyElCheck("Blunt", 10, 150),
								 new ZyElCheck("Bow", 10, 185),
								 new ZyElCheck("Club", 10, 220),
								 new ZyElCheck("Claw", 130, 10),
								 new ZyElCheck("Hammer", 130, 45),
								 new ZyElCheck("Javelin", 130, 80),
								 new ZyElCheck("Knife", 130, 115),
								 new ZyElCheck("Mace", 130, 150),
								 new ZyElCheck("Melee", 130, 185),
								 new ZyElCheck("Missile", 130, 220),
								 new ZyElCheck("Orb", 250, 10),
								 new ZyElCheck("Polearm", 250, 45),
								 new ZyElCheck("Rod", 250, 80),
								 new ZyElCheck("Scepter", 250, 115),
								 new ZyElCheck("Spear", 250, 150),
								 new ZyElCheck("Staff", 250, 185),
								 new ZyElCheck("Sword", 250, 220),
								 new ZyElCheck("Throw axe", 370, 10),
								 new ZyElCheck("Thrown", 370, 45),
								 new ZyElCheck("Throw knife", 370, 80),
								 new ZyElCheck("Wand", 370, 115),
								 new ZyElCheck("Crossbow", 370, 150),
								 new ZyElCheck("Any", 370, 185)};
	
	final ZyElCheck[] Charms = {new ZyElCheck("Hex", 10, 10),
								new ZyElCheck("Large", 10, 45),
								new ZyElCheck("Any", 10, 80),
								new ZyElCheck("Narrow", 10, 115),
								new ZyElCheck("Quad", 10, 150),
								new ZyElCheck("Small", 10, 185),
								new ZyElCheck("Tall", 10, 220)};
	
	final ZyElResult ResultWindow = new ZyElResult();
	final ZyElNew FileNewWindow = new ZyElNew();

    final Panel SockPanel = new Panel("Sockets", Sockets, 5, 135, 130, 75),
          ClassPanel = 	new Panel("Classes", Classes, 140, 30, 260, 180),
		  ItemsPanel = 	new Panel("Items", Items, 405, 30, 390, 180),
		  WeaponsPanel = 	new Panel("Weapons", Weapons, 5, 240, 465, 250),
		  CharmsPanel = new Panel("Charms", Charms, 475, 240, 130, 250);
	
	private GroupBox Level;
	
	class GroupBox extends TitledPane{
		Pane content;
		
		GroupBox(String name, int width, int height, boolean collapsible){
			content = new Pane();
			setText(name);
			content.setPrefSize(width, height);
			setContent(content);
			setCollapsible(collapsible);
		}
		
		public void addItem(Node item){
			content.getChildren().add(item);
		}
	}
	
	class Panel extends GroupBox{
		Panel(String name, ZyElCheck[] checks, int x, int y, int width, int height){
			super(name, width, height, false);
			for(ZyElCheck i:checks)
				addItem(i);
			relocate(x, y);
		}
	}
	
	class ZyElCheck extends CheckBox{
		private int x, y;
		ZyElCheck(String name, int x, int y){
			super(name);
			relocate(x, y);
		}
	}
	
	public static void main(String[] args){
		launch();
	}
	
	public void start(Stage stg){
		
		stg.setTitle("ZyEl Runeword");
		
		Scene scn = new Scene(new Pane(), mainWinWidth, mainWinHeight);
		stg.setResizable(false);
		
		MenuBar Bar = CreateMenuBar();
		Level  =  CreateLevelGroupBox();
		
		Process.relocate(640, 480);
		Process.setPrefSize(130, 30);
		
		Process.setOnAction((ActionEvent event) -> {
			ResultWindow.show();
		});
		
		((Pane)scn.getRoot()).getChildren().addAll(Bar, Level, SockPanel, 
															   ClassPanel, 
															   ItemsPanel, 
															   WeaponsPanel,
															   CharmsPanel, Process);
		stg.setScene(scn);
		stg.show();
	}
	
	MenuBar CreateMenuBar(){
		Menu File     = new Menu("File"),
		     Settings = new Menu("Settings"),
			 Help     = new Menu("Help");
			 
		MenuItem New  = new MenuItem("New"),
		         Open = new MenuItem("Open"),
			     Save = new MenuItem("Save"),
			     Exit = new MenuItem("Exit"),
				 About = new MenuItem("About");
		
		RadioMenuItem Eng = new RadioMenuItem("English"),
		              Rus = new RadioMenuItem("Русский");
	    
		ToggleGroup toggleGroup = new ToggleGroup();
		Eng.setToggleGroup(toggleGroup);
		Eng.setSelected(true);
		
		Eng.setOnAction((ActionEvent event) -> {
			if(ZyElLang.getCurrent().equals("Rus")){
			  File.setText("File");
			  Settings.setText("Settings");
			  Help.setText("Help");
			  New.setText("New");
			  Open.setText("Open");
			  Save.setText("Save");
			  Exit.setText("Exit");
			  About.setText("About");
			  Process.setText("Process");
			  Level.setText("Level");
			  SockPanel.setText("Sockets");
			  ClassPanel.setText("Classes");
			  ItemsPanel.setText("Items");
			  WeaponsPanel.setText("Weapons");
			  CharmsPanel.setText("Charms");
			  Min.setText("Minimum");
			  Max.setText("Maximum");
			  ZyElLang.toggle();
			  updateText(Classes, ZyElLang.getCurrentCls());
			  updateText(Items, ZyElLang.getCurrentItems());
			  updateText(Weapons, ZyElLang.getCurrentWeapons());
			  updateText(Charms, ZyElLang.getCurrentTalismans());
			}
		});
		Rus.setToggleGroup(toggleGroup);
		Rus.setSelected(false);
		Rus.setOnAction((ActionEvent event) -> {
			if(ZyElLang.getCurrent().equals("Eng")) {
			  File.setText("Файл");
			  Settings.setText("Настройки");
			  Help.setText("Справка");
			  New.setText("Новый");
			  Open.setText("Открыть");
			  Save.setText("Сохранить");
			  Exit.setText("Выход");
			  About.setText("О програме");
			  Process.setText("Обработать");
			  Level.setText("Уровень");
			  SockPanel.setText("Сокеты");
			  ClassPanel.setText("Классы");
			  ItemsPanel.setText("Предметы");
			  WeaponsPanel.setText("Оружие");
			  CharmsPanel.setText("Талисманы");
			  Min.setText("Минимум");
			  Max.setText("Максимум");
			  ZyElLang.toggle();
			  updateText(Classes, ZyElLang.getCurrentCls());
			  updateText(Items, ZyElLang.getCurrentItems());
			  updateText(Weapons, ZyElLang.getCurrentWeapons());
			  updateText(Charms, ZyElLang.getCurrentTalismans());
			}
		});
		
		New.setOnAction((ActionEvent event) -> {
			FileNewWindow.showWindow();
		});
		
		File.getItems().addAll(New, new SeparatorMenuItem(), Open, Save, new SeparatorMenuItem(), Exit);
		Settings.getItems().addAll(Eng, Rus);
		Help.getItems().addAll(About);
		
		
		MenuBar ret = new MenuBar();
		ret.setPrefWidth(mainWinWidth+8);
		ret.getMenus().addAll(File, Settings, Help);
		return ret;
	}
	
	GroupBox CreateLevelGroupBox(){
		GroupBox Level = new GroupBox("Level", 130, 75, false);
		TextField MinText = new TextField(),
		          MaxText = new TextField();
		
		Min.relocate(10, 10);
		MinText.relocate(80, 10);
		MinText.setPrefWidth(40);
		Max.relocate(10, 40);
		MaxText.relocate(80, 40);
		MaxText.setPrefWidth(40);
		Level.addItem(Min);
		Level.addItem(Max);
		Level.addItem(MinText);
		Level.addItem(MaxText);
		Level.relocate(5, 30);
		return Level;
	}
	
	void updateText(ZyElCheck[] checks, String[] names){
		for(int i = 0; i < checks.length; i++){
			checks[i].setText(names[i]);
		}
	}
}