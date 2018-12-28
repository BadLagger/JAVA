/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swng.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Vladimir Hrechko
 */
public class SwngApp extends JApplet {

    JButton btnUp, btnDown;
    JLabel  lbl;
    
    public void init() {
        try{
            SwingUtilities.invokeAndWait(()->{
                makeGUI();
            });
        }catch(Exception exc){
        
        }
    }
    
    private void makeGUI(){
        setLayout(new FlowLayout());
        btnUp = new JButton("Вверх");
        btnDown = new JButton("Вниз");
        btnUp.addActionListener((ActionEvent ae) -> {
            lbl.setText("Нажато вверх!!!");
        });
        btnDown.addActionListener((ActionEvent ae) -> {
            lbl.setText("Нажато вниз!!!");
        });
        add(btnUp);
        add(btnDown);
        lbl = new JLabel("Нажмите кнопку.");
        add(lbl);
    }
}
