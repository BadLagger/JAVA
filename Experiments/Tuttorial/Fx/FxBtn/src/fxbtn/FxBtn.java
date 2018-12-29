/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxbtn;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

/**
 *
 * @author Vladimir Hrechko
 */
public class FxBtn extends Application{
    Label response;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stg){
        stg.setTitle("Демонстрация FxBtn");
        
        FlowPane rootNode = new FlowPane(10, 10);
        
        rootNode.setAlignment(Pos.CENTER);
        
        Scene scn = new Scene(rootNode, 300, 100);
        stg.setScene(scn);
        
        response = new Label("Нажми кнопку");
        Button btnUp   = new Button("Вверх"), 
               btnDown = new Button("Вниз");
        btnUp.setOnAction((ActionEvent e) -> {
            response.setText("Нажато Вверх");
        });
        
        btnDown.setOnAction((ActionEvent e) -> {
            response.setText("Нажато Вниз");
        });
        
        rootNode.getChildren().addAll(btnUp, btnDown, response);
        stg.show();
    }
    
}
