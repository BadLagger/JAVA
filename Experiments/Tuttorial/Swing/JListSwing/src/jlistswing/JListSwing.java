/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlistswing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Vladimir Hrechko
 */
public class JListSwing implements ListSelectionListener{
    JList<String> jlist;
    JLabel jlab;
    JScrollPane jscrlp;
    final String names[] = {"Маша", "Саша", "Петя", "Вася"}; 
    
    JListSwing(){
        JFrame jfrm = new JFrame("Демонстрация JList");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(200, 160);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        jlist = new JList<String>(names);
        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        jscrlp = new JScrollPane(jlist);
        jscrlp.setPreferredSize(new Dimension(120, 90));
        
        jlab = new JLabel("Выберите имя");
        
        jlist.addListSelectionListener(this);
        
        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
    
    public void valueChanged(ListSelectionEvent le){
        int idx = jlist.getSelectedIndex();
        
        if(idx != -1)
            jlab.setText("Выбрано: " + names[idx]);
        else
            jlab.setText("Выберите имя");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            new JListSwing();
        });
        
    }
    
}
