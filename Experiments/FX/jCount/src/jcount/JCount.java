/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcount;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author badLagger
 */
public class JCount extends Application {
    final String version = "0.01";
    Label msClick;
    long  msClickCount = 0;
    
    @Override
    public void start(Stage mainStage) {
        
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250, Color.DARKSEAGREEN);
        
        mainStage.setTitle("JCount v." + version);
        mainStage.setResizable(false);
       
        msClick = new Label("Количество кликов ПКМ: " + msClickCount);
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent ms) -> {
            if(ms.getButton() == MouseButton.PRIMARY)
            {
                msClickCount++;
                msClick.setText("Количество кликов ПКМ: " + msClickCount);
            }
        });
        
       
       // root.getChildren().addAll(msClick);
        mainStage.setScene(scene);
        mainStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
