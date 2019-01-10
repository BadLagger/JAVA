package badlagger.css.checker;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.event.*;

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
					mAbout;
	private MenuItem mFileNew,
					 mFileOpen,
					 mFileClose,
					 mFileExit;
	private Alert    aAbout;
	private Label    lAbout;
	private CheckMenuItem 	mViewButton,
							mViewLabel,
							mViewText;
	private Button  mfBtn;
	/* Launch app */
	public static void main(String[] args){ launch(); }
	/* Start app*/
	@Override
	public void start(Stage stg){

		stg.setTitle(Title + version);
		stg.setResizable(false);
		
		Scene scn = new Scene(new Pane(), width, height);
		
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
		mEdit = new Menu("Edit");
		mView = new Menu("View");
		mAbout = new Menu();
		/* Menu File */
		mFileNew = new MenuItem("New");
		mFileOpen = new MenuItem("Open");
		mFileClose = new MenuItem("Close");
		mFileExit = new MenuItem("Exit");
		mFile.getItems().addAll(mFileNew, mFileOpen, mFileClose, mFileExit);
		/* Menu Edit */
		/* Menu View */
		mViewButton = new CheckMenuItem("Button");
		mViewButton.setOnAction((ActionEvent e) ->{
			if(mViewButton.isSelected()){
				mfBtn.relocate(nextElementX, nextElementY); 
				mfBtn.setVisible(true);
			} else {
				mfBtn.setVisible(false);
			}
		});
		mViewLabel = new CheckMenuItem("Label");
		mViewText = new CheckMenuItem("Text");
		mView.getItems().addAll(mViewButton, mViewLabel, mViewText);
		/* Menu About */
		lAbout = new Label("About");
		lAbout.setOnMouseClicked((MouseEvent eId) -> {
			if(eId.getButton() == MouseButton.PRIMARY)
				aAbout.show();
		});
		mAbout.setGraphic(lAbout);
		mBar.getMenus().addAll(mFile, mEdit, mView, mAbout);
		/* Buttons */
		mfBtn = new Button("Check");
		mfBtn.setVisible(false);
		/* End of GUI creation */
		((Pane)scn.getRoot()).getChildren().addAll(mBar, mfBtn);
		stg.setScene(scn);
		stg.show();
	}
}