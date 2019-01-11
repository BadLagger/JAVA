package badlagger.css.checker;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.event.*;
import java.io.*;


public class FxCssChecker extends Application{
	/* Title & version */
	final private String Title   = "CSS checker ",
	                     version = "v.01.00"; 
	/* MainFrame parameters */
	private int width  = 640,
				height = 480;
				
	private int nextElementX = 10,
				nextElementY = 30;
	/* GUI elements */
	private MenuBar mBar;
	
	private Menu    mFile,
					mEdit,
					mView,
					mStyles,
					mAbout;
					
	private MenuItem mFileNew,
					 mFileOpen,
					 mFileClose,
					 mFileExit;
	private CheckMenuItem[] mStylesItems;
					 
	private SeparatorMenuItem 	mFileSep1, 
								mFileSep2;
								
	private Alert    aAbout;
	
	private Label    lAbout,
					 lEdit;
					 
	private CheckMenuItem 	mViewButton,
							mViewLabel,
							mViewText,
							mViewCheckbox,
							mViewRadiobtn;
							
	private Button      mfBtn;
	private Label       mfLabel;
	private TextField   mfText;
	private CheckBox    mfChbox;
	
	private RadioButton mfRadiobtn1,
						mfRadiobtn2;
	private Scene scn;
	/* Launch app */
	public static void main(String[] args){ launch(); }
	/* Start app*/
	@Override
	public void start(Stage stg){

		stg.setTitle(Title + version);
		stg.setResizable(false);
		
		scn = new Scene(new Pane(), width, height);
		/* Alerts (MSGBOX'S)*/
		aAbout = new Alert(Alert.AlertType.NONE, Title + version, ButtonType.OK);
		aAbout.setTitle("About");
		aAbout.getDialogPane().setPrefWidth(200);
		aAbout.getDialogPane().setPrefHeight(80);
		/* Menu Bar */
		mBar = new MenuBar();
		mBar.setPrefWidth(width + 10);  // !!! No SPIKE should be here
		/* MenuBar elements*/
		mFile = new Menu("File");
		mEdit = new Menu();
		mView = new Menu("View");
		mStyles  = new Menu("Styles");
		mAbout = new Menu();
		/* Menu File */
		mFileNew = new MenuItem("New");
		mFileSep1 = new SeparatorMenuItem();
		mFileSep2 = new SeparatorMenuItem();
		mFileOpen = new MenuItem("Open");
		mFileClose = new MenuItem("Close");
		mFileExit = new MenuItem("Exit");
		mFile.getItems().addAll(mFileNew, mFileSep1, mFileOpen, mFileClose, mFileSep2, mFileExit);
		/* Menu Edit */
		lEdit = new Label("Edit");
		lEdit.setOnMouseClicked((MouseEvent eId) ->{
			System.out.println("Edit");
		});
		mEdit.setGraphic(lEdit);
		/* Menu View */
		mViewButton = new CheckMenuItem("Button");
		mViewButton.setOnAction((ActionEvent e) ->{
			if(mViewButton.isSelected()){
				mfBtn.setVisible(true);
			} else {
				mfBtn.setVisible(false);
			}
		});
		mViewLabel = new CheckMenuItem("Label");
		mViewLabel.setOnAction((ActionEvent e) ->{
			if(mViewLabel.isSelected()){
				mfLabel.setVisible(true);
			} else {
				mfLabel.setVisible(false);
			}
		});
		mViewText = new CheckMenuItem("Text");
		mViewText.setOnAction((ActionEvent e) ->{
			if(mViewText.isSelected()){
				mfText.setVisible(true);
			} else {
				mfText.setVisible(false);
			}
		});
		mViewCheckbox = new CheckMenuItem("Checkbox");
		mViewCheckbox.setOnAction((ActionEvent e) ->{
			if(mViewCheckbox.isSelected()){
				mfChbox.setVisible(true);
			} else {
				mfChbox.setVisible(false);
			}
		});
		mViewRadiobtn = new CheckMenuItem("Radio button");
		mViewRadiobtn.setOnAction((ActionEvent e) ->{
			if(mViewRadiobtn.isSelected()){
				mfRadiobtn1.setVisible(true);
				mfRadiobtn2.setVisible(true);
			} else {
				mfRadiobtn1.setVisible(false);
				mfRadiobtn2.setVisible(false);
			}
		});
		mView.getItems().addAll(mViewButton, mViewLabel, mViewText, mViewCheckbox, mViewRadiobtn);
		/* Menu Styles*/
		File rootDir = new File(".\\styles");
		String[] strs = rootDir.list();
		mStylesItems = new CheckMenuItem[strs.length];
		for(int i = 0; i < strs.length; i++){
			mStylesItems[i] = new CheckMenuItem(strs[i]);
	        mStylesItems[i].setOnAction((ActionEvent e) -> StyleHndl(e));
			mStyles.getItems().add(mStylesItems[i]);
		}
		/* Menu About */
		lAbout = new Label("About");
		lAbout.setOnMouseClicked((MouseEvent eId) ->{
			if(eId.getButton() == MouseButton.PRIMARY)
				aAbout.show();
		});
		mAbout.setGraphic(lAbout);
		mBar.getMenus().addAll(mFile, mEdit, mView, mStyles, mAbout);
		/* Buttons */
		mfBtn = new Button("Check button");
		mfBtn.relocate(20, 120); 
		mfBtn.setVisible(false);
		/* Labels */
		mfLabel = new Label("Check label");
		mfLabel.relocate(20, 80); 
		mfLabel.setVisible(false);
		/* Texts */
		mfText = new TextField();
		mfText.setPrefSize(50, 15);
		mfText.relocate(100, 80); 
		mfText.setVisible(false);
		/* Checkboxes */
		mfChbox = new CheckBox("Check checkbox");
		mfChbox.setAllowIndeterminate(true);
		mfChbox.relocate(20, 50); 
		mfChbox.setVisible(false);
		/* Radiobuttons */
		ToggleGroup group = new ToggleGroup();
		mfRadiobtn1 = new RadioButton("Check radiobutton 1");
		mfRadiobtn1.relocate(200, 50); 
		mfRadiobtn1.setVisible(false);
		mfRadiobtn1.setToggleGroup(group);
		mfRadiobtn2 = new RadioButton("Check radiobutton 2");
		mfRadiobtn2.relocate(200, 80); 
		mfRadiobtn2.setVisible(false);
		mfRadiobtn2.setToggleGroup(group);
		/* End of GUI creation */
		((Pane)scn.getRoot()).getChildren().addAll(mBar, mfBtn, mfLabel, mfText, mfChbox, mfRadiobtn1, mfRadiobtn2);
		stg.setScene(scn);
		stg.show();
	}
	
	public void StyleHndl(ActionEvent eId){
		//ObservableList<String> styles;
		//File currentPath = new File("");
		CheckMenuItem menu = (CheckMenuItem)eId.getSource();
		//System.out.println(menu.getText() + " " + currentPath.getAbsolutePath());
		//scn.getStylesheets().add(getClass().getResource(currentPath.getAbsolutePath() + "\\styles\\" + menu.getText()).toExternalForm());
		//mBar.getStyleClass().add("menu-bar");
		if(menu.isSelected()) scn.getStylesheets().add(menu.getText());
		else scn.getStylesheets().remove(menu.getText());
	}
}