/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxeffects;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
/**
 *
 * @author Vladimir Hrechko
 */
public class FxEffects extends Application{

    double angle = 0.0;
    double scaleFactor = 0.4;
    double blurVal = 1.0;
    
    Reflection reflection = new Reflection();
    BoxBlur blur = new BoxBlur(1.0, 1.0, 1);
    Rotate rotate = new Rotate();
    Scale scale = new Scale(scaleFactor, scaleFactor);
    
    Button btnRot = new Button("Вертеть");
    Button btnBlur = new Button("Размытие");
    Button btnScale = new Button("Размер");
    
    Label reflect = new Label("Отражение добаляет визульный блеск");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    public void start(Stage stg){
        stg.setTitle("Демонстрация Fx эффектов");
        
        FlowPane rootNode = new FlowPane(20, 20);
        rootNode.setAlignment(Pos.CENTER);
        
        Scene scn = new Scene(rootNode, 300 , 120);
        stg.setScene(scn);
        
        btnRot.getTransforms().add(rotate);
        btnScale.getTransforms().add(scale);
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);
        
        btnRot.setOnAction((ActionEvent e) -> {
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(btnRot.getWidth()/2);
            rotate.setPivotY(btnRot.getHeight()/2);
        });
        
        btnScale.setOnAction((ActionEvent e) -> {
            scaleFactor += 0.1;
            if(scaleFactor > 2.0) scaleFactor = 0.4;
            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });
        
        btnBlur.setOnAction((ActionEvent e) -> {
            if(blurVal == 10.0){
                blurVal = 1.0;
                btnBlur.setEffect(null);
            }else {
                blurVal++;
                btnBlur.setEffect(blur);
            }
            blur.setWidth(blurVal);
            blur.setHeight(blurVal);
        });
        
        rootNode.getChildren().addAll(btnRot, btnScale, btnBlur, reflect);
        stg.show();
    }
    
}
