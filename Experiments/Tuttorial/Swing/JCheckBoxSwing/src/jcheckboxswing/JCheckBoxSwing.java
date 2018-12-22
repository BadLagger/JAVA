/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcheckboxswing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Vladimir Hrechko
 */
public class JCheckBoxSwing implements ItemListener{
    final String checkStr[] = {"Alpha", "Beta", "Gamma"};
    
    JLabel lbl[] = new JLabel[2];
    JCheckBox check[] = new JCheckBox[3];
    
    JCheckBoxSwing(){
        JFrame mainFrame = new JFrame("Демонстрация чекбоксов");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setSize(280, 120);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        for(int i = 0; i < check.length; i++){
            check[i] = new JCheckBox(checkStr[i]);
            check[i].addItemListener(this);
            mainFrame.add(check[i]);
        }
        
        for(int i = 0; i < 2; i++){
            lbl[i] = new JLabel("");
            mainFrame.add(lbl[i]);
        }
        
        mainFrame.setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent eId){
        String str = "";
        
        JCheckBox cb = (JCheckBox) eId.getItem();
        if(cb.isSelected())
            lbl[0].setText(cb.getText() + " выбрано.");
        else
            lbl[0].setText(cb.getText() + " снято.");
        
        for(int i = 0; i < check.length; i++){
            if(check[i].isSelected())
                str += checkStr[i];
        }
        
        lbl[1].setText(str);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JCheckBoxSwing();
            }
        });
    }
    
}
