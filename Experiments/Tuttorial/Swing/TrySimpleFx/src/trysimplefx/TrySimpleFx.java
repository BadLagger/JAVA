/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trysimplefx;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import static java.lang.System.*;

/**
 *
 * @author Vladimir Hrechko
 */
public class TrySimpleFx extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println("Запуск приложения FX");
        launch();
    }
    
    @Override
    public void init(){
        out.println("В теле метода init()");
    }
    
    @Override
    public void start(Stage st){
        out.println("В теле метода start()");
        
        st.setTitle("Каркас приложения FX");
        
        FlowPane rootNode  = new FlowPane();
        Scene sc = new Scene(rootNode, 300, 200);
        st.setScene(sc);
        st.show();
    }
    
    @Override
    public void stop(){
        out.println("В теле метода stop()");
    }
}
