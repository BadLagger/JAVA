/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxlabel;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 *
 * @author Vladimir Hrechko
 */
public class FxLabel extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    public void start(Stage stg){
        stg.setTitle("Демонстрация Fx Label");
        
        FlowPane rootNode = new FlowPane();
        
        Scene scn = new Scene(rootNode, 300, 200);
        stg.setScene(scn);
        
        Label lbl = new Label("Метка");
        rootNode.getChildren().add(lbl);
        stg.show();
    }
}
