/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfieldswing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Vladimir Hrechko
 */
class ActCmd{
    static final String TXTF_CMD  = "cmd_1";
    static final String BTN_CMD = "cmd_2";
}

public class TextFieldSwing implements ActionListener{
    
    JLabel inLbl_2, inLbl_1;
    JTextField textF;
    
    TextFieldSwing(){
        JFrame mainWin = new JFrame("Демонстрация TextField");
        mainWin.setLayout(new FlowLayout());
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setSize(500, 250);
        
        textF = new JTextField(10);
        textF.setActionCommand(ActCmd.TXTF_CMD);
        textF.addActionListener(this);
        
        JButton btn = new JButton("Реверс");
        btn.setActionCommand(ActCmd.BTN_CMD);
        btn.addActionListener(this);
        
        inLbl_1 = new JLabel("Введите текст:");
        inLbl_2 = new JLabel("");
        
        mainWin.add(inLbl_1);
        mainWin.add(inLbl_2);
        mainWin.add(textF);
        mainWin.add(btn);
        
        mainWin.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent eId){
        if(eId.getActionCommand().equals(ActCmd.BTN_CMD)){
            String orgStr = textF.getText();
            String resStr = "";
            for(int i = orgStr.length() - 1; i >= 0; i--)
                resStr += orgStr.charAt(i);
            
            inLbl_2.setText(resStr);
        } else
            inLbl_1.setText("Вы нажали Enter. Текст: " + inLbl_2.getText());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable (){
            public void run(){
                new TextFieldSwing();
            }
        });
        
    }
    
}
