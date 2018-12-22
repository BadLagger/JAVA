/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trysimpleswing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Buttons{
    static final String GO_BTN = "Поехали!";
    static final String CLEAN_BTN = "Очистить";
}
/**
 *
 * @author Vladimir Hrechko
 */
public class TrySimpleSwing implements ActionListener {
        JLabel jlab;
        TrySimpleSwing(){
            JFrame jfrm = new JFrame("Простое Swing приложение");
            
            jfrm.setLayout(new FlowLayout());
            jfrm.setSize(400, 200);
            
            jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JButton goBtn    = new JButton(Buttons.GO_BTN);
            JButton cleanBtn = new JButton(Buttons.CLEAN_BTN);
            
            goBtn.addActionListener(this);
            cleanBtn.addActionListener(this);
            
            jlab = new JLabel("qwe");
            jfrm.add(goBtn);
            jfrm.add(cleanBtn);
            jfrm.add(jlab);
            jfrm.setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals(Buttons.GO_BTN)){
                jlab.setText(Buttons.GO_BTN);
            } else if(ae.getActionCommand().equals(Buttons.CLEAN_BTN)){
                jlab.setText("");
            }
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                new TrySimpleSwing();
            }
        });
    }
}
