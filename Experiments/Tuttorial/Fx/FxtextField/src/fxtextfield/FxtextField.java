/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxtextfield;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
/**
 *
 * @author Vladimir Hrechko
 */
public class FxtextField extends Application{

    TextField tf;
    Label response;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch();
    }
    
    @Override
    public void start(Stage stg){
        stg.setTitle("Демонтрация TextField");
        
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        
        Scene scn = new Scene(rootNode, 230, 140);
        stg.setScene(scn);
        
        response = new Label("Введите имя");
        
        Button btnGetText = new Button("Получить имя");
        
        tf = new TextField();
        
        tf.setPromptText("ваше имя");
        tf.setPrefColumnCount(15);
        
        tf.setOnAction((e) -> {
            response.setText("Имя - " + tf.getText());
        });
        
        Separator separator = new Separator();
        separator.setPrefWidth(180);
        rootNode.getChildren().addAll(tf, btnGetText, separator, response);
        stg.show();
    }
}
