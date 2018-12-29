/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcheckbox;

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
public class FxCheckBox extends Application implements EventHandler{
    
    CheckBox cbSmartphone,
             cbTablet,
             cbNotebook,
             cbDescktop;
    
    Label    response,
             selected;
    
    String   computers;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void start(Stage stg){
        stg.setTitle("Демонстрация FxCheckBox");
        
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10, 10);
        
        rootNode.setAlignment(Pos.CENTER);
        
        Scene scn = new Scene(rootNode, 230, 200);
        stg.setScene(scn);
        
        Label head = new Label("Список устройств:");
        selected = new Label("");
        response = new Label("");
        cbSmartphone = new CheckBox("Смартфон");
        cbTablet = new CheckBox("Планшет");
        cbNotebook = new CheckBox("Ноутбук");
        cbDescktop = new CheckBox("ПК");
        
        cbSmartphone.setAllowIndeterminate(true); // third state
        cbSmartphone.setOnAction((ActionEvent e) ->{
            if(cbSmartphone.isIndeterminate())
            {
                response.setText("Смартфон в третьем состоянии");
                showAll();
            } else handle(e);
        });
        
        cbTablet.setOnAction(this);
        cbNotebook.setOnAction(this);
        cbDescktop.setOnAction(this);
        
        rootNode.getChildren().addAll(head, cbSmartphone, cbTablet, cbNotebook, cbDescktop, response, selected);
        stg.show();
        showAll();
    }
    
    @Override
    public void handle(Event e){
        CheckBox cb = (CheckBox)e.getSource();
        if(cb.isSelected())
            response.setText(cb.getText() + " выбран");
        else
            response.setText(cb.getText() + " очищен");
        showAll();
    }
    
    void showAll(){
        computers = "";
        if(cbSmartphone.isSelected()) computers = "Смартфон ";
        if(cbTablet.isSelected()) computers += "Планшет ";
        if(cbNotebook.isSelected()) computers += "Ноутбук ";
        if(cbDescktop.isSelected()) computers += "ПК ";
        
        selected.setText("Выбранные устройства: " + computers);
    }
    
}
