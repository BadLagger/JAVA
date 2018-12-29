/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxlistwiew;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

/**
 *
 * @author Vladimir Hrechko
 */
public class FxListWiew extends Application{

    Label response;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    
    @Override
    public void start(Stage stg){
        stg.setTitle("Демонстрация FXListView");
        
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        
        Scene scn = new Scene(rootNode, 200, 100);
        stg.setScene(scn);
        
        response = new Label("Выберете тип устройства");
        
        ObservableList<String> devTypes = FXCollections.observableArrayList("Смартфон", "Планшет", "Ноутбук", "ПК");
        ListView<String> lvDevices = new ListView<>(devTypes);
        
        lvDevices.setPrefSize(100, 70);
        
        MultipleSelectionModel<String> lvSelectionModel = lvDevices.getSelectionModel();
        lvSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal){
                response.setText("Выбраное устройство: " + newVal);
            }
        });
        
        rootNode.getChildren().addAll(lvDevices, response);
        stg.show();
    }
}
